package com.example.shopson.model.dao;

import com.example.shopson.model.helper.ProductHelper;
import com.example.shopson.utils.DButils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartOrderItemDAO {
    private String GET_ALL_CART_BY_ID_USER = "SELECT p.id, p.product_name,p.price, p.description,p.vendor_id, v.vendor_name, p.image, c.category_name, p.category_id " +
            " FROM cart_order_items as coi " +
            "JOIN cart_order as co ON coi.cart_order_id = co.id " +
            "JOIN product as p ON coi.product_id = p.id " +
            "JOIN category as c on c.id = p.category_id "+
            "JOIN user as u ON co.user_id = u.id " +
            "JOIN vendor as v ON p.vendor_id = v.id " +
            "WHERE co.id = ?";

    private String addCartOrderItem = "INSERT INTO cart_order_items (cart_order_id,sub_total_price, product_id,quantity) VALUES (?, ?, ?,?)";
    private String deleteCartOrderItem = "DELETE FROM cart_order_item WHERE id = ?";

    public CartOrderItemDAO() {
    }
    public void addCartOrderItem(int cart_order_id,Float sub_total_price, int product_id) {
        try(Connection connection = DButils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(addCartOrderItem);) {
            preparedStatement.setInt(1, cart_order_id);
            preparedStatement.setInt(3, product_id);
            preparedStatement.setFloat(2,sub_total_price);
            preparedStatement.setInt(4,1);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ProductHelper> getAllCarOrderItemByIdUser(int cart_order_id){
        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CART_BY_ID_USER);) {
            preparedStatement.setInt(1, cart_order_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<ProductHelper> productHelpers = new ArrayList<>();
            while (resultSet.next()) {
                ProductHelper product = new ProductHelper(
                        resultSet.getInt("id"),
                        resultSet.getString("product_name"),
                        resultSet.getFloat("price"),
                        resultSet.getString("description"),
                        resultSet.getInt("vendor_id"),
                        resultSet.getString("vendor_name"),
                        resultSet.getString("category_name"),
                        resultSet.getInt("category_id"),
                        resultSet.getString("image")
                );
                productHelpers.add(product);
            }
            return productHelpers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
