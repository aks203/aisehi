package com.aks.DAO;

import com.aks.Entity.Cart;
import com.aks.Exceptions.BadRequestException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartDAOImpl implements CartDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    BookDAO bookDAO;

    /**
     * @param user_id
     * @return List of all cart entities for that user
     */
    @Override
    public List<Cart> getCart(int user_id, int type) {
        Session currentSession=sessionFactory.getCurrentSession();
        Query q=currentSession.createQuery("from Cart where user_id= :user_id and type= :type");
        q.setParameter("user_id", user_id);
        q.setParameter("type", type);
        return (List<Cart>)q.getResultList();
    }

    /**
     * @param cart
     * @return String message
     */
    @Override
    public String addBookToCart(Cart cart) {
        Session currentSession = sessionFactory.getCurrentSession();
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
        Query q=currentSession.createQuery("delete from Cart where user_id= :user_id and book_id= :book_id and type=0");
        q.setParameter("user_id", cart.getUser_id());
        q.setParameter("book_id", cart.getBook_id());
        return q.executeUpdate();
    }

    /**
     * @param bookIDs
     * @param cart_id
     * @return
     */
    @Override
    public String checkout(List<Integer> bookIDs, List<Integer> cart_id) {
        Session currentSession = sessionFactory.getCurrentSession();
        StringBuilder querySB1 = new StringBuilder("UPDATE book SET COUNTBOOKS = COUNTBOOKS - 1 " +
                "WHERE COUNTBOOKS > 0 and BOOK_ID in (");
        StringBuilder querySB2 = new StringBuilder("UPDATE cart SET TYPE= 1 " +
                "WHERE CART_ID in (");
        for (Integer eachBookID : bookIDs) {
            querySB1.append(eachBookID +", ");
            }
        for (Integer eachCartID : cart_id) {
            querySB2.append(eachCartID + ", ");
        }
        querySB1.setLength(querySB1.length()-2);
        querySB2.setLength(querySB2.length()-2);
        querySB1.append(")");
        querySB2.append(")");
        NativeQuery query1 = currentSession.createSQLQuery(querySB1.toString());
        NativeQuery query2 = currentSession.createSQLQuery(querySB2.toString());
        if(query1.executeUpdate()==bookIDs.size()){
            if(query2.executeUpdate()==bookIDs.size());
            return "Checkout successful.";
        }
            throw new BadRequestException("Can't checkout now. Please try again.");
        }

    @Override
    public boolean returnBook(Integer user_id, Integer book_id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query q=currentSession.createQuery("delete from Cart where user_id= :user_id and book_id= :book_id and type=1");
        Query q2=currentSession.createQuery("update Book set countBooks =countBooks+1 where book_id= :book_id");
        q.setParameter("user_id", user_id);

        q.setParameter("book_id", book_id);
        q2.setParameter("book_id", book_id);
        if(q.executeUpdate()>0){
            return q2.executeUpdate()==1;
        }
        return false;
    }
}


