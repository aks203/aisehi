package com.aks.Entity;

import javax.persistence.*;
import java.sql.Blob;

/**
 * Book entity
 */

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

    @Column(name="content")
    @Lob
    private Blob content;

    @Column(name = "PUBLISHER")
    private String publisher;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")
    private Order order;

    /**
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
     * @param title
     * @param author
     * @param category
     * @param content
     * @param publisher
     */
    public Book(String title, String author, String category, Blob content, String publisher) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.content = content;
        this.publisher = publisher;
    }


    /**
     * Default Constructor
     */
    public Book() {
    }

    /**
     *
     * @return Book object in string format
     */
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

    /**
     * Gets publisher.
     *
     * @return Value of publisher.
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Gets title.
     *
     * @return Value of title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets new category.
     *
     * @param category New value of category.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Sets new publisher.
     *
     * @param publisher New value of publisher.
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Gets order.
     *
     * @return Value of order.
     */
    public Order getOrder() {
        return order;
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
     * Sets new author.
     *
     * @param author New value of author.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets category.
     *
     * @return Value of category.
     */
    public String getCategory() {
        return category;
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
     * Sets new order.
     *
     * @param order New value of order.
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * Sets new title.
     *
     * @param title New value of title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets author.
     *
     * @return Value of author.
     */
    public String getAuthor() {
        return author;
    }


    /**
     * Sets new content.
     *
     * @param content New value of content.
     */
    public void setContent(Blob content) {
        this.content = content;
    }

    /**
     * Gets content.
     *
     * @return Value of content.
     */
    public Blob getContent() {
        return content;
    }
}
