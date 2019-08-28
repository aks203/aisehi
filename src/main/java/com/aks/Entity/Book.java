package com.aks.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BOOK")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_ID", nullable = false, unique = true)
    private int book_id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "AUTHOR", nullable = false)
    private String author;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "PUBLISHER")
    private String publisher;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")
    private Order order;

    @ManyToMany(mappedBy = "books")
    private List<Cart> carts=new ArrayList<Cart>();
    /**
     *
     * @param title
     * @param author
     * @param category
     * @param publisher
     */
    public Book(String title, String author, String category, String publisher) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.publisher = publisher;
    }

    /**
     * Default Constructor
     */
    public Book() {
    }


    /**
     * Getters and setters
     */



    public Order getOrder() {
        return order;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getId() {
        return book_id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", publisher='" + publisher + '\'' +
                ", order=" + order +
                '}';
    }
}
