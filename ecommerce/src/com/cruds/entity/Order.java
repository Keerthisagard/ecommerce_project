package com.cruds.entity;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private String userId;
    private String orderDate;
    private double totalAmount;
    private List<OrderItem> orderItems;

    public Order(int orderId, String username, String orderDate, double totalAmount) {
        this.orderId = orderId;
        this.userId = username;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.orderItems = new ArrayList<>();
    }
    
    

    public Order(String product, double price, int quantity) {
		super();
		this.product = product;
		this.price = price;
		this.quantity = quantity;
	}



	public int getOrderId() {
        return orderId;
    }

    public String getUserId() {
        return userId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }
    
    // New attributes
    private String product;
    private double price;
    private int quantity;

    // Getters and setters for new attributes
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
