package com.example.coffee_shop.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {

    private String username;

    private String password;

    private Long id;

    public CurrentUser() {
    }

    public String getUsername() {
        return username;
    }

    public CurrentUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public CurrentUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public Long getId(){
        return this.id;
    }

    public CurrentUser setId(Long id) {
        this.id = id;
        return this;
    }

    public Boolean isLoggedIn() {
        return this.id != null && this.username != null && this.password != null;
    }


}
