package com.example.shopson.model.bo;

import com.example.shopson.model.dao.CartOrderDAO;
import com.example.shopson.model.dao.CartOrderItemDAO;
import com.example.shopson.model.helper.ProductHelper;

import java.util.List;

public class CartOrderItemBO {
    public CartOrderDAO cartOrderDAO = new CartOrderDAO();
    public CartOrderItemDAO cartOrderItemDAO = new CartOrderItemDAO();
    public ProductBO productBO = new ProductBO();

    // khi click thì add to cart
    public void addCartOrderItem(int cart_order_id, int product_id, int user_id){
        ProductHelper productHelper = productBO.getProductById(product_id);
        cartOrderItemDAO.addCartOrderItem(cart_order_id,productHelper.getPrice(), product_id);
    }
    public List<ProductHelper> getCartOrderItemByCartOrderId(int cart_order_id){
        return cartOrderItemDAO.getAllCarOrderItemByIdUser(cart_order_id);
    }
}
