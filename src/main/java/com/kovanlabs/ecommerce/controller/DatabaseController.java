package com.kovanlabs.ecommerce.controller;
import com.kovanlabs.ecommerce.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class DatabaseController {
    private final ProductService mysqlService;

    public DatabaseController(ProductService mysqlService) {
        this.mysqlService = mysqlService;
    }
    @GetMapping("/testdb")
    public String testDatabase() {
        boolean status = mysqlService.testConnection();
        return status ? "Database Connected!" : "Database Connection Failed!";
    }
}