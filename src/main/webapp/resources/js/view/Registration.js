var app= app || {};
app.registrationView = Backbone.View.extend({
   el:"#content",
    events:{
       'click #registerbtn':'register',
        'click #backbutton1':'backBtn'
    },
   template:_.template($("#registerPage").html()),
   initialize:function(){
       this.render();
   },
    register:function(){
       this.model.set({
           id:$("#id").val(),
           firstname:$("#firstname").val(),
          lastname:$("#lastname").val(),
           username:$("#username").val(),
           email:$("#email").val(),
           password:$("#password").val()
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
    backBtn:function(){
       var v3 = new app.homeView();
    },
render:function(){
       this.$el.html(this.template());
       return this;
}
});
