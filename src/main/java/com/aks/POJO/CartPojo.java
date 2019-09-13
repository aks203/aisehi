package com.aks.POJO;

import java.util.ArrayList;
import java.util.List;

public class CartPojo {

    private int cart_id;

    private int user_id;

    private int book_id;

    /**
     *
     * @param user_id
     * @param book_id
     */
    public CartPojo(int user_id, int book_id) {
        this.user_id = user_id;
        this.book_id = book_id;
    }

    /**
     * Default Constructor
     */
    public CartPojo() {
    }

    /**
     *
     * @param cart_id
     * @param user_id
     * @param book_id
     */
    public CartPojo(int cart_id, int user_id, int book_id) {
        this.cart_id = cart_id;
        this.user_id = user_id;
        this.book_id = book_id;
    }

    /**
     * Gets book_id.
     *
     * @return Value of book_id.
     */
    public int getBook_id() {
        return book_id;
    }

    /**
     * Sets new book_id.
     *
     * @param book_id New value of book_id.
     */
    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }


    /**
     * Sets new cart_id.
     *
     * @param cart_id New value of cart_id.
     */
    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    /**
     * Gets cart_id.
     *
     * @return Value of cart_id.
     */
    public int getCart_id() {
        return cart_id;
    }


    /**
     * Gets user_id.
     *
     * @return Value of user_id.
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * Sets new user_id.
     *
     * @param user_id New value of user_id.
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
