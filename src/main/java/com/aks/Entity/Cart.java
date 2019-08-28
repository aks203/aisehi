package com.aks.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CART")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="CART_ID", nullable = false, unique = true)
    private int cartId;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Cart_Items",
            joinColumns = { @JoinColumn(name = "CART_ID") },
            inverseJoinColumns = { @JoinColumn(name = "BOOK_ID") }
    )
    private List<Book> books=new ArrayList<Book>();


    @OneToOne(mappedBy = "cart")
    private User user;

    public Cart() {
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
