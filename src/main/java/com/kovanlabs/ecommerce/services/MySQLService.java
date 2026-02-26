package com.kovanlabs.ecommerce.services;

import com.kovanlabs.ecommerce.model.ProductModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MySQLService {

    private final JdbcTemplate jdbcTemplate;

    public MySQLService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean testConnection() {
        try {
            jdbcTemplate.execute("SELECT 1");
            System.out.println("Database connected successfully!");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String insertProduct(ProductModel product) {

        String sql = "INSERT INTO product (id, name, category, amount) VALUES (?, ?, ?, ?)";

        int rows = jdbcTemplate.update(
                sql,
                product.getId(),
                product.getName(),
                product.getCategory(),
                product.getAmount()
        );

        return rows > 0 ? "Product Inserted Successfully" : "Insertion Failed";
    }

    public List<ProductModel> getAllProducts() {

        String sql = "SELECT * FROM product";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new ProductModel(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getDouble("amount")
                )
        );
    }
}