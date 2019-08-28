package com.aks.Service;

import com.aks.Entity.Order;
import com.aks.Entity.Subscription;
import com.aks.Entity.User;

import java.util.List;

public interface UserService {
    //Create a subscription object using subsType int var. Then create user obj.
    User createUser(String name, String email, String password, String phone, String language);

    User getUser(int id);

    void updateUser(User updatedUser);

    boolean deleteUser(int user_id);


}
