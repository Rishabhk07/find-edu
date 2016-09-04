package com.example.rishabhkhanna.code_n_counter.Models;

/**
 * Created by rishabhkhanna on 03/09/16.
 */
public class student {
    private String username;
    private String email;
    private String password;
    private String institute;
    private int age;
    private String contact_information;
    String studId;

    public student(String username,String email,String password,String institue,int age,String contact_information, String studId) {
        setUsername(username);
        setEmail(email);
        setPassword(password);
        setInstitute(institue);
        setAge(age);
        setContact_information(contact_information);
        this.studId = studId;
    }

    public String getStudId() {
        return studId;
    }

    public void setStudId(String studId) {
        this.studId = studId;
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

    public String getInstitute() {
        return institute;
    }

    public int getAge() {
        return age;
    }

    public String getContact_information() {
        return contact_information;
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

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setContact_information(String contact_information) {
        this.contact_information = contact_information;
    }
}
