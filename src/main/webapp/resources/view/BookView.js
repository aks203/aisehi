var app=app||{};

app.BookView=Backbone.View.extend({
    tagname: 'div',
    classname: "bookContainer",
    model: app.BookModel,
    events: {
        'click .deleteBook': 'deleteBook',
        'click .addToCart': 'addToCart'
    },

    addToCart: function(){
        var book_id=this.model.attributes.book_id;
        debugger;
        var user_id=getUserId();
        $.ajax({
            url: '/api/cart/add/'+user_id+'/'+book_id,
            type: 'POST',
            wait: true,
            headers: {'user_id' :user_id},
            success: function(result) {
                debugger;
                alert(result);
            }
        });
    },

    deleteBook: function() {
        var id=this.model.attributes.book_id;
        var self=this;
        $.ajax({
            url: '/api/books/'+id,
            type: 'DELETE',
            wait: true,
            headers: {'user_id' :getUserId()},
            success: function(result) {
                debugger;
                alert(result);
                if(result=="Successfully deleted."){
                    self.remove();
                }
            }
        });
        this.model.destroy();
        debugger;
    },

    template: _.template($('#bookTemplate').html(), {interpolate: /\<\@\=(.+?)\@\>/gim, evaluate: /\<\@(.+?)\@\>/gim}),

    initialize:function(){
        console.log("Book initialized...");
        // componentHandler.upgradeDom();
        this.render();
    },
    render: function () {
        this.$el.html(this.template(this.model.attributes));
        return this;
    }
})