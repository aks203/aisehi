var app = app || {};

app.DashboardView = Backbone.View.extend({
    el: $("#container"),

    templateHeader: _.template($('#headerTemplate').html(), {interpolate: /\<\@\=(.+?)\@\>/gim}),
    // templateContent: _.template($('#headerContent').html(), {interpolate: /\<\@\=(.+?)\@\>/gim}),

    initialize: function () {
        console.log("Dashboard initialized...");
        console.log("Header rendered...")
        this.render();
    },
    render: function () {
        this.$el.html(this.templateHeader(this.model.toJSON()));
        componentHandler.upgradeDom();
        return this;
    }
})

function showDashboard(response) {
    debugger;
    new app.DashboardView({
        model: new app.Dashboard({
            response: response
        })
    });
    var books = [
        { title: 'JavaScript: The Good Parts', author: 'Douglas Crockford', releaseDate: '2008', keywords: 'JavaScript Programming' },
        { title: 'The Little Book on CoffeeScript', author: 'Alex MacCaw', releaseDate: '2012', keywords: 'CoffeeScript Programming' },
        { title: 'Scala for the Impatient', author: 'Cay S. Horstmann', releaseDate: '2012', keywords: 'Scala Programming' },
        { title: 'American Psycho', author: 'Bret Easton Ellis', releaseDate: '1991', keywords: 'Novel Splatter' },
        { title: 'Eloquent JavaScript', author: 'Marijn Haverbeke', releaseDate: '2011', keywords: 'JavaScript Programming' },
        { title: 'Eloquent JavaScript', author: 'Marijn Haverbeke', releaseDate: '2011', keywords: 'JavaScript Programming' }
    ];
    new app.LibraryView(books);
};