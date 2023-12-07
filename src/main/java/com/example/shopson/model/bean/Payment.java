package com.example.shopson.model.bean;

public class Payment {
    public enum PaymentType {
        CASH, CARD, TRANSFER
    }

    private int id;
    private String address;
    private PaymentType payment_type;
    private int cart_order_id;

    public Payment(int id, String address, PaymentType payment_type, int cart_order_id) {
        this.id = id;
        this.address = address;
        this.payment_type = payment_type;
        this.cart_order_id = cart_order_id;
    }

    public Payment(String address, PaymentType payment_type, int cart_order_id) {
        this.address = address;
        this.payment_type = payment_type;
        this.cart_order_id = cart_order_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PaymentType getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(PaymentType payment_type) {
        this.payment_type = payment_type;
    }

    public int getCart_order_id() {
        return cart_order_id;
    }

    public void setCart_order_id(int cart_order_id) {
        this.cart_order_id = cart_order_id;
    }
}
