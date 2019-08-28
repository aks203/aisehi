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

    boolean deleteUser(int user_id);
}