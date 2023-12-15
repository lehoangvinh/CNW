package com.example.shopson.model.helper;

public class ProductsVendor {
    private int id;
    private String productName;
    private float price;
    private String description;
    private String image;
    private int categoryId;
    private int vendorId;
    private int userId;
    private String vendorName;
    private String categoryName;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public String getImage() {
        int index = image.lastIndexOf("upload\\");
        if (index != -1) {
            // Lấy phần sau của chuỗi bắt đầu từ "upload\"
            String result = image.substring(index);
            // Thay thế tất cả backslashes bằng forward slashes
            result = result.replace("\\", "/");
            return result;
        } else {
            return "";
        }
        // return image;
    }


    public void setImage(String image) {
        this.image = image;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
