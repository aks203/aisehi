var app = app || {};

app.AddBookView = Backbone.View.extend({
    el: '#content',
    template: _.template($('#AddBookTemplate').html(), {interpolate: /\<\@\=(.+?)\@\>/gim}),

    initialize:function(){
        debugger;
        this.render();
    },
    render: function() {
        debugger;
        this.$el.html(this.template());
    },

});



