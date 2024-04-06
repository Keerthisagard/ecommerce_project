package com.cruds.db;

import com.cruds.entity.CartItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderDAO {
    public boolean insertOrder(String email, double totalAmount, List<CartItem> cartItems) {
        String sqlOrder = "INSERT INTO orders (user_id, total_amount) VALUES ((SELECT user_id FROM users WHERE email = ?), ?)";
        String sqlOrderItem = "INSERT INTO order_items (order_id, product_name, price, quantity) VALUES (?, ?, ?, ?)";

        try (
            Connection conn = DBConnectionManager.getconnection();
            PreparedStatement pstmtOrder = conn.prepareStatement(sqlOrder, PreparedStatement.RETURN_GENERATED_KEYS);
            PreparedStatement pstmtOrderItem = conn.prepareStatement(sqlOrderItem)
        ) {
            // Insert order
            pstmtOrder.setString(1, email);
            pstmtOrder.setDouble(2, totalAmount);
            pstmtOrder.executeUpdate();

            // Get auto-generated order ID
            int orderId;
            try (ResultSet rs = pstmtOrder.getGeneratedKeys()) {
                if (rs.next()) {
                    orderId = rs.getInt(1);
                } else {
                    return false; // Failed to get order ID
                }
            }

            // Insert order items
            for (CartItem cartItem : cartItems) {
                pstmtOrderItem.setInt(1, orderId);
                pstmtOrderItem.setString(2, cartItem.getProduct().getName());
                pstmtOrderItem.setDouble(3, cartItem.getProduct().getPrice());
                pstmtOrderItem.setInt(4, cartItem.getQuantity());
                pstmtOrderItem.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
