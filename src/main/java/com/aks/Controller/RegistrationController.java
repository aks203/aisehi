package com.aks.Controller;

import com.aks.Entity.User;
import com.aks.Service.UserService;
import com.aks.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class RegistrationController {
    @Autowired
    UserService userService;

    @RequestMapping("/signup")
    public String signup(){
        return "index";
    }


    @GetMapping(value = "/register")
    public ModelAndView showRegistrationForm(HttpServletRequest request){
        User user=new User();
        ModelAndView mv=new ModelAndView("reg-form");
        mv.addObject("user", user);
        return mv;
    }

    @PostMapping(value = "/register" , consumes = "application/json")
     public @ResponseBody User registerNewUser(
            HttpServletRequest request,
            @RequestBody UserBean user,
            HttpServletResponse response){
        User newUser=new User();
        try{
            newUser=userService.createUser(user.getName(), user.getEmail(), user.getPassword(), user.getPhone(), user.getLanguage());
            if(newUser==null){
//                ModelAndView modelAndView=new ModelAndView("error");
//                modelAndView.addObject("errorMsg", "Error creating user in database!!");
//                return modelAndView;
            }
            else{
                ModelAndView modelAndView=new ModelAndView("Dashboard");
//                modelAndView.addObject("user", newUser);
                return newUser;
           }
        }
        catch(Exception ex){
            ex.printStackTrace();
            ModelAndView modelAndView=new ModelAndView("error");
            modelAndView.addObject("errorMsg", "Duplicate user!!");
        }
        //Just return blank to remove error for return statement
        return newUser;
    }
}
