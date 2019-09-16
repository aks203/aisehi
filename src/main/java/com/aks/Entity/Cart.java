package com.aks.Entity;

import javax.persistence.*;

/**
 * Cart entity representing book in a cart
 */
@Entity
@Table(name = "CART")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CART_ID", nullable = false, unique = true)
    private int cart_id;

    @Column(name = "USER_ID")
    private int user_id;

    @Column(name = "BOOK_ID")
    private int book_id;

    /**
     * @param user_id
     * @param book_id
     */
    public Cart(int user_id, int book_id) {
        this.user_id = user_id;
        this.book_id = book_id;
    }

    /**
     * Default Constructor
     */
    public Cart() {
    }

    /**
     * Sets new user_id.
     *
     * @param user_id New value of user_id.
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
     * Sets new cartId.
     *
     * @param cart_id New value of cartId.
     */
    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    /**
     * Gets cartId.
     *
     * @return Value of cartId.
     */
    public int getCart_id() {
        return cart_id;
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
}