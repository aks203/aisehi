package com.aks.POJO;

import com.aks.Entity.STATUS;

public class OrderPojo {
    private int order_id;

    private UserPojo user;

    private BookPojo book;

    private STATUS status;

    public OrderPojo() {
    }

    /**
     * @param user
     * @param book
     * @param status
     */
    public OrderPojo(UserPojo user, BookPojo book, STATUS status) {
        this.user = user;
        this.book = book;
        this.status = status;
    }

    public int getOrder_id() {
        return order_id;
    }

    public UserPojo getUser() {
        return user;
    }

    public void setUser(UserPojo user) {
        this.user = user;
    }

    public BookPojo getBook() {
        return book;
    }

    public void setBook(BookPojo book) {
        this.book = book;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", user=" + user +
                ", book=" + book +
                ", status=" + status +
                '}';
    }
}
