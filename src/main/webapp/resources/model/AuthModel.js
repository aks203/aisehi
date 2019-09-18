var app = app || {};

app.Auth = Backbone.Model.extend({
    url: '/login',

    defaults: {
        email: '',
        password: ''
    },

    validate: function (attrs) {
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