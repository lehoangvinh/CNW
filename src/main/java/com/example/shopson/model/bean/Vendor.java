package com.example.shopson.model.bean;

public class Vendor {
    private int id;
    private String vendor_name;
    private int user_id;

    public Vendor(int id, String vendor_name, int user_id) {
        this.id = id;
        this.vendor_name = vendor_name;
        this.user_id = user_id;
    }

    public Vendor(String vendor_name, int user_id) {
        this.vendor_name = vendor_name;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVendor_name() {
        return vendor_name;
    }

    public void setVendor_name(String vendor_name) {
        this.vendor_name = vendor_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
