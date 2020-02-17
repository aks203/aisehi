var app = app || {};
app.homeView = Backbone.View.extend({
    el:'#content',
    events:{
        'click #login':'onLogin',
        'click #register':'onRegister'
    },
    template:_.template($("#homePage").html()),
      initialize:function(){
        this.render();
    },
    onLogin:function(e){
        e.preventDefault();
       var v1 = new app.loginView();
    },
    onRegister:function(e){
        e.preventDefault();
        var v2 = new app.registrationView({model: new app.User()});
    },
    render:function(){
        this.$el.html(this.template());
        return this;
    }
});
