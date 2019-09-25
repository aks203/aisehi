package com.aks.POJO;


import java.sql.Blob;

public class BookPojo {

    private int book_id;

    private String title;

    private String author;

    private String category;

    private String publisher;

    private Blob content;

    private int countBooks;

    /**
     * @param title
     * @param author
     * @param category
     * @param publisher
     * @param countBooks
     */
    public BookPojo(String title, String author, String category, String publisher, int countBooks) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.publisher = publisher;
        this.countBooks = countBooks;
    }


    /**
     * @param book_id
     * @param title
     * @param author
     * @param category
     * @param publisher
     * @param countBooks
     */
    public BookPojo(int book_id, String title, String author, String category, String publisher, int countBooks) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.publisher = publisher;
        this.countBooks = countBooks;
    }


    /**
     * Default Constructor
     */
    public BookPojo() {
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

    /**
     * Gets count.
     *
     * @return Value of countBooks.
     */
    public int getCountBooks() {
        return countBooks;
    }

    /**
     * Sets new count.
     *
     * @param countBooks New value of count.
     */
    public void setCountBooks(int countBooks) {
        this.countBooks = countBooks;
    }
}
