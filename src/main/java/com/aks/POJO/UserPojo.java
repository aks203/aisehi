package com.aks.POJO;

import java.util.ArrayList;
import java.util.List;

public class UserPojo{
    private int id;

    private String name;

    private String email;

    private String password;

    private String language;

    private String role;

    private CartPojo cart;

    /**
     * Default Constructor
     */
    public UserPojo() {
    }

    /**
     *
     * @param name
     * @param email
     * @param password
     * @param language
     * @param role
     */
    public UserPojo(String name, String email, String password, String language, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.language = language;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public CartPojo getCart() {
        return cart;
    }

    public void setCart(CartPojo cart) {
        this.cart = cart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "UserPojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", language='" + language + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
