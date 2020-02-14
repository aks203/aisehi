package com.dpka.Dao;

import com.dpka.Entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;
    public void createUser(User user){
        Session currentSession=sessionFactory.getCurrentSession();
        currentSession.save(user);
    }
    @Override
    public User getUser(String email){
        Session currentSession=sessionFactory.getCurrentSession();
        Query q=currentSession.createQuery("from User where email= :email");
        q.setParameter("email", email);
        return (User)q.uniqueResult();
    }
}
