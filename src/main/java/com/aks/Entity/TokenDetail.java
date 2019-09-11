package com.aks.Entity;

import javax.persistence.*;

@Entity
@Table(name = "TokenDetail")
public class TokenDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TOKEN_ID", nullable = false, unique = true)
    private int token_id;

    @Column(name = "USER_ID", nullable = false)
    private int user_id;

    @Column(name = "TOKEN", nullable = false)
    private String token;

    public TokenDetail() {
    }

    public TokenDetail(int user_id, String token) {
        this.user_id = user_id;
        this.token = token;
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
        return "TokenDetail{" +
                "user_id=" + user_id +
                ", token='" + token + '\'' +
                '}';
    }
}
