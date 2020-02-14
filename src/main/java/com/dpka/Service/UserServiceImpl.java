package com.dpka.Service;

import com.dpka.Dao.UserDao;
import com.dpka.Entity.User;
import com.dpka.Model.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
 @Autowired
   UserDao userDao;
 @Override
    public UserPojo createUser(int id, String firstname, String lastname, String username, String email, String password) {
        User user = new User(id,firstname,lastname,username,email,password);
        userDao.createUser(user);
        UserPojo userPojo=new UserPojo();
        userPojo.setId(user.getId());
        userPojo.setFirstname(user.getFirstname());
        userPojo.setLastname(user.getLastname());
        userPojo.setUsername(user.getUserName());
        userPojo.setEmail(user.getEmail());
        userPojo.setPassword(user.getPassword());
        return userPojo;
    }
    @Override
    public UserPojo getUser(String email, String password) {
            User user= userDao.getUser(email);
            UserPojo userPojo=new UserPojo();
            userPojo.setId(user.getId());
            userPojo.setFirstname(user.getFirstname());
            userPojo.setLastname(user.getLastname());
            userPojo.setUsername(user.getUserName());
            userPojo.setEmail(user.getEmail());
            userPojo.setPassword(user.getPassword());
            return userPojo;
        }
}
