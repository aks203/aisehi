var app = app || {};
app.homeView = Backbone.View.extend({
    el:'#content',
    events:{
        'click #login':'onLogin',
        'click #register':'onRegister'
    },
    template:$("#homePage").html(),
      initialize:function(){
        this.render();
    },
    onLogin:function(){
       
    },
    render:function(){
        template:_.template(this.template);
        this.$el.html(this.template());
        return this;
    }
});
