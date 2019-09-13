package com.aks.Service;

import com.aks.Entity.Order;
import com.aks.Entity.Subscription;
import com.aks.Entity.User;
import com.aks.POJO.UserPojo;

import java.util.List;

public interface UserService {
    boolean checkEmail(String email);
    //Create a subscription object using subsType int var. Then create user obj.
    UserPojo createUser(String name, String email, String password, String language, String role);

    /**
     *
     * @param id
     * @return User
     */
    User getUser(int id);

    /**
     * @param email
     * @param password
     * @return User
     */
    UserPojo getUser(String email, String password);

    /**
     *
     * @param updatedUser
     */
    void updateUser(User updatedUser);

    /**
     *
     * @param user_id
     * @return
     */
    boolean deleteUser(int user_id);


}
