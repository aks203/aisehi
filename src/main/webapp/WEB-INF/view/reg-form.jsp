<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="http://underscorejs.org/underscore-min.js"></script>
    <script src="http://backbonejs.org/backbone-min.js"></script>
    
</head>
<body>
<form method="post">
    <div><input name="name" id="name" type="text" placeholder="Name"/></div>
    <div><input name="email" id="email" type="text" placeholder="Your mail"/></div>
    <div><input name="password" id="password" type="password" placeholder="Password"/></div>
    <div><input name="phone" id="phone" type="text" placeholder="Phone"/></div>
    <div><input name="language" id="language" type="text" placeholder="Language"/></div>
    <input type="button" value="Go" id="register"></input>
</form>

<div id="res">
</div>

<script>
    //Backbone.emulateJSON = true;
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
        template: _.template($('.userTemplate')),

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
                this.render();
                debugger;
                },
            error: function (model, response) {
                console.log('error! ' + response);
            }, wait: true});
        },

        render: function() {
            $('#res').append(this.$el.html(this.template(this.model.toJSON())));

            return this;
        }

    });
    $(document).ready(function () {
        // var user=new User();
        var formView = new signupView({model: new User});
        $('body').append(formView.el);
    })


</script>
<%--<div class="contain">--%>
    <%--<td><span class="name"><%= name %></span> </td>--%>
    <%--<td><span class="email"><%= email%></span> </td>--%>
    <%--<td><span class="password"><%= password%></span> </td>--%>
<%--</div>--%>
</body>
</html>
