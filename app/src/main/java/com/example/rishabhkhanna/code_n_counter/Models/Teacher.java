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
    String id;


    public Teacher() {
    }


    public Teacher(String username, String email, String password, String qualification, String workingAt, String age, String contact, String id) {

        this.username = username;
        this.email = email;
        this.password = password;
        this.qualification = qualification;
        this.workingAt = workingAt;
        this.age = age;
        this.contact = contact;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setWorkingAt(String workingAt) {
        this.workingAt = workingAt;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
