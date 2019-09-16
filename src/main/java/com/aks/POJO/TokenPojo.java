package com.aks.POJO;

public class TokenPojo {

    private int user_id;

    private String token;

    /**
     * Default constructor
     */
    public TokenPojo() {
    }

    /**
     * @param user_id
     * @param token
     */
    public TokenPojo(int user_id, String token) {
        this.user_id = user_id;
        this.token = token;
    }

    /**
     * @return TokenPojo object in String format
     */
    @Override
    public String toString() {
        return "TokenPojo{" +
                "user_id='" + user_id + '\'' +
                ", token='" + token + '\'' +
                '}';
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
     * Sets new token.
     *
     * @param token New value of token.
     */
    public void setToken(String token) {
        this.token = token;
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
     * Gets token.
     *
     * @return Value of token.
     */
    public String getToken() {
        return token;
    }
}
