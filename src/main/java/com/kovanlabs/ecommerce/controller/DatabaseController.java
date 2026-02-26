package com.kovanlabs.ecommerce.controller;
import com.kovanlabs.ecommerce.model.ProductModel;
import com.kovanlabs.ecommerce.services.MySQLService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class DatabaseController {
    private final MySQLService mysqlService;

    public DatabaseController(MySQLService mysqlService) {
        this.mysqlService = mysqlService;
    }
    @GetMapping("/testdb")
    public String testDatabase() {
        boolean status = mysqlService.testConnection();
        return status ? "Database Connected!" : "Database Connection Failed!";
    }
}