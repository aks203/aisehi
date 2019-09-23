var app = app || {};

app.LoginView = Backbone.View.extend({
    el: $("#container"),

    template: _.template($('#login-template').html(), {interpolate: /\<\@\=(.+?)\@\>/gim}),

    events: {
        'click #login-btn': 'onLoginFormSubmit',
        'click #showRegister': 'showRegisterForm'
        // 'click #showLogin': 'showLoginForm',
    },

    initialize: function () {
        console.log("Login view initialized...");
        this.render();
    },

    showRegisterForm: function(e){
        e.preventDefault();
        debugger;
        this.destroy();
        new app.signupView({model: new app.User});
    },


    onLoginFormSubmit: function () {
        this.model.set({
            email: $(".email").val(),
            password: $(".password").val()
        });
        var self = this;
        this.model.save({
            type: "POST",
            contentType: "application/json"
        }, {
            success: function (model, response) {
                debugger;
                console.log("Login success");
                // if(response.status=="Error"){
                //     $("#loginMsg").html(response.msg);
                // }
                // else {
                sessionStorage.setItem("response", JSON.stringify(response));
                app.role = response.user.role;
                debugger;
                self.undelegateEvents();
                self.$el.empty();
                debugger;
                showDashboard(response);
            },
            error: function (model, response) {
                $("#loginMsg").html(response.responseJSON.message);
                debugger;
                console.log("Error: " + response + " .. ");
            }, wait: true
        });

    },

    render: function () {
        this.$el.html(this.template(this.model.toJSON()));
        return this;
    },

    destroy: function () {
        this.undelegateEvents();
        this.$el.removeData().unbind();
        debugger;
        this.$el.empty();

    }
});
