package com.aks.Service;

import com.aks.DAO.BookDAO;
import com.aks.DAO.CartDAO;
import com.aks.Entity.Book;
import com.aks.Entity.Cart;
import com.aks.POJO.BookPojo;
import com.aks.POJO.CartPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    CartDAO cartDAO;

    @Autowired
    BookDAO bookDAO;

    @Override
    public List<BookPojo> getCart(Integer user_id) {
        try {
            CartPojo cartPojo = new CartPojo();
            List<Cart> userCarts = cartDAO.getCart(user_id);
            List<BookPojo> bookPojoList = new ArrayList<>();
            if (userCarts.size() < 1) {
                return bookPojoList;
            }
            for (Cart cart : userCarts) {
                Book newBook=bookDAO.getBookById(cart.getBook_id());
                bookPojoList.add(new BookPojo(newBook.getBook_id(),
                                                newBook.getTitle(),
                                                newBook.getAuthor(),
                                                newBook.getCategory(),
                                                newBook.getPublisher()));
            }
            return bookPojoList;
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public String addBook(int user_id, int book_id) {
        Cart cart=new Cart(user_id, book_id);
        return cartDAO.addBookToCart(cart);
    }

    @Override
    public String deleteBook(Integer user_id, Integer book_id) {
        Cart cart=new Cart(user_id, book_id);
        int i=cartDAO.deleteBookFromCart(cart);
        if(i<1){
            return "Error removing book from your cart!";
        }
        else {
            return "Successfully deleted.";
        }
    }
}
