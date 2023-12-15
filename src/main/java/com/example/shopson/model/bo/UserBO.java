package com.example.shopson.model.bo;

import com.example.shopson.model.bean.User;
import com.example.shopson.model.bean.Vendor;
import com.example.shopson.model.dao.UserDAO;
import com.example.shopson.model.dao.VendorDAO;

import java.util.List;

public class UserBO {
    private UserDAO userDAO = new UserDAO();
    private VendorDAO vendorDAO = new VendorDAO();
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
    public void addVendor(String username,String fullname, String phone_number) {
        userDAO.addUser(new User(username, "1234",fullname, phone_number, 2));
        vendorDAO.addVendor(new Vendor(username, userDAO.getUserByUsername(username).getId()));
    }
    public void addUser(String username,String fullname, String phone_number,String address) {
        userDAO.addUserDeTail(new User(username, "1234",fullname, phone_number,address, 3));
    }
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }
    public void updateUser(int id, String username, String fullname, String phone_number) {
        userDAO.updateUser(id,username, fullname, phone_number);
    }
    public void updateUser(int id, String username, String fullname, String phone_number,String address) {
        userDAO.updateUser(id,username, fullname, phone_number,address);
    }
    public boolean deleteUser(int id) {
       return  userDAO.deleteUser(id);
    }

    public void updateRole(int id, int i) {
        userDAO.updateRole(id, i);
    }
}
