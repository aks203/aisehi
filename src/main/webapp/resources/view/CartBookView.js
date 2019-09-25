var app=app||{};

app.CartBookView=Backbone.View.extend({
    tagname: 'div',
    classname: "cartBookContainer",
    model: app.BookModel,
    events: {
        'click .deleteFromCart':'deleteFromCart',
        'click .returnBook':'returnBook',

    },

returnBook:function(e){
    e.preventDefault();
    var book_id=this.model.attributes.book_id;
    var self=this;
    this.model.destroy({headers:{'user_id' :getUserId()},
            url: '/api/cart/return/'+getUserId()+'/'+book_id,
            wait: true,
            dataType: "text",
            success: function(model, response) {
                alert(response);
                self.remove();
            },
            error: function (model, response) {
                if(response.status==401)
                    return logout();
                alert(response.responseJSON.message);
            }});

    },
    deleteFromCart: function(e) {
        e.preventDefault();
        var book_id=this.model.attributes.book_id;
        var self=this;
        this.model.destroy({headers:{'user_id' :getUserId()},
            url: '/api/cart/'+getUserId()+'/'+book_id,
            wait: true,
            dataType: "text",
            success: function(model, response) {
                alert(response);
                self.remove();
            },
            error: function (model, response) {
                if(response.status==401)
                    return logout();
                alert(response.responseJSON.message);
            }});
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