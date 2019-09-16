package com.aks.DAO;

import com.aks.Entity.Cart;
import com.aks.POJO.BookPojo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CartDAOImpl implements CartDAO {

    @Autowired
    SessionFactory sessionFactory;

    /**
     *
     * @param user_id
     * @return List of all cart entities for that user
     */
    @Override
    public List<Cart> getCart(Integer user_id) {
        Session currentSession=sessionFactory.getCurrentSession();
        Query q=currentSession.createQuery("from Cart where user_id= :user_id");
        q.setParameter("user_id", user_id);
        List<Cart> userCarts=(List<Cart>)q.getResultList();
        return userCarts;
    }

    /**
     *
     * @param cart
     * @return String message
     */
    @Override
    public String addBookToCart(Cart cart) {
        Session currentSession = sessionFactory.getCurrentSession();
        List<Cart> userCarts = this.getCart(cart.getUser_id());
        for (Cart c : userCarts) {
            if (c.getBook_id() == cart.getBook_id()) {
                return "Book already in cart!";
            }
        }
        currentSession.save(cart);
        return "Book added to cart";
    }

    /**
     * @param cart
     * @return 1 if deleted, else 0
     */
    @Override
    public int deleteBookFromCart(Cart cart) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query q=currentSession.createQuery("delete from Cart where user_id= :user_id and book_id= :book_id");
        q.setParameter("user_id", cart.getUser_id());
        q.setParameter("book_id", cart.getBook_id());
        return q.executeUpdate();
    }

}
