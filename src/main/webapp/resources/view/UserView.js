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
        $.ajax({
            url: '/api/user/'+id,
            type: 'DELETE',
            wait: true,
            headers: {'user_id' :getUserId()},
            success: function(result) {
                debugger;
                self.remove();
                alert(result);
            },
            error: function (response) {
                debugger;
                if(response.status==401)
                    return logout();
                alert(response.responseJSON.message);
            }
        });
        this.model.destroy();
        debugger;
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