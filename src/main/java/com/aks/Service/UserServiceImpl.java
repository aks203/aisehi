package com.aks.Service;

import com.aks.DAO.UserDAO;
import com.aks.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;

    /**
     * @param id
     * @return
     */
    @Override
    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    @Override
    public User getUser(String email, String password){
        return userDAO.getUser(email, password);

    }

    @Override
    public void updateUser(User updatedUser) {
        User user=userDAO.getUser(updatedUser.getId());
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setLanguage(updatedUser.getLanguage());
        user.setPhone(updatedUser.getPhone());
            }

    @Override
    public boolean deleteUser(int user_id) {
        return userDAO.deleteUser(user_id);
    }

    /**
     * @param name
     * @param email
     * @param password
     * @param phone
     * @param language

     * @return
     */
    @Override
    public User createUser(String name, String email, String password, String phone, String language) {
        User user=new User(name, email, password, phone, language);
        userDAO.createUser(user);
        return user;
    }
}
