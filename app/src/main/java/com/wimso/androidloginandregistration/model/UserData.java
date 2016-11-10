package com.wimso.androidloginandregistration.model;

/**
 * Created by Wim on 11/4/16.
 */
public class UserData {

    private String firstname;
    private String lastname;
    private String email;

    public UserData() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
