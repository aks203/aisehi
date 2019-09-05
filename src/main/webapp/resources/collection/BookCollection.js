var app = app || {};

app.BookCollection = Backbone.Collection.extend({
    model: app.BookModel,
    url: '/api/books'
});
