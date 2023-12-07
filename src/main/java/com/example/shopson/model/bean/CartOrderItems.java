package com.example.shopson.model.bean;

public class CartOrderItems {
    private int id;
    private int quantity;
    private float sub_total_price;
    private int cart_order_id;
    private int product_id;

    public CartOrderItems(int id, int quantity, float sub_total_price, int cart_order_id, int product_id) {
        this.id = id;
        this.quantity = quantity;
        this.sub_total_price = sub_total_price;
        this.cart_order_id = cart_order_id;
        this.product_id = product_id;
    }

    public CartOrderItems(int quantity, float sub_total_price, int cart_order_id, int product_id) {
        this.quantity = quantity;
        this.sub_total_price = sub_total_price;
        this.cart_order_id = cart_order_id;
        this.product_id = product_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSub_total_price() {
        return sub_total_price;
    }

    public void setSub_total_price(float sub_total_price) {
        this.sub_total_price = sub_total_price;
    }

    public int getCart_order_id() {
        return cart_order_id;
    }

    public void setCart_order_id(int cart_order_id) {
        this.cart_order_id = cart_order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
}
