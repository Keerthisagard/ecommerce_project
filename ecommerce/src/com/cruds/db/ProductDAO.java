package com.cruds.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cruds.entity.Product;

public class ProductDAO {
    
    public void addProduct(Product product) {
        String query = "INSERT INTO products (product_name, price, description, image_url) VALUES (?, ?, ?, ?)";
        try (
            Connection conn = DBConnectionManager.getconnection();
            PreparedStatement pstmt = conn.prepareStatement(query)
        ) {
            pstmt.setString(1, product.getName());
            pstmt.setDouble(2, product.getPrice());
            pstmt.setString(3, product.getDescription());
            pstmt.setString(4, product.getImageUrl());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
