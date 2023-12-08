package com.example.shopson.model.dao;

import com.example.shopson.model.bean.Product;
import com.example.shopson.model.helper.ProductHelper;
import com.example.shopson.utils.DButils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private String ADD_PRODUCT = "INSERT INTO product (product_name, price, description, vendor_id, image, category_id) VALUES (?, ?, ?, ?, ?, ?)";
    private String GET_ALL_PRODUCTS = "SELECT p.product_name,p.price, p.description, p.vendor_name, p.image, c.category_name" +
            "FROM product p INNER JOIN vendor v ON p.vendor_id = v.id " +
            "INNER JOIN category c ON p.category_id = c.id";
    private String GET_PRODUCT_BY_ID = "SELECT * FROM product WHERE id = ?";
    private String UPDATE_PRODUCT = "UPDATE product SET name = ?, price = ?, description = ?, vendor_id = ?, image = ?, category_id = ? WHERE id = ?";
    private String DELETE_PRODUCT = "DELETE FROM product WHERE id = ?";
    private String GET_PRODUCTS_BY_VENDOR_ID = "SELECT * FROM product WHERE vendor_id = ?";
    private String GET_PRODUCTS_BY_NAME = "SELECT * FROM product WHERE name LIKE ?";
    private String GET_PRODUCTS_BETWEEN_PRICE = "SELECT * FROM product WHERE price BETWEEN ? AND ?";
    private String GET_PRODUCTS_BY_CATEGORY = "SELECT * FROM product WHERE category_id = ?";

    public List<ProductHelper> getAllProduct() {
        try (Connection connection = DButils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PRODUCTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<ProductHelper> products = new ArrayList<>();
            while (resultSet.next()) {
                ProductHelper product = new ProductHelper(
                        resultSet.getString("product_name"),
                        resultSet.getFloat("price"),
                        resultSet.getString("description"),
                        resultSet.getInt("vendor_id"),
                        resultSet.getString("vendor_name"),
                        resultSet.getString("category_name"),
                        resultSet.getInt("category_id"),
                        resultSet.getString("image")
                );
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Product getProductById(int id) {
        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Product product = new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("price"),
                        resultSet.getString("description"),
                        resultSet.getInt("vendor_id"),
                        resultSet.getString("image"),
                        resultSet.getInt("category_id")
                );
                return product;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Product> getProductsByVendorId(int vendor_id) {
        try (Connection connection = DButils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCTS_BY_VENDOR_ID);
            preparedStatement.setInt(1, vendor_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                Product product = new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("price"),
                        resultSet.getString("description"),
                        resultSet.getInt("vendor_id"),
                        resultSet.getString("image"),
                        resultSet.getInt("category_id")
                );
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getProductsByName(String name) {
        try (Connection connection = DButils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCTS_BY_NAME);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                Product product = new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("price"),
                        resultSet.getString("description"),
                        resultSet.getInt("vendor_id"),
                        resultSet.getString("image"),
                        resultSet.getInt("category_id")
                );
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getProductsByCategory(int category_id) {
        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCTS_BY_CATEGORY)) {
            preparedStatement.setInt(1, category_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                Product product = new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("price"),
                        resultSet.getString("description"),
                        resultSet.getInt("vendor_id"),
                        resultSet.getString("image"),
                        resultSet.getInt("category_id")
                );
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Product> getProductsByPrice(double start, double end){
        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCTS_BETWEEN_PRICE)) {
            preparedStatement.setDouble(1, start);
            preparedStatement.setDouble(2, end);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                Product product = new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("price"),
                        resultSet.getString("description"),
                        resultSet.getInt("vendor_id"),
                        resultSet.getString("image"),
                        resultSet.getInt("category_id")
                );
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean addProduct(Product product){
try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_PRODUCT)) {
            preparedStatement.setString(1, product.getProduct_name());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setInt(4, product.getVendor_id());
            preparedStatement.setString(5, product.getImage());
            preparedStatement.setInt(6, product.getCategory_id());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateProduct(int id, Product product) {
        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT)) {
            preparedStatement.setString(1, product.getProduct_name());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setInt(4, product.getVendor_id());
            preparedStatement.setString(5, product.getImage());
            preparedStatement.setInt(6, product.getCategory_id());
            preparedStatement.setInt(7, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteProduct(int id) {
        try (Connection connection = DButils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
