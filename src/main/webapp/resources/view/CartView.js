var app = app || {};

app.CartView = Backbone.View.extend({
    el: '#content',

    events:{
    },

    initialize: function(options) {
        this.collection = new app.CartCollection();
        app.type=options.type;
        debugger;
        // The models are fetched asynchronously after the page is rendered.
        // When the fetch completes, Backbone fires the reset event,
        // as requested by the reset: true option, and our listener re-renders the view.
        this.collection.fetch({url: 'api/cart/'+getUserId()+'/'+app.type,
            reset: true,
            error: function (model, response) {
                if(response.status==401)
                    return logout();
                if(response.responseJSON.message!=null)
                    alert(response.responseJSON.message);
            },
            wait: true,
            headers: {'user_id' :getUserId()}
        });
        // this.render();
        this.listenTo( this.collection, 'reset', this.render );
    },


    // render library by rendering each book in its collection
    render: function() {
        $("#content").empty();
        debugger;
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
        // cartBookView.model.set({type: type});
        debugger;
        this.$el.append( cartBookView.render().el );
    },

    destroy: function () {
        this.undelegateEvents();
        this.$el.removeData().unbind();
        this.$el.empty();

    }
});