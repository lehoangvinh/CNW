package com.example.shopson.model.bean;

public class User {
    private int id;
    private String username;
    private String password;
    private String fullname;
    private String phone_number;
    private String address;
    private int role_id;

    public User(String username, String password, String name, String phone_number, int role_id) {
        this.username = username;
        this.password = password;
        this.fullname = name;
        this.phone_number = phone_number;
        this.role_id = role_id;
    }

    public User(int id, String username, String password, String fullname, String phone_number, int role_id) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.phone_number = phone_number;
        this.role_id = role_id;
    }

    public User(String username, String password, String fullname, String phone_number, String address, int role_id) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.phone_number = phone_number;
        this.address = address;
        this.role_id = role_id;
    }

    public User(int id, String username, String password, String fullname, String phone_number, String address, int role_id) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.phone_number = phone_number;
        this.address = address;
        this.role_id = role_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
