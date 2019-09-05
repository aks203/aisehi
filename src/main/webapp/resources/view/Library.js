var app = app || {};

app.LibraryView = Backbone.View.extend({
    el: '#content',
    model: app.BookCollection,

    events:{
        'click #addBookBtn':'addBook'
    },

    addBook: function( e ) {
        e.preventDefault();
        var formData = {};

        $( '#addBookForm div' ).children( 'input' ).each( function( i, el ) {
            debugger;
            if( $( el ).val() !== '' )
            {
                formData[ el.id ] = $( el ).val();
            }
        });
        this.collection.add( new app.BookModel( formData ) );
        alert("Book added successfully.")
        var frm=$("#addBookForm")[0];
        frm.reset();
    },

    initialize: function( initialBooks ) {
        this.collection = new app.BookCollection(initialBooks);
        this.render();
    },

    // render library by rendering each book in its collection
    render: function() {
        $("#content").empty();
        console.log("rendering library view...")
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
    }
});



