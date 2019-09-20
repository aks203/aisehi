package com.aks.POJO;


import java.sql.Blob;

public class BookPojo {

    private int book_id;

    private String title;

    private String author;

    private String category;

    private String publisher;

    private Blob content;

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
     * @param title
     * @param author
     * @param category
     * @param publisher
     * @param content
     */
    public BookPojo(String title, String author, String category, String publisher, Blob content) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.publisher = publisher;
        this.content = content;
    }

    /**
     * @param book_id
     * @param title
     * @param author
     * @param category
     * @param publisher
     * @param content
     */
    public BookPojo(int book_id, String title, String author, String category, String publisher, Blob content) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.publisher = publisher;
        this.content = content;
    }

    /**
     * Default Constructor
     */
    public BookPojo() {
    }

    /**
     *
     * @param book_id
     * @param title
     * @param author
     * @param category
     * @param publisher
     */
    public BookPojo(int book_id, String title, String author, String category, String publisher) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.publisher = publisher;
    }

    /**
     *
     * @return BookPojo object in String format
     */
    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", publisher='" + publisher + '\'' +
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
     * Gets book_id.
     *
     * @return Value of book_id.
     */
    public int getBook_id() {
        return book_id;
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
     * Gets category.
     *
     * @return Value of category.
     */
    public String getCategory() {
        return category;
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
     * Gets author.
     *
     * @return Value of author.
     */
    public String getAuthor() {
        return author;
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
     * Gets title.
     *
     * @return Value of title.
     */
    public String getTitle() {
        return title;
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
