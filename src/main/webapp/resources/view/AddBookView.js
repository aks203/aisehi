var app = app || {};

app.AddBookView = Backbone.View.extend({
    el: $("#content"),
    template: _.template($('#AddBookTemplate').html(), {interpolate: /\<\@\=(.+?)\@\>/gim}),

    initialize:function(){
        this.render();
    },
    // render library by rendering each book in its collection
    render: function() {
        this.$el.html(this.template(this.model.toJSON()));
    },

});



