var app=app || {};

app.signupView = Backbone.View.extend({
    el: $("#container"),
    // template: _.template($('#userTemplate').html(), {interpolate: /\<\@\=(.+?)\@\>/gim}),
    templateReg: _.template($('#register-template').html(), {interpolate: /\<\@\=(.+?)\@\>/gim}),

    events: {
        'click #register': 'onRegFormSubmit',
        'click #showRegister': 'showRegisterForm'
    },

    initialize: function () {
        console.log(this.model);
        this.render();
    },

    showRegisterForm: function(e){
      this.render();
    },

    onRegFormSubmit: function (e) {
        // e.preventDefault();
        this.model.set({
            name: $("#name").val(), email: $("#email").val(),
            password: $("#password").val(), phone: $("#phone").val(), language: $("#language").val()
        });
        var o=this;
        this.model.save({
            type: "POST",
            contentType: "application/json"
        },{success:function (model, response) {
                $("#regMsg").html(response.msg);
                console.log(response.msg);
            },
            error: function (model, response) {
                console.log('error! ' + response);
                $("#regMsg").html("Error creating user. Please try again..")
            }, wait: true});
    },

    render: function() {
        this.$el.html(this.templateReg(this.model.toJSON()));
        return this;
    }
});

$(document).ready(function () {
    debugger;
    if(JSON.parse(sessionStorage.getItem("response"))==null) {
        debugger;
        new app.signupView({model: new app.User});
    }
    else {
        console.log(JSON.parse(sessionStorage.getItem("response")));
        debugger;
        showDashboard(JSON.parse(sessionStorage.getItem("response")));
    }
})
