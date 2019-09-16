package com.aks.Controller;

import com.aks.POJO.BookPojo;
import com.aks.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Rest controller api for cart related requests
 * User id must be passed in header under "user_id" field for api requests
 *
 * url                              HTTP Method  Operation
 * /api/cart/:user_id               GET          Get list of all books in user's cart
 * /api/cart/add/:user_id/:book_id  POST         Add a new book and return success/error message
 * /api/cart/:user_id/:book_id      DELETE       Delete the book in cart
 */
@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    CartService cartService;

    /**
     * Get cart for a user
     * @param user_id
     * @return A list of carts corresponding to that user
     */
    @GetMapping("/{user_id}")
    public @ResponseBody
    List<BookPojo> getCart(@PathVariable("user_id") Integer user_id){
        try {
            return cartService.getCart(user_id);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Add a book to cart of user
     * @param user_id
     * @param book_id
     * @return Success/Error message
     */
    @PostMapping("/add/{user_id}/{book_id}")
    public @ResponseBody
    String addToCart(@PathVariable("user_id") Integer user_id,
                     @PathVariable("book_id") Integer book_id){
        try {
            return cartService.addBook(user_id, book_id);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return "Error adding book to cart. Please try after some time.";
        }
    }

    /**
     * Delete a book from cart of a user
     * @param user_id
     * @param book_id
     * @return Success/Error message
     */
    @DeleteMapping("/{user_id}/{book_id}")
    public @ResponseBody
    String deleteBookFromCart(@PathVariable("user_id") Integer user_id,
                     @PathVariable("book_id") Integer book_id){
        try {
            return cartService.deleteBook(user_id, book_id);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return "Error deleting book from cart. Please try after sometime.";
        }
    }
}
