package com.example.shopson.model.bo;

import com.example.shopson.model.bean.User;
import com.example.shopson.model.bean.Vendor;
import com.example.shopson.model.dao.VendorDAO;
import com.example.shopson.model.helper.ProductsVendor;

import java.util.List;

public class VendorBO {
    private VendorDAO vendorDAO = new VendorDAO();

    public VendorBO() {
    }
    public List<User> getAllVendors() {
        return vendorDAO.getAllVendors();
    }
    public List<Vendor> getListVendors() {
        return vendorDAO.getListVendors();
    }
    public Vendor getVendorById(int id) {
        return vendorDAO.getVendorById(id);
    }
    public boolean addVendor(String vendor_name, int user_id) {
        return vendorDAO.addVendor(new Vendor(vendor_name, user_id));
    }
    public boolean updateVendor(int id, String vendor_name, int user_id) {
        return vendorDAO.updateVendor(id,new Vendor(vendor_name, user_id));
    }
    public boolean deleteVendor(int id) {
        return vendorDAO.deleteVendor(id);
    }
    public List<Vendor> getVendorsByName(String name) {
        return vendorDAO.getVendorsByName(name);
    }
    public void updateVendor(int user_id, String vendor_name) {
        vendorDAO.updateVendor(user_id, vendor_name);
    }
    public List<ProductsVendor> getProductsCustomByVendorId(int vendorId)
    {
        return vendorDAO.getProductsCustomByVendorId(vendorId);
    }
    public  ProductsVendor getProductVendorById(int productId)
    {
        return vendorDAO.getProductCustomById(productId);
    }
}
