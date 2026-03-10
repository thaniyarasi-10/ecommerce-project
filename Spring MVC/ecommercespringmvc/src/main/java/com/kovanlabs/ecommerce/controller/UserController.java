package com.kovanlabs.ecommerce.controller;

import com.kovanlabs.ecommerce.config.JDBCConfig;
import com.kovanlabs.ecommerce.model.UserModel;
import com.kovanlabs.ecommerce.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;
    JDBCConfig jdbcConfig;

    public UserController(UserService userService, JDBCConfig jdbcConfig) {
        this.userService = userService;
        this.jdbcConfig = jdbcConfig;
    }

    @PostMapping("/addUser")
    public String saveUser(@RequestBody UserModel user) throws SQLException {
        userService.saveUser(user);
        return "User saved";
    }

    @GetMapping("/allUser")
    public List<UserModel> getAllUsers() throws SQLException {
        return userService.getAllUsers();
    }

    @PutMapping("/updateUser")
    public String updateUser(@RequestBody UserModel user) throws SQLException {
        userService.updateUser(user);
        return "User updated";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) throws SQLException {
        userService.deleteUser(id);
        return "User deleted";
    }
}
