package com.aks.Entity;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "ADMIN")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADMIN_ID", nullable = false, unique = true)
    private int id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Email(message = "Please enter correct email-id.")
    @Column(name = "EMAIL",unique = true, nullable = false)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "LANGUAGE")
    private String language;

    public Admin() {
    }

    /**
     * @param name
     * @param email
     * @param password
     * @param phone
     * @param language
     */
    public Admin(String name, @Email(message = "Please enter correct email-id.") String email, String password, String phone, String language) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.language = language;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
