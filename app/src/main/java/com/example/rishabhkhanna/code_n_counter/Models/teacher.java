package com.example.rishabhkhanna.code_n_counter.Models;

/**
 * Created by rishabhkhanna on 03/09/16.
 */
public class Teacher {

    String username;
    String email;
    String password;
    String qualification;
    String workingAt;
    String age;
    String contact;


    public Teacher() {
    }


    public Teacher(String username, String email, String password, String qualification, String workingAt, String age, String contact) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.qualification = qualification;
        this.workingAt = workingAt;
        this.age = age;
        this.contact = contact;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getQualification() {
        return qualification;
    }

    public String getWorkingAt() {
        return workingAt;
    }

    public String getAge() {
        return age;
    }

    public String getContact() {
        return contact;
    }
}
