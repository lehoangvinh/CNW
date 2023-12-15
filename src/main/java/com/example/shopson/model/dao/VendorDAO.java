package com.example.shopson.model.dao;

import com.example.shopson.model.bean.User;
import com.example.shopson.model.bean.Vendor;
import com.example.shopson.model.helper.ProductsVendor;
import com.example.shopson.utils.DButils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendorDAO {
    private String GET_ALL_VENDORS = "SELECT * FROM user where role_id = 2";
    private String GET_LIST_VENDORS = "SELECT * FROM vendor";
    private String GET_VENDOR_BY_ID = "SELECT * FROM vendor WHERE user_id = ?";
    private String ADD_VENDOR = "INSERT INTO vendor (vendor_name,user_id) VALUES (?, ?)";
    private String UPDATE_VENDOR = "UPDATE vendor SET vendor_name = ?, user_id = ? WHERE id = ?";
    private String DELETE_VENDOR = "DELETE FROM vendor WHERE id = ?";
    private String GET_VENDORS_BY_NAME = "SELECT * FROM vendor WHERE vendor_name LIKE ?";
    private String GET_VENDORS_BY_USER_ID = "SELECT * FROM vendors WHERE user_id = ?";
    private String GET_VENDORS_BY_PRODUCT_ID = "SELECT * FROM vendors WHERE product_id = ?";
    private String GET_VENDORS_BY_CATEGORY_ID = "SELECT * FROM vendors WHERE category_id = ?";
    private String DELETE_VENDOR_BY_USER_ID = "DELETE FROM vendor WHERE user_id = ?";
    private String UPDATE_VENDOR_BY_USER_ID = "UPDATE vendor SET vendor_name = ? WHERE user_id = ?";

    private String GET_PRODUCTS_CUSTOM_BY_VENDOR_ID = "SELECT p.id, p.product_name,p.price, p.description,p.vendor_id,v.user_id, v.vendor_name, p.image, c.category_name, P.category_id " +
            "FROM product p INNER JOIN vendor v ON p.vendor_id = v.id " +
            "INNER JOIN category c ON p.category_id = c.id "+
            "where p.vendor_id = ?";
    private String GET_PRODUCT_CUSTOM_BY_PRODUCT_ID = "SELECT * FROM product as p " +
            "inner join " +
            "vendor as v on p.vendor_id = v.id " +
            "inner join " +
            "category as c on c.id = p.category_id " +
            "where p.id = ?";

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
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_VENDOR_BY_USER_ID);) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
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

    public List<Vendor> getListVendors() {
        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_LIST_VENDORS);) {
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

    public void updateVendor(int id, String vendor_name) {
        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_VENDOR_BY_USER_ID);) {
            preparedStatement.setString(1, vendor_name);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteVendorByUserId(int id) {
        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_VENDOR_BY_USER_ID);) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ProductsVendor> getProductsCustomByVendorId(int vendorId)
    {
        List<ProductsVendor> productsVendors = new ArrayList<ProductsVendor>();
        try{
            Connection connection = DButils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCTS_CUSTOM_BY_VENDOR_ID);
            preparedStatement.setInt(1, vendorId);

            try{
                ResultSet rs = preparedStatement.executeQuery();
                while(rs.next())
                {
                    ProductsVendor productsVendor = new ProductsVendor();
                    productsVendor.setId(rs.getInt("id"));
                    productsVendor.setProductName(rs.getString("product_name"));
                    productsVendor.setPrice(rs.getFloat("price"));
                    productsVendor.setDescription(rs.getString("description"));
                    productsVendor.setImage(rs.getString("image"));
                    productsVendor.setCategoryId(rs.getInt("category_id"));
                    productsVendor.setVendorId(rs.getInt("vendor_id"));
                    productsVendor.setUserId(rs.getInt("user_id"));
                    productsVendor.setVendorName(rs.getString("vendor_name"));
                    productsVendor.setCategoryName(rs.getString("category_name"));

                    productsVendors.add(productsVendor);
                }
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return productsVendors;
    }

    public ProductsVendor getProductCustomById(int productId)
    {
        ProductsVendor productsVendor = new ProductsVendor();
        try{
            Connection connection = DButils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT_CUSTOM_BY_PRODUCT_ID);
            preparedStatement.setInt(1, productId);

            try{
                ResultSet rs = preparedStatement.executeQuery();
                while(rs.next())
                {
                    productsVendor.setId(rs.getInt("id"));
                    productsVendor.setProductName(rs.getString("product_name"));
                    productsVendor.setPrice(rs.getFloat("price"));
                    productsVendor.setDescription(rs.getString("description"));
                    productsVendor.setImage(rs.getString("image"));
                    productsVendor.setCategoryId(rs.getInt("category_id"));
                    productsVendor.setVendorId(rs.getInt("vendor_id"));
                    productsVendor.setUserId(rs.getInt("user_id"));
                    productsVendor.setVendorName(rs.getString("vendor_name"));
                    productsVendor.setCategoryName(rs.getString("category_name"));

                }
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return productsVendor;
    }
}
