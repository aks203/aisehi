package com.aks.DAO;

import com.aks.Entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {
    @Autowired
    private SessionFactory sessionFactory;

    /**
     *
     * @return return list of all books
     */
    @Override
    public List<Book> getBooks(){
        Session currentSession=sessionFactory.getCurrentSession();
        Query q=currentSession.createQuery("from Book");
        List<Book> books=(List<Book>)q.getResultList();
        return books;
    }

    /**
     *
     * @param book
     * @return id
     */
    @Override
    public int addBook(Book book){
        Session currentSession=sessionFactory.getCurrentSession();
        return (Integer)currentSession.save(book);
    }

    /**
     * @param id
     * @return Book
     */
    @Override
    public Book getBookById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query q = currentSession.createQuery("from Book where book_id= :id");
        q.setParameter("id", id);
        Book book = (Book) q.uniqueResult();
        return book;
    }

    /**
     * Delete book from Book entity and from any cart that contains it
     * @param id
     * @return 1 if book is deleted, else 0
     */
    @Override
    public int deleteBook(Integer id){
        Session currentSession=sessionFactory.getCurrentSession();
        Query q=currentSession.createQuery("delete from Book where book_id= :id");
        q.setParameter("id", id);
        Query q2=currentSession.createQuery("delete from Cart  where book_id= :id");
        q2.setParameter("id", id);
        q2.executeUpdate();
        return q.executeUpdate();

    }
}
