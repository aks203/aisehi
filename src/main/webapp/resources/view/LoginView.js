var app=app|| {};

app.LoginView=Backbone.View.extend({
    el: $("#container"),

    template: _.template($('#login-template').html(), {interpolate: /\<\@\=(.+?)\@\>/gim}),

    events: {
        'click #login-btn': 'onLoginFormSubmit'
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
        var self=this;
        this.model.save({
            type: "POST",
            contentType: "application/json"
        }, {success:function (model, response) {
            debugger;
                console.log("Login success");
                if(response.status=="Error"){
                    $("#loginMsg").html(response.msg);
                }
                else {
                    sessionStorage.setItem("response", JSON.stringify(response));
                    app.role=response.user.role;
                    debugger;
                    // app.user_id=response.user.id;
                    self.undelegateEvents();
                    self.$el.empty();
                    // $(self.el).clear();
                    debugger;
                    showDashboard(response);
                    console.log(sessionStorage.getItem("response"));
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
