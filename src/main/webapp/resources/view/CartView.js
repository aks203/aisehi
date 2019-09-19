var app = app || {};

app.CartView = Backbone.View.extend({
    el: '#content',

    events:{
    },

    initialize: function( ) {
        this.collection = new app.CartCollection();
        // The models are fetched asynchronously after the page is rendered.
        // When the fetch completes, Backbone fires the reset event,
        // as requested by the reset: true option, and our listener re-renders the view.
        this.collection.fetch({url: 'api/cart/'+getUserId(),
            reset: true,
            success: function (response) {
                if (response.length==0){
                    alert("Cart Empty. Please add some books.");
                }
                console.log(response.toJSON());
                debugger;
            },
            error: function (response) {
                console.log(response.toJSON());
                debugger;
                return logout();
            },
            wait: true,
            headers: {'user_id' :getUserId()}});
        // this.render();
        this.listenTo( this.collection, 'reset', this.render );
    },

    // render library by rendering each book in its collection
    render: function() {
        $("#content").empty();
        console.log("rendering cart view...");
        this.collection.each(function( item ) {
            this.renderBook( item );
        }, this );
    },

    // render a book by creating a BookView and appending the
    // element it renders to the library's element
    renderBook: function( item ) {
        var cartBookView = new app.CartBookView({
            model: item
        });
        this.$el.append( cartBookView.render().el );
    },

    destroy: function () {
        this.undelegateEvents();
        this.$el.removeData().unbind();
        debugger;
        this.$el.empty();

    }
});