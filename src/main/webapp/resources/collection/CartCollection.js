var app = app || {};

app.CartCollection = Backbone.Collection.extend({
    model: app.BookModel
});
