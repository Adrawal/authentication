package com.aditya.views;

import com.aditya.entity.User;

public class LoginResponseView {

    private User user;
    private String jwt;

    public LoginResponseView() {
        super();
    }

    public LoginResponseView(User user, String jwt) {
        this.user = user;
        this.jwt = jwt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
