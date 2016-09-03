package com.example.rishabhkhanna.code_n_counter.Models;

/**
 * Created by rishabhkhanna on 03/09/16.
 */
public class teacher {
    String username;
    String email;
    String password;


    public teacher() {
    }

    public teacher(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
