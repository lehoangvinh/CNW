package com.example.shopson.model.dao;

import com.example.shopson.model.bean.CartOrderItems;
import com.example.shopson.utils.DButils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartOrderItemsDAO {
    private String ADD_CART_ORDER_ITEM = "INSERT INTO cart_order_items (quantity, sub_total_price, cart_order_id, product_id) VALUES (?, ?, ?, ?)";
    private String GET_ALL_CART_ORDER_ITEMS = "SELECT * FROM cart_order_items";
    private String GET_CART_ORDER_ITEM_BY_ID = "SELECT * FROM cart_order_items WHERE id = ?";
    private String UPDATE_CART_ORDER_ITEM = "UPDATE cart_order_items SET quantity = ?, sub_total_price = ?, cart_order_id = ?, product_id = ? WHERE id = ?";
    private String DELETE_CART_ORDER_ITEM = "DELETE FROM cart_order_items WHERE id = ?";
    String GET_ALL_CART_ORDER_ITEMS_BY_CART_ORDER_ID = "SELECT * FROM cart_order_items WHERE cart_order_id = ?";
    private String GET_CART_ORDER_ITEMS_BY_PRODUCT_AND_ORDER_ID = "SELECT * FROM cart_order_items WHERE product_id = ? AND cart_order_id = ?";

    private String UPDATE_CART_ORDER_ITEM_QUANTITY = "UPDATE cart_order_items SET quantity = ? WHERE id = ?";

    public List<CartOrderItems> getAllCartOrderItems() {
        try (Connection connection = DButils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CART_ORDER_ITEMS);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<CartOrderItems> cartOrderItemsList = new ArrayList<>();
            while (resultSet.next()) {
                CartOrderItems cartOrderItems = new CartOrderItems(
                        resultSet.getInt("id"),
                        resultSet.getInt("quantity"),
                        resultSet.getFloat("sub_total_price"),
                        resultSet.getInt("cart_order_id"),
                        resultSet.getInt("product_id")
                );
                cartOrderItemsList.add(cartOrderItems);
            }
            return cartOrderItemsList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public CartOrderItems getCartOrderItemById(int id) {
        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_CART_ORDER_ITEM_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                CartOrderItems cartOrderItems = new CartOrderItems(
                        resultSet.getInt("id"),
                        resultSet.getInt("quantity"),
                        resultSet.getFloat("sub_total_price"),
                        resultSet.getInt("cart_order_id"),
                        resultSet.getInt("product_id")
                );
                return cartOrderItems;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addCartOrderItems(CartOrderItems cartOrderItems) {
        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_CART_ORDER_ITEM)) {
            preparedStatement.setInt(1, cartOrderItems.getQuantity());
            preparedStatement.setFloat(2, cartOrderItems.getSub_total_price());
            preparedStatement.setInt(3, cartOrderItems.getCart_order_id());
            preparedStatement.setInt(4, cartOrderItems.getProduct_id());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateCartOrderItems(int id, CartOrderItems cartOrderItems) {
        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CART_ORDER_ITEM)) {
            preparedStatement.setInt(1, cartOrderItems.getQuantity());
            preparedStatement.setFloat(2, cartOrderItems.getSub_total_price());
            preparedStatement.setInt(3, cartOrderItems.getCart_order_id());
            preparedStatement.setInt(4, cartOrderItems.getProduct_id());
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public List<CartOrderItems> getAllCartOrderItemsByCartOrderId(int cartOrderId) {
        try (Connection connection = DButils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CART_ORDER_ITEMS_BY_CART_ORDER_ID);
            preparedStatement.setInt(1, cartOrderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<CartOrderItems> cartOrderItemsList = new ArrayList<>();
            while (resultSet.next()) {
                CartOrderItems cartOrderItems = new CartOrderItems(
                        resultSet.getInt("id"),
                        resultSet.getInt("quantity"),
                        resultSet.getFloat("sub_total_price"),
                        resultSet.getInt("cart_order_id"),
                        resultSet.getInt("product_id")
                );
                cartOrderItemsList.add(cartOrderItems);
            }
            return cartOrderItemsList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public CartOrderItems getCartOrderItemsByProductIdAndCartOrderId(int productId, int cartOrderId) {
        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_CART_ORDER_ITEMS_BY_PRODUCT_AND_ORDER_ID)) {
            preparedStatement.setInt(1, productId);
            preparedStatement.setInt(2, cartOrderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                CartOrderItems cartOrderItems = new CartOrderItems(
                        resultSet.getInt("id"),
                        resultSet.getInt("quantity"),
                        resultSet.getFloat("sub_total_price"),
                        resultSet.getInt("cart_order_id"),
                        resultSet.getInt("product_id")
                );
                return cartOrderItems;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateCartOrderItemQuantity(int id, int newQuantity) {
        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CART_ORDER_ITEM_QUANTITY)) {
            preparedStatement.setInt(1, newQuantity);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteCartOrderItem(int id) {
        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CART_ORDER_ITEM)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
