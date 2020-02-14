package com.dpka.Dao;

import com.dpka.Entity.User;

public interface UserDao {
    void createUser(User user);
    User getUser(String email);
}
