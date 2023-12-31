package com.example.shopson.model.bo;

import com.example.shopson.model.bean.Vendor;
import com.example.shopson.model.dao.VendorDAO;

import java.util.List;

public class VendorBO {
    private VendorDAO vendorDAO = new VendorDAO();

    public VendorBO() {
    }
    public List<Vendor> getAllVendors() {
        return vendorDAO.getAllVendors();
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
}
