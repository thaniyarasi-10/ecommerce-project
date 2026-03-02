package com.kovanlabs.ecommerce.controller;

import com.kovanlabs.ecommerce.model.ProductModel;
import com.kovanlabs.ecommerce.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService mysqlService;

    public ProductController(ProductService mysqlService) {
        this.mysqlService = mysqlService;
    }

    @PostMapping("/add")
    public String addProduct(@RequestBody ProductModel productModel) throws SQLException {
        return mysqlService.insertProduct(productModel);
    }

    @GetMapping("/all")
    public List<ProductModel> getAllProducts() throws SQLException {
        return mysqlService.getAllProducts();
    }
}
