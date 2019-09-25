var app = app || {};

app.UserListView = Backbone.View.extend({
    el: '#content',

    events:{
    },

    initialize: function( ) {
        this.collection = new app.UserCollection();
        // The models are fetched asynchronously after the page is rendered.
        // When the fetch completes, Backbone fires the reset event,
        // as requested by the reset: true option, and our listener re-renders the view.
        this.collection.fetch({url: 'api/user',
            reset: true,
            success: function (model, response) {
                if (response.length==0){
                    alert("No user as of now. Go and do some marketing.");
                }
            },
            error: function (model, response) {
                if(response.status==401)
                    return logout();
                alert(response.responseJSON.message);
            },
            wait: true,
            headers: {'user_id' :getUserId()}
        });
        // this.render();
        this.listenTo( this.collection, 'reset', this.render );
    },

    render: function() {
        $("#content").empty();
        console.log("rendering user list view...");
        this.collection.each(function( item ) {
            this.renderUser( item );
        }, this );
    },

    // render a book by creating a BookView and appending the
    // element it renders to the library's element
    renderUser: function( item ) {
        var userView = new app.UserView({
            model: item
        });
        this.$el.append( userView.render().el );
    },

    destroy: function () {
        this.undelegateEvents();
        this.$el.removeData().unbind();
        this.$el.empty();

    }
});