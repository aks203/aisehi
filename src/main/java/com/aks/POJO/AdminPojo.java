package com.aks.POJO;

public class AdminPojo {

    private int id;


    private String name;


    private String email;


    private String password;


    private String phone;


    private String language;

    public AdminPojo() {
    }

    /**
     * @param name
     * @param email
     * @param password
     * @param phone
     * @param language
     */
    public AdminPojo(String name, String email, String password, String phone, String language) {
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
