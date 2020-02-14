var app= app || {};
app.registrationView = Backbone.View.extend({
   el:"#content",
    events:{
       'click #register':'register'
    },
   template:$("#registerPage").html(),
   initialize:function(){
       this.render();
   },
    register:function(){
       this.model.set({
           id:$("id").val(),
           firstname:$("firstname").val(),
          lastname:$("lastname").val(),
           username:$("username").val(),
           email:$("email").val(),
           password:$("password").val()
       });
       this.model.save({
           type: "POST",
           contentType: "application/json"
       },{
           success:function (model, response) {
               console.log("Registration successful");
               console.log(response.msg);
           }
       });
    },
render:function(){
       template:_.template(this.template);
       this.$el.html(this.template(this.model.toJSON()));
       return this;
}
});

var router = Backbone.Router.extend({
    routes:{
        "backbutton":"gotoLogin"
    },
    gotoLogin:function(){
        var v1 = new app.loginView();
    }
});
var prouter = new router();