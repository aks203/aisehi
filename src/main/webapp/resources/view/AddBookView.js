var app = app || {};

app.AddBookView = Backbone.View.extend({
    el: '#content',
    template: _.template($('#AddBookTemplate').html(), {interpolate: /\<\@\=(.+?)\@\>/gim, evaluate: /\<\@(.+?)\@\>/gim}),

    events:{
        'click #addBookBtn':'addBook'
    },

    addBook: function( e ) {
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
        this.collection.create( formData,
            {   wait: true,
                headers: {'user_id' :getUserId()},
                success: function (response){
                    var frm=$("#addBookForm")[0];
                    frm.reset();
                    alert("Book added successfully.")
                },
                error: function (model, response) {
                    if(response.status==401)
                        return logout();
                    alert(response.responseJSON.message);
                }
            } );

    },

    initialize:function(){
        this.collection=app.bookCollection;
        // this.render();
    },
    render: function() {
        debugger;
        this.$el.html(this.template(new app.BookModel().attributes));
        this.$el.append("<button id='addBookBtn'>Add Book</button>");
        return this;
    }
});