var app = app || {};
app.loginView = Backbone.View.extend({
    el:'#content',
    template:$("#loginPage").html(),
    events:{
        'click #login':'login'
    },
initialize:function(){
    this.render();
},
    login:function(){
        this.model.set({
            email: $("email").val(),
            password:$("password").val()
        });
        var self = this;
        this.model.save({
            type:"POST",
            contentType:"application/json"
            },{
         success:function(model, response){
         console.log("Login successful");
         self.$el.empty();
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
// var router = Backbone.Router.extend({
//    routes:{
// "back":"gotoRegister"
//    },
//     gotoRegister:function(){
//        var v1 = new app.registrationView();
//     }
// });
// var prouter = new router();