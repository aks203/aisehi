var app = app || {};

    app.User = Backbone.Model.extend({
    url: '/register',

    defaults: {
        name: '',
        email: '',
        password: '',
        language: '',
        role: ''
    }
});