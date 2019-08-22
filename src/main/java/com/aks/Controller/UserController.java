package com.aks.Controller;

import com.aks.DAO.UserDAO;
import com.aks.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private UserDAO userDAO;

    @RequestMapping("/user")
    public String getUser(Model theModel){
        User user=userDAO.getUser(1);
        theModel.addAttribute("user", user);
        return "show-user";
    }
}
