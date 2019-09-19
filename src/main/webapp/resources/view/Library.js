var app = app || {};

app.LibraryView = Backbone.View.extend({
    el: '#content',

    events:{
        'click #addBookBtn':'addBook'
    },

    addBook: function( e ) {
        e.preventDefault();
        var formData = {};

        $( '#addBookForm div' ).children( 'input' ).each( function( i, el ) {
            if( $( el ).val() !== '' )
            {
                formData[ el.id ] = $( el ).val();
            }
        });
        this.collection.create( formData,
            {   wait: true,
                headers: {'user_id' :getUserId()},
                success: function (response){
                    alert("Book added successfully.")
                },
                error:function (model, error, response) {
                if(response.status==500){
                    alert(response.responseJSON.message);
                    return;
                }
                logout();
                }
            } );
        debugger;
        var frm=$("#addBookForm")[0];
        frm.reset();
    },

    initialize: function( ) {
        this.collection = new app.BookCollection();
        // The models are fetched asynchronously after the page is rendered.
        // When the fetch completes, Backbone fires the reset event,
        // as requested by the reset: true option, and our listener re-renders the view.
        this.collection.fetch({reset: true,
            success: function (response) {
               console.log(response.toJSON());
               debugger;
            },
            error: function (response) {
                console.log(response.toJSON());
                return logout();
            },
            wait: true,
            headers: {'user_id' :getUserId()}});
        debugger;
        this.render();
        this.listenTo( this.collection, 'reset', this.render );
    },

    // render library by rendering each book in its collection
    render: function() {
        $("#content").empty();
        console.log("rendering library view...");
        this.collection.each(function( item ) {
            this.renderBook( item );
        }, this );
    },

    // render a book by creating a BookView and appending the
    // element it renders to the library's element
    renderBook: function( item ) {
        var bookView = new app.BookView({
            model: item
        });
        this.$el.append( bookView.render().el );
    },

    destroy: function () {
        this.undelegateEvents();
        this.$el.removeData().unbind();
        debugger;
        this.$el.empty();

    }
});