package com.cruds.service;

import java.util.List;

import com.cruds.db.OrderItemDAO;
import com.cruds.entity.OrderItem;

public class OrderItemService {

    private final OrderItemDAO orderItemDAO;

    public OrderItemService() {
        this.orderItemDAO = new OrderItemDAO();
    }

    public List<OrderItem> getOrderItemsByEmail(String email) {
        return orderItemDAO.getOrderItemsByEmail(email);
    }
}
