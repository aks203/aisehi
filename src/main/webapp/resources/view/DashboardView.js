var app = app || {};

app.DashboardView = Backbone.View.extend({
    el: $("#container"),

    events:{
        'click #addNewBook': 'showAddBookView',
        'click #home': 'showLibrary',
        'click #browse': 'showLibrary'
    },

    showLibrary:function(){
        debugger;
        if(app.DashboardView.libraryView!=null) {
            app.DashboardView.libraryView.render();
        }
        else {
            app.DashboardView.libraryView = new app.LibraryView();
        }
    },

    showAddBookView:function(e){
        debugger;
        e.preventDefault();
        debugger;
        new app.AddBookView();
    },

    template: _.template($('#headerTemplate').html(), {interpolate: /\<\@\=(.+?)\@\>/gim}),

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

function showDashboard(response) {
       new app.DashboardView({
            model: new app.Dashboard({
                response: response
            })
        });
};