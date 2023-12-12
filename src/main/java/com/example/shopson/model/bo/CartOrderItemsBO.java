package com.example.shopson.model.bo;

import com.example.shopson.model.bean.CartOrderItems;
import com.example.shopson.model.dao.CartOrderItemsDAO;

import java.util.List;

public class CartOrderItemsBO {

    private CartOrderItemsDAO cartOrderItemsDAO;

    public CartOrderItemsBO() {
        this.cartOrderItemsDAO = new CartOrderItemsDAO();
    }

    public List<CartOrderItems> getAllCartOrderItems() {
        return cartOrderItemsDAO.getAllCartOrderItems();
    }

    public CartOrderItems getCartOrderItemById(int id) {
        return cartOrderItemsDAO.getCartOrderItemById(id);
    }

    public boolean addCartOrderItems(CartOrderItems cartOrderItems) {
        return cartOrderItemsDAO.addCartOrderItems(cartOrderItems);
    }

    public boolean updateCartOrderItems(int id, CartOrderItems cartOrderItems) {
        return cartOrderItemsDAO.updateCartOrderItems(id, cartOrderItems);
    }


    public List<CartOrderItems> getAllCartOrderItemsByCartOrderId(int cartOrderId) {
        return cartOrderItemsDAO.getAllCartOrderItemsByCartOrderId(cartOrderId);
    }

    public CartOrderItems getCartOrderItemsByProductIdAndCartOrderId(int productId, int cartOrderId) {
        return cartOrderItemsDAO.getCartOrderItemsByProductIdAndCartOrderId(productId, cartOrderId);
    }

    public boolean updateCartOrderItemQuantity(int id, int newQuantity) {
        return cartOrderItemsDAO.updateCartOrderItemQuantity(id, newQuantity);
    }

    public boolean deleteCartOrderItem(int id) {
        return cartOrderItemsDAO.deleteCartOrderItem(id);
    }
}
