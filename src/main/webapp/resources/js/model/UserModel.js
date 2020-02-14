var app = app || {};
app.User = Backbone.Model.extend({
    initialize:function(){
    url:'/register',
   defaults:{
        id:'',
       firstname:'',
       lastname:'',
       username:'',
       email:'',
       password:''
          }
          },
validate:function(attrs){
        if(!attrs.firstname){
            alert("Please enter name");
            return("Please enter name");
        }
        else(!attrs.email)
    {
            alert("Please enter email");
             return("Please enter email");
    }
}
});