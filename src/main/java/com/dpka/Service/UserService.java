package com.dpka.Service;

import com.dpka.Model.UserPojo;

public interface UserService {
    UserPojo createUser(int id, String firstname, String lastname, String username, String email, String password);
    UserPojo getUser(String username, String password);
}
