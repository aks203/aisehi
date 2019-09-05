var app = app || {};

    app.BookModel = Backbone.Model.extend({
    defaults: {
        coverImage: 'resources/images/placeholder.png',
        title: 'No title',
        author: 'Unknown',
        category: 'Unknown',
        publisher: 'None'
    }
});