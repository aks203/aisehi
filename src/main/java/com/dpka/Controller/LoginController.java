package com.dpka.Controller;

import com.dpka.Model.UserPojo;
import com.dpka.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/login", consumes = "application/json")
    public @ResponseBody
    Map<String, Object> login(
            @RequestBody UserPojo user) {
        Map<String, Object> userDetails = new HashMap<String, Object>();
            UserPojo newUser = userService.getUser(user.getEmail(), user.getPassword());
            userDetails.put("user", newUser);
            userDetails.put("status", "Success");
            userDetails.put("msg", "Login successful");
            return userDetails;
    }
}
