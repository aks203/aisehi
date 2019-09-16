package com.aks.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * User entity class
 */
@Entity
@Table(name = "USER")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false, unique = true)
    private int id;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

//    @Email(message = "Please enter correct email-id.")
    @NotNull
    @Column(name = "EMAIL",unique = true, nullable = false)
    private String email;

    @NotNull
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @NotNull
    @Column(name = "LANGUAGE")
    private String language;

    @Column(name = "ROLE")
    private String role;

//    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL})
//    //Lazy loading problem while rendering JSON in Backbone
//    //Thus, used @JsonIgnore.
//    @JsonIgnore
//    private List<Order> orders=new ArrayList<Order>();

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "SUBS_ID", referencedColumnName = "SUBS_ID")
    private Subscription subscription;

//    @JsonIgnore
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "CART_ID", referencedColumnName = "CART_ID")
//    private Cart cart;

    /**
     * Default Constructor
     */
    public User() {
    }

    /**
     *
     * @param name
     * @param email
     * @param password
     * @param language
     * @param subscription
     */
    public User(String name, String email, String password, String language, Subscription subscription) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.language = language;
        this.subscription = subscription;
    }

    /**
     *
     * @param name
     * @param email
     * @param password
     * @param language
     * @param role
     */
    public User(@NotNull String name, @NotNull String email, @NotNull String password, @NotNull String language, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.language = language;
        this.role = role;
    }


    /**
     * Sets new email.
     *
     * @param email New value of email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets new subscription.
     *
     * @param subscription New value of subscription.
     */
    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    /**
     * Sets new id.
     *
     * @param id New value of id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets new name.
     *
     * @param name New value of name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets password.
     *
     * @return Value of password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets id.
     *
     * @return Value of id.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets role.
     *
     * @return Value of role.
     */
    public String getRole() {
        return role;
    }

    /**
     * Gets name.
     *
     * @return Value of name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets new language.
     *
     * @param language New value of language.
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Gets subscription.
     *
     * @return Value of subscription.
     */
    public Subscription getSubscription() {
        return subscription;
    }

    /**
     * Gets language.
     *
     * @return Value of language.
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Gets email.
     *
     * @return Value of email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets new password.
     *
     * @param password New value of password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets new role.
     *
     * @param role New value of role.
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     *
     * @return User object in String format
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
