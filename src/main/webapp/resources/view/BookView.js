var app=app||{};

app.BookView=Backbone.View.extend({
    tagname: 'div',
    classname: "bookContainer",
    model: app.BookModel,
    events: {
        'click .deleteBook': 'deleteBook',
        'click .addToCart': 'addToCart',
        'click .showUpdateBookView': 'showUpdateBookView'
    },

    showUpdateBookView: function () {
        $("#currentView").empty().append("Update this Book");
        showView(new app.UpdateBookView({item:this.model}));
    },

    addToCart: function(){
        var book_id=this.model.attributes.book_id;
        var user_id=getUserId();
        $.ajax({
            url: '/api/cart/add/'+user_id+'/'+book_id,
            type: 'POST',
            wait: true,
            headers: {'user_id' :user_id},
            success: function(result) {
                alert(result);
            },
            error: function (response) {
                if(response.status==401)
                    return logout();
                if(response.responseJSON.message)
                    alert(response.responseJSON.message);
            }
        });
    },

    deleteBook: function() {
        var id=this.model.attributes.book_id;
        var self=this;
        this.model.destroy({headers:{'user_id' :getUserId()},
            url: '/api/books/'+id,
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
});