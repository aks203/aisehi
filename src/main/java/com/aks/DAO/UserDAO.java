package com.aks.DAO;

import com.aks.Entity.User;

public interface UserDAO{
    /**
     *
     * @param user
     * @return user_id
     */
    void createUser(User user);
    /**
     * @param id
     * @return User
     */
    User getUser(int id);

    /**
     *
     * @param email
     * @param password
     * @return
     */
    User getUser(String email, String password);

    boolean deleteUser(int user_id);
}