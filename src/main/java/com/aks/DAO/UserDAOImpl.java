package com.aks.DAO;

import com.aks.Entity.PLAN;
import com.aks.Entity.Subscription;
import com.aks.Entity.User;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import java.time.LocalDate;

//This @Repository handles checked exceptions and Spring will
//automatically register the DAO implementation

@Repository
public class UserDAOImpl implements UserDAO {
    //This sessionFactory maps to the bean id in spring config
    @Autowired
    private SessionFactory sessionFactory;

    public void createUser(User user){
        Session currentSession=sessionFactory.getCurrentSession();
            currentSession.save(user);
    };

    public boolean deleteUser(int user_id){
        Session currentSession=sessionFactory.getCurrentSession();
        Query q=currentSession.createQuery("delete User where id= :id");
        q.setParameter("id", user_id);
        int i=q.executeUpdate();
        if(i==1)
            return true;
        else
            return false;
    }

    @Override
    public User getUser(int id){
        //Get the current hibernate session
        Session currentSession=sessionFactory.getCurrentSession();
        Query q=currentSession.createQuery("from User where id= :id");
        q.setParameter("id", id);
        User user=(User)q.uniqueResult();
        return user;
    }

    @Override
    public User getUser(String email, String password){
        Session currentSession=sessionFactory.getCurrentSession();
        Query q=currentSession.createQuery("from User where email= :email and password= :password");
        q.setParameter("email", email);
        q.setParameter("password", password);
        return (User)q.uniqueResult();
    }
}
