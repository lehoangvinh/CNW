package com.example.shopson.model.bean;

public class CartOrder {
        public int id;
        public int quantity;
        public  float total_price;
        public boolean paid_status;

        public  int user_id;

    public CartOrder() {

    }
    public CartOrder(int id, int quantity, float total_price, boolean paid_status, int user_id) {
        this.id = id;
        this.quantity = quantity;
        this.total_price = total_price;
        this.paid_status = paid_status;
        this.user_id = user_id;
    }
    public CartOrder( int id, float total_price, boolean paid_status, int user_id) {
        this.id = id;
        this.total_price = total_price;
        this.paid_status = paid_status;
        this.user_id = user_id;
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
