var app = app || {};

app.BookModel = Backbone.Model.extend({
    defaults: {
        coverImage: 'resources/images/placeholder.png',
        title: 'No title',
        author: 'Unknown',
        category: 'Unknown',
        publisher: 'None'
    },
    idAttribute: 'book_id'
    // this will let us delete the books, we edit the server response before it
    // is passed to model constructor, so we chagne _id to id
    // parse: function (response) {
    //     debugger;
    //     response.id = response.book_id;
    //     return response;
    // }
});