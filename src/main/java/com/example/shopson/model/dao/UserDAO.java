package com.example.shopson.model.dao;

import com.example.shopson.model.bean.User;
import com.example.shopson.utils.DButils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private String GET_ALL_USERS = "SELECT * FROM user WHERE role_id = 3";
    private String ADD_USER = "INSERT INTO user (username, password, fullname, phone_number, role_id) VALUES (?, ?, ?, ?, ?)";
    private String ADD_USER_DETAIL = "INSERT INTO user(username, password, fullname, phone_number,address, role_id) VALUES (?, ?, ?, ?, ?, ?)";
    private String GET_USER_BY_USERNAME = "SELECT * FROM user WHERE username = ?";
    private String GET_USER_BY_ID = "SELECT * FROM user WHERE id = ?";
    private String UPDATE_USER = "UPDATE user SET username = ?, fullname = ?, phone_number = ? WHERE id = ?";
    private String UPDATE_USER_DETAIL = "UPDATE user SET username = ?, fullname = ?, phone_number = ?,address=? WHERE id = ?";
    private String DELETE_USER = "DELETE FROM user WHERE id = ?";
    private String UPDATE_ROLE = "UPDATE user SET role_id = ? WHERE id = ?";
    public UserDAO() {
    }
    public List<User> getAllUsers (){
        try(Connection connection = DButils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USERS);) {
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
            throw new RuntimeException(e);
        }
    }

    public void addUser(User user) {
        try(Connection connection = DButils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER);) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFullname());
            preparedStatement.setString(4, user.getPhone_number());
            preparedStatement.setInt(5, user.getRole_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void addUserDeTail(User user){
        try(Connection connection = DButils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER_DETAIL);) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFullname());
            preparedStatement.setString(4, user.getPhone_number());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setInt(6, user.getRole_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User getUserByUsername(String username) {
        try(Connection connection = DButils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_USERNAME);) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("fullname"),
                        resultSet.getString("phone_number"),
                        resultSet.getInt("role_id")
                );
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public User getUserById(int id) {
        try(Connection connection = DButils.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(GET_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("fullname"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("address"),
                        resultSet.getInt("role_id")
                );
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public void updateUser(int id, String username, String fullname,String phone_number){
        try(Connection connection = DButils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, fullname);
            preparedStatement.setString(3, phone_number);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateUser(int id, String username, String fullname,String phone_number,String address){
        try(Connection connection = DButils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_DETAIL);) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, fullname);
            preparedStatement.setString(3, phone_number);
            preparedStatement.setString(4, address);
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteUser(int id) {
        try(Connection connection = DButils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateRole(int id, int i) {
        try(Connection connection = DButils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ROLE);) {
            preparedStatement.setInt(1, i);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
