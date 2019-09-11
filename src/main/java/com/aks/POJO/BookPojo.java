package com.aks.POJO;


import java.util.ArrayList;
import java.util.List;

public class BookPojo {

    private int book_id;

    private String title;

    private String author;

    private String category;

    private String publisher;

    private OrderPojo order;

    private List<CartPojo> carts=new ArrayList<CartPojo>();

    /**
     *
     * @param title
     * @param author
     * @param category
     * @param publisher
     */
    public BookPojo(String title, String author, String category, String publisher) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.publisher = publisher;
    }

    /**
     * Default Constructor
     */
    public BookPojo() {
    }

    /**
     * Getters and setters
     */

    public OrderPojo getOrder() {
        return order;
    }

    public List<CartPojo> getCarts() {
        return carts;
    }

    public void setCarts(List<CartPojo> carts) {
        this.carts = carts;
    }

    public void setOrder(OrderPojo order) {
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
