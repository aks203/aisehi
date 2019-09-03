var app=app||{};

app.DashboardView=Backbone.View.extend({
    el: $("#container"),

    templateHeader: _.template($('#headerTemplate').html(), {interpolate: /\<\@\=(.+?)\@\>/gim}),
    // template: _.template($('#dashboard-template').html(), {interpolate: /\<\@\=(.+?)\@\>/gim}),

    initialize:function(){
        console.log("Dashboard initialized...");
        console.log("Header rendered...")
        this.$el.html(this.templateHeader());
        this.render();
    },

    render: function () {
        // this.$el.html(this.template(this.model.toJSON()));
        return this;
    }
})

function showDashboard() {
    new app.DashboardView({model: new app.Dashboard})
};