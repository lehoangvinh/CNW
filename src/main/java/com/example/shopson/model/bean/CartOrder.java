package com.example.shopson.model.bean;

import java.time.LocalDate;

public class CartOrder {
    public int id;
    public LocalDate order_date;
    public float total_price;
    public boolean paid_status;
    public int user_id;

    public CartOrder(int id, LocalDate order_date, float total_price, boolean paid_status, int user_id) {
        this.id = id;
        this.order_date = order_date;
        this.total_price = total_price;
        this.paid_status = paid_status;
        this.user_id = user_id;
    }

    public CartOrder(LocalDate order_date, float total_price, boolean paid_status, int user_id) {
        this.order_date = order_date;
        this.total_price = total_price;
        this.paid_status = paid_status;
        this.user_id = user_id;
    }

    // Các phương thức getter và setter...

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getOrder_date() {
        return order_date;
    }

    public void setOrder_date(LocalDate order_date) {
        this.order_date = order_date;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    public boolean isPaid_status() {
        return paid_status;
    }

    public void setPaid_status(boolean paid_status) {
        this.paid_status = paid_status;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
