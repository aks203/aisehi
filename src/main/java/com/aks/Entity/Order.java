package com.aks.Entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PURCHASE")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID", nullable = false, unique = true)
    private int order_id;

    //Always mark ManyToOne side as owning side
    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Book book;

    @Enumerated(EnumType.STRING)
    private STATUS status;

    public Order() {
    }

    /**
     *
     * @param user
     * @param book
     * @param status
     */
    public Order(User user, Book book, STATUS status) {
        this.user = user;
        this.book = book;
        this.status = status;
    }

    public int getOrder_id() {
        return order_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
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
