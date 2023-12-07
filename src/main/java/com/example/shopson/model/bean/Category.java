package com.example.shopson.model.bean;

public class Category {
    private String id;
    private String category_name;

    public Category(String id, String category_name) {
        this.id = id;
        this.category_name = category_name;
    }

    public Category(String category_name) {
        this.category_name = category_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
