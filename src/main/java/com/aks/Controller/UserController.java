package com.aks.Controller;

import com.aks.Entity.User;
import com.aks.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user/{id}")
    public String getUser(@PathVariable("id") long id, Model theModel){
        User user=userService.getUser((int)id);
        theModel.addAttribute("user", user);
        return "show-user";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") int id, Model theModel){
        User user=userService.getUser(id);
        theModel.addAttribute("user", user);
        return "user-form";
    }
}
