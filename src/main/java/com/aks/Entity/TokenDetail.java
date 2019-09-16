package com.aks.Entity;

import javax.persistence.*;

/**
 * Token entity for validating api requests
 */
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


    /**
     * Default Constructor
     */
    public TokenDetail() {
    }

    /**
     *
     * @param user_id
     * @param token
     */
    public TokenDetail(int user_id, String token) {
        this.user_id = user_id;
        this.token = token;
    }

    /**
     *
     * @return Token object in String format
     */
    @Override
    public String toString() {
        return "TokenDetail{" +
                "user_id=" + user_id +
                ", token='" + token + '\'' +
                '}';
    }

    /**
     * Sets new user_id.
     *
     * @param user_id New value of user_id.
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * Sets new token.
     *
     * @param token New value of token.
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Gets user_id.
     *
     * @return Value of user_id.
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * Gets token_id.
     *
     * @return Value of token_id.
     */
    public int getToken_id() {
        return token_id;
    }

    /**
     * Sets new token_id.
     *
     * @param token_id New value of token_id.
     */
    public void setToken_id(int token_id) {
        this.token_id = token_id;
    }

    /**
     * Gets token.
     *
     * @return Value of token.
     */
    public String getToken() {
        return token;
    }
}
