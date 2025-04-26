package com.media.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login {

    @Id
    @Column(name = "username", length = 20)
    private String username;

    @Column(name = "password", length = 16)
    private String password;

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Constructors
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Login() {
    }

    @Override
    public String toString() {
        return "Login [username=" + username + ", password=" + password + "]";
    }
}
