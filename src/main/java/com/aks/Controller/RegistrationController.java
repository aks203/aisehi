package com.aks.Controller;

import com.aks.Entity.User;
import com.aks.POJO.UserPojo;
import com.aks.Service.TokenService;
import com.aks.Service.UserService;
import com.aks.security.JwtGenerator;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    UserService userService;

    @Autowired
    JwtGenerator jwtGenerator;

    @Autowired
    TokenService tokenService;

    @RequestMapping(value = "/login")
    public @ResponseBody Map<String, Object> login(
            @RequestBody UserPojo user){
        Map<String, Object> userDetails = new HashMap<String, Object>();
        try {
            UserPojo newUser=userService.getUser(user.getEmail(), user.getPassword());
            if(newUser==null){
                userDetails.put("status", "Error");
                userDetails.put("msg", "Login unsuccessful! Please check details.");
                return userDetails;
            }
            userDetails.put("user", newUser);
            userDetails.put("status", "Success");
            userDetails.put("msg", "Login successful. Enjoy.");
            try {
                String token = jwtGenerator.generate(newUser);
                tokenService.saveToken(newUser.getId(), token);
            }catch (Exception ex){
                userDetails.put("status", "Error");
                userDetails.put("msg", "Error generating token. Please try after sometime.");
                return userDetails;
            }
//            userDetails.put("auth-token", token);
            return userDetails;
        }catch (Exception ex){
            ex.printStackTrace();
            userDetails.put("status", "Error");
            userDetails.put("msg", "\"Error creating user. Please fill all the details correctly..\"");
            return userDetails;
        }
    }

    @RequestMapping(value = "/register", consumes = "application/json")
     public @ResponseBody Map<String, Object> registerNewUser(
            HttpServletRequest request,
            @RequestBody UserPojo user,
            HttpServletResponse response){
        Map<String, Object> userDetails = new HashMap<String, Object>();
        try {
            if (user.getName()== "" || user.getEmail() == "" || user.getPassword() == "" || user.getPassword() == "" || userService.checkEmail(user.getEmail())==false) {
                userDetails.put("status", "Error");
                userDetails.put("msg", "\"Error creating user. Please fill all the details correctly..\"");
                return userDetails;
            }
            userDetails.put("user", userService.createUser(user.getName(), user.getEmail(), user.getPassword(), user.getLanguage(), user.getRole()));
            userDetails.put("status", "Success");
            userDetails.put("msg", "User successfully created. Now, you can login.");
            return userDetails;
        }
        catch (ConstraintViolationException duplEx) {
            duplEx.printStackTrace();
            userDetails.put("status", "Error");
            userDetails.put("msg", "Duplicate entry for this user. Please correct details.");
            return userDetails;
        }
        catch (Exception ex) {
            userDetails.put("status", "Error");
            userDetails.put("msg", "Error creating user. Please correct details.");
            return userDetails;
        }
    }

    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String home(){
        return "index";
    }
}
