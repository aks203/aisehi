var app = app || {};

app.User = Backbone.Model.extend({
    url: '/register',

    defaults: {
        userImage: 'resources/images/user.jpg',
        id: '',
        name: '',
        email: '',
        password: '',
        language: '',
        role: ''
    },

    validate: function (attrs) {
        if (!attrs.name) {
            alert('Please fill name field.');
            return 'Please fill name field.';
        }
        if (!attrs.email) {
            alert('Please fill email field.');
            return 'Please fill email field.';
        }
        if (!attrs.password) {
            alert('Please fill password field.');
            return 'Please fill password field.';
        }
    }
});