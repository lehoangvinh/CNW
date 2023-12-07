package com.example.shopson.model.bo;

import com.example.shopson.model.bean.Product;
import com.example.shopson.model.dao.ProductDAO;

import java.util.List;

public class ProductBO {
    ProductDAO productDAO = new ProductDAO();

    public boolean addProduct(String name, int price, String description, int vendor_id, String image, int  category_id) {
        return productDAO.addProduct(new Product(name, price, description, vendor_id, image, category_id));
    }

    public boolean updateProduct(int id, String name, int price, String description, int vendor_id, String image, int  category_id) {
        return productDAO.updateProduct(id, new Product( name, price, description, vendor_id, image, category_id));
    }
    public boolean deleteProduct(int id) {
        return productDAO.deleteProduct(id);
    }
    public List<Product> getAllProduct() {
        return productDAO.getAllProduct();
    }
    public Product getProductById(int id) {
        return productDAO.getProductById(id);
    }
    public List<Product> getProductsByVendorId(int vendor_id) {
        return productDAO.getProductsByVendorId(vendor_id);
    }
    public List<Product> getProductsByName(String name) {
        return productDAO.getProductsByName(name);
    }
    public List<Product> getProductsByPrice(double start, double end) {
        return productDAO.getProductsByPrice(start, end);
    }
    public List<Product> getProductsByCategory(int category_id) {
        return productDAO.getProductsByCategory(category_id);
    }
}
