var app=app||{};

app.BookView=Backbone.View.extend({
    tagname: 'div',
    classname: "bookContainer",
    model: app.BookModel,
    events: {
        'click .deleteBook': 'deleteBook'
    },

    deleteBook: function() {
        var id=this.model.attributes.id;
        var self=this;
        $.ajax({
            url: '/api/books/'+id,
            type: 'DELETE',
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

    template: _.template($('#bookTemplate').html(), {interpolate: /\<\@\=(.+?)\@\>/gim}),

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