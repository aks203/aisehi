var app = app || {};

function showView(view) {
    if (this.presentView) {
        this.presentView.close();
    }
    this.presentView = view;
    this.presentView.render();
    // $("#mainContent").html(this.currentView.el);
}

$(document).ready(function () {
    Backbone.View.prototype.close = function () {
        this.$el.empty();
        this.unbind();
    };
    new app.homeView();
})

function showUserList(response) {
    app.UserView = new app.userView({
        model: new app.UserView({
            response: response
        })
    });
}



