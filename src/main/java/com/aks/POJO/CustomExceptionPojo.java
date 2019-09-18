package com.aks.POJO;

public class CustomExceptionPojo {
    private int status;

    private String message;


    /**
     * Gets status.
     *
     * @return Value of status.
     */
    public int getStatus() {
        return status;
    }

    /**
     * Gets message.
     *
     * @return Value of message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets new message.
     *
     * @param message New value of message.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Sets new status.
     *
     * @param status New value of status.
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @param status
     * @param message
     */
    public CustomExceptionPojo(int status, String message) {
        this.status = status;
        this.message = message;
    }

    /**
     * Default Constructor
     */
    public CustomExceptionPojo() {
    }
}
