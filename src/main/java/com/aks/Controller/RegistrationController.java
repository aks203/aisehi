package com.aks.Controller;

import com.aks.Exceptions.CustomException;
import com.aks.POJO.CustomExceptionPojo;
import com.aks.POJO.UserPojo;
import com.aks.Service.TokenService;
import com.aks.Service.UserService;
import com.aks.security.JwtUtil;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller for handling Registration and Login requests
 */
@Controller
public class RegistrationController {
    @Autowired
    UserService userService;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    TokenService tokenService;

    /**
     *
     * @param user
     * @return JSON of status and a message
     */
    @RequestMapping(value = "/login")
    public @ResponseBody Map<String, Object> login(
            @RequestBody UserPojo user){
        Map<String, Object> userDetails = new HashMap<String, Object>();
            UserPojo newUser=userService.getUser(user.getEmail(), user.getPassword());
            if(newUser==null){
                throw new CustomException("User Not found. Please check details.");
            }
            userDetails.put("user", newUser);
            userDetails.put("status", "Success");
            userDetails.put("msg", "Login successful. Enjoy.");
            String token = jwtUtil.generateToken(newUser);
            tokenService.saveToken(newUser.getId(), token);
            return userDetails;
    }

    /**
     * @param user
     * @return JSON of User object, status and a message
     */
    @RequestMapping(value = "/register", consumes = "application/json")
     public @ResponseBody Map<String, Object> registerNewUser(
            @RequestBody UserPojo user
            ){
        Map<String, Object> userDetails = new HashMap<String, Object>();
        try {
            if (user.getName()== "" || user.getEmail() == "" || user.getPassword() == "" ||
                    user.getPassword() == "" || userService.checkEmail(user.getEmail())==false) {
                userDetails.put("status", "Error");
                userDetails.put("msg", "\"Error creating user. Please fill all the details correctly..\"");
                return userDetails;
            }
            userDetails.put("user", userService.createUser(user.getName(), user.getEmail(),
                    user.getPassword(), user.getLanguage(), user.getRole()));
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

    /**
     * Loading index.jsp file
     * @return filename
     */
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String home(){
        return "index";
    }
}
