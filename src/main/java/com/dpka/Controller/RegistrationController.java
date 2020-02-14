package com.dpka.Controller;

import com.dpka.Entity.User;
import com.dpka.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    public UserService userService;

    @RequestMapping(value = "/register", consumes = "application/json")
    public @ResponseBody
    Map<String, Object> registerNewUser(
            @RequestBody User user
    ) {
        Map<String, Object> userDetails = new HashMap<String, Object>();
        userDetails.put("user", userService.createUser(user.getId(), user.getUserName(), user.getFirstname(), user.getLastname(), user.getEmail(), user.getPassword()));
        userDetails.put("status", "Success");
        userDetails.put("msg", "User successfully created. Now, you can login.");
        return userDetails;
    }
}
