package com.aks.POJO;

public class TokenPojo {

    private int user_id;

    private String token;

    public TokenPojo(int user_id, String token) {
        this.user_id = user_id;
        this.token = token;
    }

    public TokenPojo() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "TokenPojo{" +
                "user_id='" + user_id + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
