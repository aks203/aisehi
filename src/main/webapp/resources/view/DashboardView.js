var app = app || {};

app.DashboardView = Backbone.View.extend({
    el: $("#container"),

    events: {
        'click #addNewBook': 'showAddBookView',
        'click #home': 'showLibrary',
        'click #browse': 'showLibrary',
        'click #showCart': 'showCart',
        'keyup #search': 'search'
    },

    search: function(e){
            setTimeout(function () {
                $(".bookItem").removeClass('hide');
                $(".bookItem").removeClass('show');
                var g=$(e.target).val().toLowerCase();
                $(".bookItem .bookContent").each(function() {
                    var s = $(this).text().toLowerCase();
                    var book=$(this).closest('.bookItem');
                    if(!book.hasClass("show")){
                        if(s.indexOf(g) == -1) {
                            book.addClass("hide");
                        } else {
                            book.removeClass("hide");
                            book.addClass("show");
                        }
                    }
                        debugger;
                });
            }, 1000);
        },

    destroy: function () {
        this.undelegateEvents();
        this.$el.removeData().unbind();
        this.$el.empty();
    },

    showCart: function () {
        $("#currentView").empty().append("Cart");

        if (app.DashboardView.cartView != null) {
            app.DashboardView.cartView.destroy();
        }
        app.DashboardView.cartView = new app.CartView();
    },

    showLibrary: function () {
        debugger;
        $("#currentView").empty().append("Books");
        if (app.DashboardView.libraryView != null) {
            app.DashboardView.libraryView.destroy();
            debugger;
        }
        app.DashboardView.libraryView = new app.LibraryView();
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
        // Enables us to reuse the view as a sub-view.
        // Can also be used to pre-render the view prior to rendering.
        //Like in the library render function.
        return this;
    }
})