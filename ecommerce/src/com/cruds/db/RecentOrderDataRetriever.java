package com.cruds.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecentOrderDataRetriever {
    private static final String SQL_QUERY = "SELECT o.order_id, o.order_date, o.total_amount, oi.product_name, oi.price, oi.quantity " +
            "FROM orders o " +
            "INNER JOIN order_items oi ON o.order_id = oi.order_id " +
            "ORDER BY o.order_date DESC " +
            "LIMIT 10";

    public static void main(String[] args) {
        try (
            // Get a database connection from the DBConnectionManager
            Connection connection = DBConnectionManager.getconnection();
            // Create PreparedStatement object
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY);
            // Execute query and get ResultSet
            ResultSet resultSet = preparedStatement.executeQuery()
        ) {
            while (resultSet.next()) {
                // Retrieve data from ResultSet
                int orderId = resultSet.getInt("order_id");
                String orderDate = resultSet.getString("order_date");
                double totalAmount = resultSet.getDouble("total_amount");
                String productName = resultSet.getString("product_name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");

                // Process retrieved data (print it in this example)
                System.out.println("Order ID: " + orderId);
                System.out.println("Order Date: " + orderDate);
                System.out.println("Total Amount: " + totalAmount);
                System.out.println("Product Name: " + productName);
                System.out.println("Price: " + price);
                System.out.println("Quantity: " + quantity);
                System.out.println(); // Add a blank line for readability
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}