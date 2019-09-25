var app=app||{};

app.UserView=Backbone.View.extend({
    tagname: 'div',
    classname: "userContainer",
    model: app.User,
    events: {
        'click .deleteUser': 'deleteUser',
    },

    deleteUser: function() {
        var id=this.model.attributes.id;
        var self=this;
        if(id==getUserId()){
            alert("Can't delete current user!");
            return;
        }
        this.model.destroy({headers:{'user_id' :getUserId()},
            url: '/api/user/'+id,
            wait: true,
            dataType: "text",
            success: function(model, response) {
                alert(response);
                self.remove();
            },
            error: function (model, response) {
                if(response.status==401)
                    return logout();
                if(response.responseJSON.message)
                    alert(response.responseJSON.message);
            }});
    },

    template: _.template($('#userTemplate').html(), {interpolate: /\<\@\=(.+?)\@\>/gim, evaluate: /\<\@(.+?)\@\>/gim}),

    initialize:function(){
        console.log("User initialized...");
        // componentHandler.upgradeDom();
        this.render();
    },
    render: function () {
        this.$el.html(this.template(this.model.attributes));
        return this;
    }
});