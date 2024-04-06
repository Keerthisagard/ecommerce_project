package com.cruds.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cruds.entity.OrderItem;

public class OrderItemDAO {

	 public List<OrderItem> getOrderItemsByEmail(String email) {
	        List<OrderItem> orderItems = new ArrayList<>();
	        String query = "SELECT o.order_id, oi.product_name, oi.price, oi.quantity, o.order_date, o.total_amount " +
	                       "FROM orders o " +
	                       "INNER JOIN order_items oi ON o.order_id = oi.order_id " +
	                       "INNER JOIN users u ON o.user_id = u.user_id " +
	                       "WHERE u.email = ?";
	        try (
	            Connection connection = DBConnectionManager.getconnection();
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	        ) {
	            preparedStatement.setString(1, email);
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                while (resultSet.next()) {
	                    int orderId = resultSet.getInt("order_id");
	                    String productName = resultSet.getString("product_name");
	                    double price = resultSet.getDouble("price");
	                    int quantity = resultSet.getInt("quantity");
	                    String orderDate = resultSet.getString("order_date");
	                    double totalPrice = resultSet.getDouble("total_amount");
	                    OrderItem orderItem = new OrderItem(orderId, productName, price, quantity, orderDate, totalPrice);
	                    orderItems.add(orderItem);
	                    
	                   
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return orderItems;
	    }
	}
