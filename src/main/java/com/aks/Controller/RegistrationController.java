package com.aks.Controller;

import com.aks.Entity.User;
import com.aks.Exceptions.BadRequestException;
import com.aks.Exceptions.CustomGenericException;
import com.aks.Exceptions.CustomNotFoundException;
import com.aks.Exceptions.DatabaseDownException;
import com.aks.POJO.UserPojo;
import com.aks.Service.TokenService;
import com.aks.Service.UserService;
import com.aks.security.JwtUtil;
import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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
            @RequestBody UserPojo user) {
        Map<String, Object> userDetails = new HashMap<String, Object>();
        try {
            UserPojo newUser = userService.getUser(user.getEmail(), user.getPassword());
            if (newUser == null) {
                throw new CustomNotFoundException("User Not found. Please check details.");
            }
            userDetails.put("user", newUser);
            userDetails.put("status", "Success");
            userDetails.put("msg", "Login successful. Enjoy.");
            String token = jwtUtil.generateToken(newUser);
            tokenService.saveToken(newUser.getId(), token);
            return userDetails;
        } catch (HibernateException | CannotCreateTransactionException dbException) {
            throw new DatabaseDownException("Database error. Could not connect at this time.");
        }
        catch (Exception ex) {
            throw new CustomGenericException("Unable to login at this time. Please try again later.", ex);
        }
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
                     !userService.checkEmail(user.getEmail())) {
                throw new BadRequestException("Error creating user. Please fill all the details correctly.");
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
        catch (HibernateException | CannotCreateTransactionException dbException) {
            throw new DatabaseDownException("Database error. Could not connect at this time.");
        }
        catch (Exception ex) {
            throw new CustomGenericException("Unable to register at this time. Please try again later.", ex);
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
