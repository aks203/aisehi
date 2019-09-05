var app = app || {};

app.LibraryView = Backbone.View.extend({
    el: '#content',
    model: app.BookCollection,

    initialize: function( initialBooks ) {
        this.collection = new app.BookCollection(initialBooks);
        this.render();
    },

    // render library by rendering each book in its collection
    render: function() {
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



