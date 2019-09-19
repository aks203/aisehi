package com.aks.DAO;

import com.aks.Entity.Cart;

import java.util.List;

public interface CartDAO {
    List<Cart> getCart(Integer user_id);

    String addBookToCart(Cart cart);

    int deleteBookFromCart(Cart cart);
}
