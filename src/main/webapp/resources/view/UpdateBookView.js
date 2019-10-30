var app = app || {};

app.UpdateBookView = Backbone.View.extend({
    el: '#content',
    template: _.template($('#AddBookTemplate').html(), {interpolate: /\<\@\=(.+?)\@\>/gim, evaluate: /\<\@(.+?)\@\>/gim}),
    model: app.BookModel,

    events:{
        'click #updateBookBtn':'updateBook'
    },

    updateBook: function( e ) {
        e.preventDefault();
        var formData = {};
        $( '#addBookForm div' ).children( 'input' ).each( function( i, el ) {
            if( $( el ).val() !== '' )
            {
                formData[ el.id ] = $( el ).val();
            }
            if(el.id=="countBooks"){
                formData[ el.id ] =parseInt($( el ).val());
            }
        });
        this.model.save( formData,
            {   wait: true,
                url: "api/books",
                headers: {'user_id' :getUserId()},
                success: function (response){
                    debugger;
                    alert("Book updated successfully.");
                    app.DashboardView.prototype.showLibrary();
                },
                error: function (model, response) {
                debugger;
                    if(response.status==401)
                        return logout();
                    alert(response.responseJSON.message);
                }
            } );
    },

    initialize:function(options){
        // this.collection=app.bookCollection;
        debugger
        this.model=options.item;
        this.render();
    },
    render: function() {
        this.$el.html(this.template(this.model.attributes));
        this.$el.append("<button id='updateBookBtn'>Update Book</button>");
        return this;
    }
});