package com.example.shopson.model.dao;

import com.example.shopson.model.bean.AuthHelper;
import com.example.shopson.utils.DButils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthDAO {
    private String LOGIN_QUERY = "SELECT * FROM users WHERE username = ? AND password = ?";
    private String REGISTER_QUERY = "INSERT INTO users (username, password, fullname, phone_number, role_id) VALUES (?, ?, ?, ?, ?)";

    private String GET_ROLE_BY_USERNAME = "SELECT role_id FROM user WHERE username = ?";
    public AuthHelper login(String username, String password) {
        try(Connection connection = DButils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_QUERY);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return new AuthHelper( resultSet.getString("username"),resultSet.getInt("role_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public int getRoleByUsername(String name) {
        try(Connection connection = DButils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ROLE_BY_USERNAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
