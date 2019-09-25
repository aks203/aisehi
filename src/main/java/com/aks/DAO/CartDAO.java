package com.aks.DAO;

import com.aks.Entity.Cart;

import java.util.List;

public interface CartDAO {
    List<Cart> getCart(int user_id, int type);

    String addBookToCart(Cart cart);

    int deleteBookFromCart(Cart cart);

    String checkout(List<Integer> bookIDs, List<Integer> cart_id);

    boolean returnBook(Integer user_id, Integer book_id);
}
