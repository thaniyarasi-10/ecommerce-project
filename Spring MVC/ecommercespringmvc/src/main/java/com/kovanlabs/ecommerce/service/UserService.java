package com.kovanlabs.ecommerce.service;

import com.kovanlabs.ecommerce.config.JDBCConfig;
import com.kovanlabs.ecommerce.dao.UserDAO;
import com.kovanlabs.ecommerce.model.UserModel;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.List;

@Service
public class UserService {


    public String user(){
        return "User login";
    }

    private final UserDAO userDAO;
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    public void saveUser(UserModel user) throws SQLException {
        userDAO.saveUser(user);
    }

    public List<UserModel> getAllUsers() throws SQLException {
        return userDAO.getAllUsers();
    }

    public void updateUser(UserModel user) throws SQLException {
        userDAO.updateUser(user);
    }

    public void deleteUser(int id) throws SQLException {
        userDAO.deleteUser(id);
    }

}
