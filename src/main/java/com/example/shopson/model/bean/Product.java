package com.example.shopson.model.bean;

public class Product {
    private int id;
    private String product_name;
    private float price;
    private String description;
    private int vendor_id;
    private String image;
    private int  category_id;// max mau

    public Product(int id, String product_name, float price, String description, int vendor_id, String image, int category_id) {
        this.id = id;
        this.product_name = product_name;
        this.price = price;
        this.description = description;
        this.vendor_id = vendor_id;
        this.image = image;
        this.category_id = category_id;
    }

    public Product(String product_name, float price, String description, int vendor_id, String image, int category_id) {
        this.product_name = product_name;
        this.price = price;
        this.description = description;
        this.vendor_id = vendor_id;
        this.image = image;
        this.category_id = category_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(int vendor_id) {
        this.vendor_id = vendor_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
