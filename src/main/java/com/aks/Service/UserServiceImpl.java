package com.aks.Service;

import com.aks.DAO.UserDAO;
import com.aks.Entity.User;
import com.aks.POJO.UserPojo;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * @param id
     * @return
     */
    @Override
    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    /**
     *
     * @param email
     * @return true if email is of correct format, else return false
     */
    @Override
    public boolean checkEmail(String email){
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                    "[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                    "A-Z]{2,7}$";

            Pattern pat = Pattern.compile(emailRegex);
            if (email == null)
                return false;
            return pat.matcher(email).matches();
    };

    /**
     *
     * @param email
     * @param password
     * @return User POJO class
     */

    @Override
    public UserPojo getUser(String email, String password) {
        if(checkEmail(email)==false){
            return null;
        }
        if (passwordEncoder.matches(password, userDAO.getPasswordByEmail(email))) {
            User user= userDAO.getUser(email);
            UserPojo userPojo=new UserPojo();
            userPojo.setId(user.getId());
            userPojo.setName(user.getName());
            userPojo.setEmail(user.getEmail());
            userPojo.setLanguage(user.getLanguage());
            userPojo.setRole(user.getRole());
            return userPojo;
        }
        else {
            return null;
        }
    }

    /**
     *
     * @param updatedUser
     */
    @Override
    public void updateUser(User updatedUser) {
        User user = userDAO.getUser(updatedUser.getId());
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setLanguage(updatedUser.getLanguage());
    }

    @Override
    public boolean deleteUser(int user_id) {
        int i=userDAO.deleteUser(user_id);
        if(i==1)
            return true;
        else
            return false;
    }

    /**
     * @param name
     * @param email
     * @param password
     * @param language
     * @return User POJO class
     */
    @Override
    public UserPojo createUser(String name, String email, String password, String language, String role) {
        User user = new User(name, email, passwordEncoder.encode(password), language, role);
        userDAO.createUser(user);
        UserPojo userPojo=new UserPojo();
        userPojo.setId(user.getId());
        userPojo.setName(user.getName());
        userPojo.setEmail(user.getEmail());
        userPojo.setLanguage(user.getLanguage());
        userPojo.setRole(user.getRole());
        return userPojo;
    }
}
