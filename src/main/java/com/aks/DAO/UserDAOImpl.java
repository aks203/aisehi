package com.aks.DAO;

import com.aks.Entity.PLAN;
import com.aks.Entity.Subscription;
import com.aks.Entity.User;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;

//This @Repository handles checked exceptions and Spring will
//automatically register the DAO implementation
@Transactional
@Repository
public class UserDAOImpl implements UserDAO {
    //This sessionFactory maps to the bean id in spring config
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * @param id
     * @return User
     */

    public User getUser(int id){

        //Get the current hibernate session
        Session currentSession=sessionFactory.getCurrentSession();
        Subscription subs=new Subscription(new Date(System.currentTimeMillis()), new Date(new LocalDate().plusDays(30)), PLAN.BASIC);
        User u1=new User("atul", "aks@gmail.com", "1234567890", "987654321", "English", subs);
        //create a query
        Query q=currentSession.createQuery("from User where id= :id");
        q.setParameter("id", id);

        //execute it and get the result
        User user=(User)q.uniqueResult();

        //return the result
        return user;
    }
}
