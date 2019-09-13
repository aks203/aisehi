var app = app || {};

app.DashboardView = Backbone.View.extend({
    el: $("#container"),

    events: {
        'click #addNewBook': 'showAddBookView',
        'click #home': 'showLibrary',
        'click #browse': 'showLibrary',
        'click #showCart': 'showCart'
    },

    destroy: function () {
        this.undelegateEvents();
        this.$el.removeData().unbind();
        this.$el.empty();
    },

    showCart: function () {
        $("#currentView").empty().append("Cart");

        if (app.DashboardView.cartView != null) {
            var self = app.DashboardView.cartView;
            self.undelegateEvents();
            self.$el.removeData().unbind();
            self.$el.empty();
        }
        app.DashboardView.cartView = new app.CartView();
    },

    showLibrary: function () {
        debugger;
        $("#currentView").empty().append("Books");
        if (app.DashboardView.libraryView != null) {
            app.DashboardView.libraryView.render();
        }
        else {
            app.DashboardView.libraryView = new app.LibraryView();
        }
    },

    showAddBookView: function () {
        debugger;
        $("#currentView").empty().append("Add new Book");
        debugger;
        new app.AddBookView();
    },

    template: _.template($('#headerTemplate').html(), {
        interpolate: /\<\@\=(.+?)\@\>/gim,
        evaluate: /\<\@(.+?)\@\>/gim
    }),

    initialize: function () {
        console.log("Dashboard initialized...");
        console.log("Header rendered...")
        this.render();
        this.showLibrary();
    },
    render: function () {
        this.$el.html(this.template(this.model.toJSON()));
        componentHandler.upgradeDom();
        return this;
    }
})