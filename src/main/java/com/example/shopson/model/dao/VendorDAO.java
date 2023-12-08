package com.example.shopson.model.dao;

import com.example.shopson.model.bean.User;
import com.example.shopson.model.bean.Vendor;
import com.example.shopson.utils.DButils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendorDAO {
    private String GET_ALL_VENDORS = "SELECT * FROM user where role_id = 2";
    private String GET_VENDOR_BY_ID = "SELECT * FROM vendor WHERE user_id = ?";
    private String ADD_VENDOR = "INSERT INTO vendor (vendor_name,user_id VALUES (?, ?)";
    private String UPDATE_VENDOR = "UPDATE vendor SET vendor_name = ?, user_id = ? WHERE id = ?";
    private String DELETE_VENDOR = "DELETE FROM vendor WHERE id = ?";
    private String GET_VENDORS_BY_NAME = "SELECT * FROM vendor WHERE vendor_name LIKE ?";
    private String GET_VENDORS_BY_USER_ID = "SELECT * FROM vendors WHERE user_id = ?";
    private String GET_VENDORS_BY_PRODUCT_ID = "SELECT * FROM vendors WHERE product_id = ?";
    private String GET_VENDORS_BY_CATEGORY_ID = "SELECT * FROM vendors WHERE category_id = ?";

    public List<User> getAllVendors() {
        try (Connection connection = DButils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_VENDORS);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("fullname"),
                        resultSet.getString("phone_number"),
                        resultSet.getInt("role_id")
                );
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Vendor getVendorById(int id) {
        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_VENDOR_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Vendor vendor = new Vendor(
                        resultSet.getInt("id"),
                        resultSet.getString("vendor_name"),
                        resultSet.getInt("user_id")
                );
                return vendor;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addVendor(Vendor vendor) {
        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_VENDOR);) {
            preparedStatement.setString(1, vendor.getVendor_name());
            preparedStatement.setInt(2, vendor.getUser_id());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateVendor(int id, Vendor vendor) {
        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_VENDOR);) {
            preparedStatement.setString(1, vendor.getVendor_name());
            preparedStatement.setInt(2, vendor.getUser_id());
            preparedStatement.setInt(3, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteVendor(int id) {
        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_VENDOR);) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Vendor> getVendorsByName(String name) {
        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_VENDORS_BY_NAME);) {
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Vendor> vendors = new ArrayList<>();
            while (resultSet.next()) {
                Vendor vendor = new Vendor(
                        resultSet.getInt("id"),
                        resultSet.getString("vendor_name"),
                        resultSet.getInt("user_id")
                );
                vendors.add(vendor);
            }
            return vendors;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
