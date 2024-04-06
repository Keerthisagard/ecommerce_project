package com.cruds.service;

import com.cruds.db.OrderDAO;
import com.cruds.entity.CartItem;

import java.util.List;

public class OrderService {
    private OrderDAO orderDAO;

    public OrderService() {
        orderDAO = new OrderDAO();
    }

    public boolean placeOrder(String email, double totalAmount, List<CartItem> cartItems) {
        // Check if username and cartItems are valid
        if (email == null || email.isEmpty() || totalAmount <= 0 || cartItems == null || cartItems.isEmpty()) {
            return false; // Invalid parameters
        }

        // Insert order into database using the OrderDAO
        return orderDAO.insertOrder(email, totalAmount, cartItems);
    }
}
