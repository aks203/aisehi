package com.aks.Controller;

import com.aks.POJO.BookPojo;
import com.aks.POJO.CartPojo;
import com.aks.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @GetMapping("/{user_id}")
    public @ResponseBody
    List<BookPojo> getCart(@PathVariable("user_id") Integer user_id){
        return cartService.getCart(user_id);
    }

    @PostMapping("/add/{user_id}/{book_id}")
    public @ResponseBody
    String addToCart(@PathVariable("user_id") Integer user_id,
                     @PathVariable("book_id") Integer book_id){
        return cartService.addBook(user_id, book_id);
    }

    @DeleteMapping("/{user_id}/{book_id}")
    public @ResponseBody
    String deleteBookFromCart(@PathVariable("user_id") Integer user_id,
                     @PathVariable("book_id") Integer book_id){
        return cartService.deleteBook(user_id, book_id);
    }

}
