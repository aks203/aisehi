var app = app || {};

app.LibraryView = Backbone.View.extend({
    el: '#content',

    initialize: function( ) {
        app.bookCollection=new app.BookCollection();
        this.collection = app.bookCollection;
        var self=this;
        // The models are fetched asynchronously after the page is rendered.
        // When the fetch completes, Backbone fires the reset event,
        // as requested by the reset: true option, and our listener re-renders the view.
        this.collection.fetch({reset: true,
            success: function (response) {
            if(!response.length)
                self.$el.html("<p class ='messageTxt'> No book available in library now. Please visit later.");
            },
            error: function (model, response) {

                if(response.status==401)
                    return logout();
                self.$el.html("<p class ='messageTxt'>"+ response.responseJSON.message);
            },
            wait: true,
            headers: {'user_id' :getUserId()}});
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
        this.$el.empty();

    }
});