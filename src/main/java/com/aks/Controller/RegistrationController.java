package com.aks.Controller;

import com.aks.Entity.User;
import com.aks.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class RegistrationController {
    @Autowired
    UserService userService;

//    /{email}/{password}

    @PostMapping(value = "/login")
    public @ResponseBody User login(
            @RequestBody User user
//            @RequestParam(value = "email")String email,
//            @RequestParam(value = "password") String password
    ){
        return userService.getUser(user.getEmail(), user.getPassword());
    }

    @PostMapping(value = "/register", consumes = "application/json")
     public @ResponseBody User registerNewUser(
            HttpServletRequest request,
            @RequestBody User user,
            HttpServletResponse response){
        User newUser=new User();
        try{
            newUser=userService.createUser(user.getName(), user.getEmail(), user.getPassword(), user.getPhone(), user.getLanguage());
                return newUser;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        //Just return blank to remove error for return statement
        return newUser;
    }
}
