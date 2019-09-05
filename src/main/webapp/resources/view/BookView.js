var app=app||{};

app.BookView=Backbone.View.extend({
    tagname: 'div',
    classname: "bookContainer",


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