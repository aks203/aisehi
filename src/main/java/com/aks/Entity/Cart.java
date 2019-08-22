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
            inverseJoinColumns = { @JoinColumn(name = "ORDER_ID") }
    )
    private List<Order> orders=new ArrayList<Order>();

    public Cart() {
    }

    /**
     * @param orders
     */
    public Cart(List<Order> orders) {
        this.orders = orders;
    }

    public int getCartId() {
        return cartId;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
