var app=app || {};

app.signupView = Backbone.View.extend({
    el: $("#container"),
    templateReg: _.template($('#register-template').html(), {interpolate: /\<\@\=(.+?)\@\>/gim}),

    events: {
        'click #register': 'onRegFormSubmit',
        'click #showRegister': 'showRegisterForm',
        'click #showLogin': 'showLoginForm'
    },

    initialize: function () {
        console.log(this.model);
        this.render();
    },

    showLoginForm:function(e) {
        e.preventDefault();
        this.destroy();
        app.loginView=new app.LoginView({model: new app.Auth()});
    },

    onRegFormSubmit: function (e) {
        e.preventDefault();
        this.model.set({
            name: $("#name").val(), email: $("#email").val(),
            password: $("#password").val(), language: $("#language").val(),role: $("#role:checked").val()
        });
        this.model.save({
            type: "POST",
            contentType: "application/json"
        },{success:function (model, response) {
                $("#regMsg").html(response.msg);
                console.log(response.msg);
            },
            error: function (model, response) {
                $("#regMsg").html(response.responseJSON.message);
            }, wait: true});
    },

    render: function() {
        this.$el.html(this.templateReg(this.model.toJSON()));
        return this;
    },

    destroy: function () {
        this.undelegateEvents();
        this.$el.removeData().unbind();
        this.$el.empty();

    }
});

