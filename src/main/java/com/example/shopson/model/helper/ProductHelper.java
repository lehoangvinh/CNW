package com.example.shopson.model.helper;

public class ProductHelper {
    private int id;
    private String product_name;
    private float price;
    private String description;
    private int vendor_id;
    private String vendor_name;
    private String category_name;
    private int category_id;
    private String image;

    public ProductHelper(int id, String product_name, float price, String description, int vendor_id, String vendor_name, String category_name, int category_id, String image) {
        this.id = id;
        this.product_name = product_name;
        this.price = price;
        this.description = description;
        this.vendor_id = vendor_id;
        this.vendor_name = vendor_name;
        this.category_name = category_name;
        this.category_id = category_id;
        this.image = image;
    }

    public ProductHelper(String product_name, float price, String description, int vendor_id, String vendor_name, String category_name, int category_id, String image) {
        this.product_name = product_name;
        this.price = price;
        this.description = description;
        this.vendor_id = vendor_id;
        this.vendor_name = vendor_name;
        this.category_name = category_name;
        this.category_id = category_id;
        this.image = image;
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

    public String getVendor_name() {
        return vendor_name;
    }

    public void setVendor_name(String vendor_name) {
        this.vendor_name = vendor_name;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
