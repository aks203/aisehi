var app=app|| {};

app.LoginView=Backbone.View.extend({
    el: $("#container"),

    template: _.template($('#login-template').html(), {interpolate: /\<\@\=(.+?)\@\>/gim}),

    events: {
        'click #login-btn': 'onLoginFormSubmit',
        // 'click #showLogin': 'showLoginForm',
    },

    initialize:function(){
        console.log("Login view initialized...");
        this.render();
    },

    onLoginFormSubmit:function(e){
        this.model.set({
            email: $(".email").val(),
            password: $(".password").val()
        });
        this.model.save({
            type: "POST",
            contentType: "application/json"
        }, {success:function (model, response) {
                console.log("Login success");
                if(response.status=="Error"){
                    $("#loginMsg").html(response.msg);
                }
                else {
                    sessionStorage.setItem("user_id", response.user.id);
                    // app.user_id=response.user.id;
                    showDashboard();
                    console.log(sessionStorage.getItem("user_id"));
                }
            },
            error: function (model, response) {
                console.log("Error: " + response + " .. ");
            }, wait: true});

    },

    render:function () {
        this.$el.html(this.template(this.model.toJSON()));
        return this;
    }
});

function showLoginForm () {
    new app.LoginView({model: new app.Auth()})
};