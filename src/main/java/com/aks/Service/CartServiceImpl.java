package com.aks.Service;

import com.aks.DAO.BookDAO;
import com.aks.DAO.CartDAO;
import com.aks.Entity.Book;
import com.aks.Entity.Cart;
import com.aks.Exceptions.BadRequestException;
import com.aks.Exceptions.CustomGenericException;
import com.aks.POJO.BookPojo;
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
    public List<BookPojo> getCart(int user_id, int type) {
        List<Cart> userCarts = cartDAO.getCart(user_id, type);
        List<BookPojo> bookPojoList = new ArrayList<>();
        if (userCarts.size() < 1 ) {
            if(type==0)
                throw new BadRequestException("Cart empty. Please add some books.");
            else
                        throw new BadRequestException("No orders. Browse books and place some orders.");
        }
        for (Cart cart : userCarts) {
                Book newBook = bookDAO.getBookById(cart.getBook_id());
                if(newBook==null){
                    throw new BadRequestException("Error getting book from cart.");
                }
                bookPojoList.add(new BookPojo(newBook.getBook_id(),
                        newBook.getTitle(),
                        newBook.getAuthor(),
                        newBook.getCategory(),
                        newBook.getPublisher(),
                        newBook.getCountBooks()));
        }
        return bookPojoList;
    }

    @Override
    public String addBook(int user_id, int book_id) {
        if(bookDAO.getCount(book_id)>0) {
            Cart cart = new Cart(user_id, book_id);
            List<Cart> userCarts = cartDAO.getCart(user_id, 0);
            for (Cart c : userCarts) {
                if (c.getBook_id() == book_id) {
                    return "Book already in cart!";
                }
            }
            List<Cart> issuedBooks =cartDAO.getCart(user_id, 1);
            for(Cart c:issuedBooks){
                if(c.getBook_id()==book_id){
                    return "Book already issued. Can't add another to cart.";
                }
            }
            return cartDAO.addBookToCart(cart);
        }
        return "No more copies left. Please try again later.";
    }

    @Override
    public String deleteBook(Integer user_id, Integer book_id) {
        Cart cart=new Cart(user_id, book_id);
        int i=cartDAO.deleteBookFromCart(cart);
        if(i<1){
            throw new BadRequestException("Error removing book!");
        }
        else {
            return "Successfully removed.";
        }
    }


    @Override
    public String checkoutBooks(Integer user_id) {
        List<Cart> userCarts = cartDAO.getCart(user_id, 0);
        if (userCarts.size() == 0) {
            throw new BadRequestException("Cart empty. Please add some books to checkout.");
        }
        List<Cart> issuedBooks =cartDAO.getCart(user_id, 1);
        if (issuedBooks.size() + userCarts.size() > 10) {
            throw new BadRequestException("Maximum 10 books can be issued at a time. " +
                    "Must return a book or remove from cart to issue new.");
        }
        List<Integer> bookIDs=new ArrayList<>();
        List<Integer> cartIDs=new ArrayList<>();

        for (Cart c: userCarts){
            bookIDs.add(c.getBook_id());
            cartIDs.add(c.getCart_id());
        }
        return cartDAO.checkout(bookIDs, cartIDs);
    }

    @Override
    public String returnBook(Integer user_id, Integer book_id) {
        if(cartDAO.returnBook(user_id, book_id)){
            return "Book returned successfully.";
        }
        throw new BadRequestException("Unable to return now. Please try later.");
    }
}
