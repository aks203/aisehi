package com.aks.Controller;

import com.aks.Entity.User;
import com.aks.Exceptions.CustomGenericException;
import com.aks.Exceptions.CustomNotFoundException;
import com.aks.Exceptions.DatabaseDownException;
import com.aks.Service.UserService;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for handling User related api requests
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * @return List of all users
     */
    @GetMapping()
    public @ResponseBody
    List<User> getUsers() {
        try {
            return userService.getUsers();
        } catch (HibernateException | CannotCreateTransactionException dbException) {
            throw new DatabaseDownException("Database error. Could not connect at this time.");
        } catch (Exception ex) {
            throw new CustomGenericException("Unable to retrieve users at this time. Please try again later.", ex);
        }
    }

    /**
     * @param id
     * @return String if user is deleted successfully
     * @throws CustomNotFoundException
     * @throws CustomGenericException
     */
    @DeleteMapping(value = "/{id}")
    public @ResponseBody String deleteUser(@PathVariable("id") Integer id) throws CustomNotFoundException,
            CustomGenericException{
        try {
            if (!(userService.deleteUser(id) > 0)) {
                throw new CustomNotFoundException("Unable to delete user.");
            }
            return "User deleted successfully.";
        } catch (Exception ex) {
            throw new CustomGenericException("Can't delete right now. Try later.", ex);
        }
    }
}
