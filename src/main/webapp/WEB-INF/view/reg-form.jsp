<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<jsp:include page="./index.jsp" />--%>

<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="http://underscorejs.org/underscore-min.js"></script>
    <script src="http://backbonejs.org/backbone-min.js"></script>

</head>
<body>
<%@include  file="./index.html" %>

<div id="res">
</div>

<script>
    var User = Backbone.Model.extend({
        url: '/register',

        defaults: {
            name: 'atul',
            email: 'ad@gma.co',
            password: '234324',
            phone: '3423423',
            language: 'ehn'
        }
    });

    var signupView = Backbone.View.extend({
        el: $('form'),
        template: _.template($('#userTemplate').html(), {interpolate: /\<\@\=(.+?)\@\>/gim}),

        events: {
            'click #register': 'onFormSubmit'
        },

        initialize: function () {
            console.log(this.model);
        },

        onFormSubmit: function (e) {
            // e.preventDefault();
            this.model.set({
                name: $("#name").val(), email: $("#email").val(),
                password: $("#password").val(), phone: $("#phone").val(), language: $("#language").val()
            });
            var o=this;
            this.model.save({
                type: "POST",
                contentType: "application/json"
            },{success:function (model, response) {
                    console.log("Succccessss");
                    o.render();
                    debugger;
                },
                error: function (model, response) {
                    console.log('error! ' + response);
                }, wait: true});
        },

        render: function() {
            $(this.el).html(this.template(this.model.toJSON()));
            return this;
        }
    });

    $(document).ready(function () {
        // var user=new User();
        var formView = new signupView({model: new User});
        $('body').append(formView.el);
    })


</script>

</body>
</html>
