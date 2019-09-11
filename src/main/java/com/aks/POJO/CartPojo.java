package com.aks.POJO;

import java.util.ArrayList;
import java.util.List;

public class CartPojo {

    private int cartId;

    private List<BookPojo> books=new ArrayList<BookPojo>();


    private UserPojo user;

    public CartPojo() {
    }

    /**
     *
     * @return
     */
    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public List<BookPojo> getBooks() {
        return books;
    }

    public void setBooks(List<BookPojo> books) {
        this.books = books;
    }
}
