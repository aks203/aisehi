var app=app||{};

app.CartBookView=Backbone.View.extend({
    tagname: 'div',
    classname: "cartBookContainer",
    model: app.BookModel,
    events: {
        'click .deleteFromCart':'deleteFromCart'
    },

    deleteFromCart: function() {
        var book_id=this.model.attributes.book_id;
        var self=this;
        $.ajax({
            url: '/api/cart/'+getUserId()+'/'+book_id,
            type: 'DELETE',
            wait: true,
            headers: {'user_id' :getUserId()},
            success: function(result) {
                alert(result);
                if(result=="Successfully deleted."){
                    self.remove();
                }
            },
            error: function (response) {
                debugger;
                if(response.status==401)
                    return logout();
                alert(response.responseJSON.message);
            }
        });
        // this.model.destroy();
        debugger;
    },

    template: _.template($('#cartTemplate').html(), {interpolate: /\<\@\=(.+?)\@\>/gim, evaluate: /\<\@(.+?)\@\>/gim}),

    initialize:function(){
        console.log("Book initialized...");
        // componentHandler.upgradeDom();
        this.render();
    },
    render: function () {
        this.$el.html(this.template(this.model.attributes));
        return this;
    }
});