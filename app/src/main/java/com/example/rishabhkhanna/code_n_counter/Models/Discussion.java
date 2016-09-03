package com.example.rishabhkhanna.code_n_counter.Models;

/**
 * Created by devesh on 4/9/16.
 */
public class Discussion {

    String user;
    String message;

    public Discussion(String user, String message) {
        this.user = user;
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
