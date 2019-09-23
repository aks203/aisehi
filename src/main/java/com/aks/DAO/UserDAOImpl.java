package com.aks.DAO;

import com.aks.Entity.User;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//This @Repository handles checked exceptions and Spring will
//automatically register the DAO implementation

@Repository
public class UserDAOImpl implements UserDAO {
    //This sessionFactory maps to the bean id in spring config
    @Autowired
    private SessionFactory sessionFactory;


    /**
     *
     * @param user
     */
    public void createUser(User user){
        Session currentSession=sessionFactory.getCurrentSession();
            currentSession.save(user);
    }

    /**
     *
     * @param user_id
     * @return 1 if deleted successfully, else 0
     */
    public int deleteUser(int user_id){
        Session currentSession=sessionFactory.getCurrentSession();
        Query q=currentSession.createQuery("delete User where id= :id");
        q.setParameter("id", user_id);
        return q.executeUpdate();
    }

    /**
     *
     * @param id
     * @return user by id
     */
    @Override
    public User getUser(int id){
        //Get the current hibernate session
        Session currentSession=sessionFactory.getCurrentSession();
        Query q=currentSession.createQuery("from User where id= :id");
        q.setParameter("id", id);
        return (User)q.uniqueResult();
    }

    /**
     *
     * @param email
     * @return user by email
     */
    @Override
    public User getUser(String email){
        Session currentSession=sessionFactory.getCurrentSession();
        Query q=currentSession.createQuery("from User where email= :email");
        q.setParameter("email", email);
        return (User)q.uniqueResult();
    }

    /**
     *
     * @param email
     * @return password by email
     */
    @Override
    public String getPasswordByEmail(String email){
        Session currentSession=sessionFactory.getCurrentSession();
        Query q=currentSession.createQuery("select password from User where email= :email");
        q.setParameter("email", email);
        return (String) q.uniqueResult();
    }

    @Override
    public List<User> getUsers() {
        Session currentSession=sessionFactory.getCurrentSession();
        Query q=currentSession.createQuery("from User");
        List<User> users=(List<User>)q.getResultList();
        return users;
    }
}
