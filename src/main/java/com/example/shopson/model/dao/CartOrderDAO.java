package com.example.shopson.model.dao;

import com.example.shopson.model.bean.CartOrder;
import com.example.shopson.model.helper.ProductHelper;
import com.example.shopson.utils.DButils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartOrderDAO {
    private String GET_CART_ORDER_BY_ID_USER = "SELECT * FROM cart_order WHERE user_id = ? AND paid_status = ?";

    private String UPDATE_STATUS_CART = "UPDATE cart_order SET paid_status = 1 WHERE id = ?";

    public CartOrderDAO() {
    }
    public void updateStatusCart(int cart_order_id) {
        try(Connection connection = DButils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STATUS_CART);) {
            preparedStatement.setInt(1, cart_order_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void insertCartOrder(int user_id){
        try(Connection connection = DButils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cart_order (user_id,paid_status) VALUES (?,?)");) {
            preparedStatement.setInt(1, user_id);
            preparedStatement.setBoolean(2, false);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public CartOrder getOrCreateCartOrder(int user_id) {
        CartOrder cartOrder = getCartOrderByIdUser(user_id);

        if (cartOrder == null || cartOrder.isPaid_status()) {
            // If there is no cart or the existing cart is already paid, create a new one
            insertCartOrder(user_id);
            cartOrder = getCartOrderByIdUser(user_id);
        }

        return cartOrder;
    }
    public CartOrder getCartOrderByIdUser(int user_id){
        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_CART_ORDER_BY_ID_USER)) {
            preparedStatement.setInt(1, user_id);
            preparedStatement.setBoolean(2, false);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new CartOrder(
                        resultSet.getInt("id"),
                        resultSet.getFloat("total_price"),
                        resultSet.getBoolean("paid_status"),
                        resultSet.getInt("user_id")
                );
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
