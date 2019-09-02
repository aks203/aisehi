var app = app || {};

app.Auth = Backbone.Model.extend({
    url: '/login',

    defaults: {
        email: '',
        password: ''
    }
});