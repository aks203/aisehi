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
    new app.registrationView({model: new app.User});

})

// function showDashboard(response) {
//     app.dashboardView = new app.DashboardView({
//         model: new app.Dashboard({
//             response: response
//         })
//     });
// }



