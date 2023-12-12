package com.example.shopson.model.dao;

import com.example.shopson.model.bean.CartOrder;
import com.example.shopson.utils.DButils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CartOrderDAO {
    private String ADD_CART_ORDER = "INSERT INTO cart_order (order_date, total_price, paid_status, user_id) VALUES (?, ?, ?, ?)";
    private String GET_ALL_CART_ORDERS = "SELECT * FROM cart_order";
    private String GET_CART_ORDER_BY_ID = "SELECT * FROM cart_order WHERE id = ?";
    private String UPDATE_CART_ORDER = "UPDATE cart_order SET order_date = ?, total_price = ?, paid_status = ?, user_id = ? WHERE id = ?";
    private String DELETE_CART_ORDER = "DELETE FROM cart_order WHERE id = ?";

    String GET_CART_ORDER_NOT_PAID_BY_USER_ID = "SELECT * FROM cart_order WHERE user_id = ? AND paid_status = false ORDER BY order_date LIMIT 1";

    public List<CartOrder> getAllCartOrders() {
        try (Connection connection = DButils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CART_ORDERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<CartOrder> cartOrders = new ArrayList<>();
            while (resultSet.next()) {
                CartOrder cartOrder = new CartOrder(
                        resultSet.getInt("id"),
                        resultSet.getDate("order_date").toLocalDate(),
                        resultSet.getFloat("total_price"),
                        resultSet.getBoolean("paid_status"),
                        resultSet.getInt("user_id")
                );
                cartOrders.add(cartOrder);
            }
            return cartOrders;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public CartOrder getCartOrderById(int id) {
        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_CART_ORDER_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                CartOrder cartOrder = new CartOrder(
                        resultSet.getInt("id"),
                        resultSet.getDate("order_date").toLocalDate(),
                        resultSet.getFloat("total_price"),
                        resultSet.getBoolean("paid_status"),
                        resultSet.getInt("user_id")
                );
                return cartOrder;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addCartOrder(CartOrder cartOrder) {
        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_CART_ORDER)) {
            preparedStatement.setDate(1, java.sql.Date.valueOf(cartOrder.getOrder_date()));
            preparedStatement.setFloat(2, cartOrder.getTotal_price());
            preparedStatement.setBoolean(3, cartOrder.isPaid_status());
            preparedStatement.setInt(4, cartOrder.getUser_id());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateCartOrder(int id, CartOrder cartOrder) {
        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CART_ORDER)) {
            preparedStatement.setDate(1, java.sql.Date.valueOf(cartOrder.getOrder_date()));
            preparedStatement.setFloat(2, cartOrder.getTotal_price());
            preparedStatement.setBoolean(3, cartOrder.isPaid_status());
            preparedStatement.setInt(4, cartOrder.getUser_id());
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public CartOrder getCartOrderNotPaidByUserId(int userId) {
        String GET_CART_ORDER_NOT_PAID_BY_USER_ID = "SELECT * FROM cart_order WHERE user_id = ? AND paid_status = false ORDER BY order_date LIMIT 1";

        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_CART_ORDER_NOT_PAID_BY_USER_ID)) {
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                CartOrder cartOrder = new CartOrder(
                        resultSet.getInt("id"),
                        resultSet.getDate("order_date").toLocalDate(),
                        resultSet.getFloat("total_price"),
                        resultSet.getBoolean("paid_status"),
                        resultSet.getInt("user_id")
                );
                return cartOrder;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteCartOrder(int id) {
        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CART_ORDER)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
