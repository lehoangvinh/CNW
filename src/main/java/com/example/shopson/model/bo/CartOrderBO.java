package com.example.shopson.model.bo;

import com.example.shopson.model.bean.CartOrder;
import com.example.shopson.model.dao.CartOrderDAO;

public class CartOrderBO {
    public CartOrderDAO cartOrderDAO = new CartOrderDAO();
    public CartOrder getCartOrderById(int id){
        return cartOrderDAO.getOrCreateCartOrder(id);
    }

}
