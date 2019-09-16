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

    /**
     * @return UserPojo object in String format
     */
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

    /**
     * Sets new email.
     *
     * @param email New value of email.
     */
    public void setEmail(String email) {
        this.email = email;
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
     * Gets name.
     *
     * @return Value of name.
     */
    public String getName() {
        return name;
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
     * Sets new language.
     *
     * @param language New value of language.
     */
    public void setLanguage(String language) {
        this.language = language;
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
     * Gets id.
     *
     * @return Value of id.
     */
    public int getId() {
        return id;
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
     * Sets new password.
     *
     * @param password New value of password.
     */
    public void setPassword(String password) {
        this.password = password;
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
     * Sets new role.
     *
     * @param role New value of role.
     */
    public void setRole(String role) {
        this.role = role;
    }
}
