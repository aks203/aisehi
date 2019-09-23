var app = app || {};

app.BookModel = Backbone.Model.extend({
    defaults: {
        coverImage: 'resources/images/placeholder.png',
        title: '',
        author: '',
        category: '',
        publisher: ''
    },
    idAttribute: 'book_id',
    // parse: function( response ) {
    //     response.coverImage = response.coverImage || 'resources/images/placeholder.png';
    //     return response;
    // },

    validate: function (attrs) {
        if (!attrs.title) {
            alert('Please fill title field.');
            return 'Please fill title field.';
        }
        if (!attrs.author) {
            alert('Please fill author field.');
            return 'Please fill author field.';
        }
        if (!attrs.category) {
            alert('Please fill category field.');
            return 'Please fill category field.';
        }
        if (!attrs.publisher) {
            alert('Please fill publisher field.');
            return 'Please fill publisher field.';
        }
    }
});