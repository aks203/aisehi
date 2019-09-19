package com.aks.Service;

import com.aks.Entity.User;
import com.aks.POJO.UserPojo;

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
