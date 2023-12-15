package com.example.shopson.model.helper;

public class AuthHelper {
    private String username;
    int role_id;
    int user_id;

    public AuthHelper(String username, int role_id) {
        this.username = username;
        this.role_id = role_id;
    }

    public AuthHelper(String username, int role_id, int user_id) {
        this.username = username;
        this.role_id = role_id;
        this.user_id = user_id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
