package com.example.shopson.model.bo;

import com.example.shopson.model.helper.AuthHelper;
import com.example.shopson.model.dao.AuthDAO;

public class AuthBO {
    private AuthDAO authDAO = new AuthDAO();
    public AuthHelper checkLogin(String username, String password) {
        return authDAO.login(username, password);
    }
    public int getRole(String username) {
        return authDAO.getRoleByUsername(username);
    }
}
