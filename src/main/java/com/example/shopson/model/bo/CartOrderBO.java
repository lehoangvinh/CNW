package com.example.shopson.model.bo;

import com.example.shopson.model.bean.CartOrder;
import com.example.shopson.model.dao.CartOrderDAO;

import java.time.LocalDate;
import java.util.List;

public class CartOrderBO {
    private CartOrderDAO cartOrderDAO = new CartOrderDAO();

    public boolean addCartOrder(LocalDate orderDate, float totalPrice, boolean paidStatus, int userId) {
        CartOrder cartOrder = new CartOrder(orderDate, totalPrice, paidStatus, userId);
        return cartOrderDAO.addCartOrder(cartOrder);
    }

    public boolean updateCartOrder(int id, LocalDate orderDate, float totalPrice, boolean paidStatus, int userId) {
        CartOrder cartOrder = new CartOrder(id, orderDate, totalPrice, paidStatus, userId);
        return cartOrderDAO.updateCartOrder(id, cartOrder);
    }

    public boolean deleteCartOrder(int id) {
        return cartOrderDAO.deleteCartOrder(id);
    }

    public List<CartOrder> getAllCartOrders() {
        return cartOrderDAO.getAllCartOrders();
    }

    public CartOrder getCartOrderById(int id) {
        return cartOrderDAO.getCartOrderById(id);
    }
    public CartOrder getCartOrderNotPaidByUserId(int user_id) {
        return cartOrderDAO.getCartOrderNotPaidByUserId(user_id);
    }
}
