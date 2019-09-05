package com.aks.Service;

import com.aks.DAO.UserDAO;
import com.aks.Entity.User;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
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
     * @return
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
     * @return
     */

    @Override
    public User getUser(String email, String password) {
        if(checkEmail(email)==false){
            return null;
        }
        if (passwordEncoder.matches(password, userDAO.getPasswordByEmail(email))) {
            return userDAO.getUser(email);
        }
        else {
            return null;
        }
    }

    @Override
    public void updateUser(User updatedUser) {
        User user = userDAO.getUser(updatedUser.getId());
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setLanguage(updatedUser.getLanguage());
    }

    @Override
    public boolean deleteUser(int user_id) {
        return userDAO.deleteUser(user_id);
    }

    /**
     * @param name
     * @param email
     * @param password
     * @param language
     * @return
     */
    @Override
    public User createUser(String name, String email, String password, String language) {
        User user = new User(name, email, passwordEncoder.encode(password), language);
        userDAO.createUser(user);
        return user;

    }
}
