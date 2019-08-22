package com.aks.DAO;

import com.aks.Entity.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserDAO{
    /**
     * @param id
     * @return User
     */
    User getUser(int id);
}