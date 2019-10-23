var app = app || {};

app.DashboardView = Backbone.View.extend({
    el: $("#container"),

    events: {
        'click #addNewBook': 'showAddBookView',
        'click #home': 'showLibrary',
        'click #browse': 'showLibrary',
        'click #showCart': 'showCart',
        'click #orders': 'showOrders',
        'click #showUserList': 'showUserList',
        'click #checkout': 'checkout',
        'keyup #search': 'search'
    },

    search: function(e){
            setTimeout(function () {
                debugger;
                $(".searchableItem").removeClass('hide');
                $(".searchableItem").removeClass('show');
                var g=$(e.target).val().toLowerCase();
                $(".searchableItem .bookContent").each(function() {
                    var s = $(this).text().toLowerCase();
                    var book=$(this).closest('.searchableItem');
                    debugger;
                    if(!book.hasClass("show")){
                        if(s.indexOf(g) == -1) {
                            book.addClass("hide");
                        } else {
                            book.removeClass("hide");
                            book.addClass("show");
                        }
                    }
                });
            }, 1000);
        },

    checkout:function(e){
        e.preventDefault();
        var self=this;
        $.ajax({
            url: '/api/cart/checkout/'+getUserId(),
            wait: true,
            headers: {'user_id' :getUserId()},
            success: function(result) {
                self.showOrders();
                alert(result);
            },
            error: function (response) {
                if(response.status==401)
                    return logout();
                alert(response.responseJSON.message);
            }
        });
    },

    destroy: function () {
        this.undelegateEvents();
        this.$el.removeData().unbind();
        this.$el.empty();
    },

    showCart: function () {
        $("#currentView").empty().append("<button id='checkout'> Checkout</button>");
        showView(new app.CartView({type: 0}));
        // if (app.DashboardView.cartView != null) {
        //     app.DashboardView.cartView.destroy();
        // }
        // app.DashboardView.cartView = new app.CartView();
    },

    showOrders: function () {
        $("#currentView").empty().append("Orders");
        showView(new app.CartView({type: 1}));
    },

    showUserList: function () {
        $("#currentView").empty().append("Users");
        showView(new app.UserListView());
    },

    showLibrary: function () {
        $("#currentView").empty().append("Books");
        if (app.DashboardView.libraryView != null) {
            app.DashboardView.libraryView.destroy();
        }
        app.DashboardView.libraryView = new app.LibraryView();
    },

    showAddBookView: function () {
        $("#currentView").empty().append("Add new Book");
        showView(new app.AddBookView());
    },

    template: _.template($('#headerTemplate').html(), {
        interpolate: /\<\@\=(.+?)\@\>/gim,
        evaluate: /\<\@(.+?)\@\>/gim
    }),

    initialize: function () {
        console.log("Dashboard initialized...");
        console.log("Header rendered...");
        this.render();
        this.showLibrary();
    },
    render: function () {
        this.$el.html(this.template(this.model.attributes));
        componentHandler.upgradeDom();
        // Enables us to reuse the view as a sub-view.
        // Can also be used to pre-render the view prior to rendering.
        //Like in the library render function.
        return this;
    }
});