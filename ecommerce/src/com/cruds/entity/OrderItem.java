package com.cruds.entity;

public class OrderItem {
    private int orderId;
    private String productName;
    private double price;
    private int quantity;
    private String orderDate;
    private double totalPrice;

    public OrderItem(int orderId, String productName, double price, int quantity, String orderDate, double totalPrice) {
        this.orderId = orderId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
    }

    // Getter methods
    public int getOrderId() {
        return orderId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}