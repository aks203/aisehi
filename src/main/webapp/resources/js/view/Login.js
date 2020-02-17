var app = app || {};
app.loginView = Backbone.View.extend({
    el:'#content',
    template:_.template($("#loginPage").html()),
    events:{
        'click #loginbtn':'login',
        'click #backbutton':'backBtn'
    },
initialize:function(){
    this.render();
},
    login:function(){
        this.model.set({
            email: $("#email").val(),
            password:$("#password").val()
        });
        // var self = this;
        this.model.save({
            type:"POST",
            contentType:"application/json"
            },{
         success:function(model, response){
         console.log("Login successful");
         // self.$el.empty();
         showUserList(response);
         }
        });
        var v4 = new app.userView();
    },
    backBtn:function(){
        var v = new app.homeView();
    },
    render:function(){
     this.$el.html(this.template());
     return this;
    }
});