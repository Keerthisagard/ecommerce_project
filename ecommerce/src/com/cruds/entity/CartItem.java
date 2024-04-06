package com.cruds.entity;

public class CartItem {
    private int cartItemId;
    private Product product;
    private int quantity;

    // Updated constructor to accept Product object
    public CartItem(Product product) {
        this.product = product;
        this.quantity = 1; // Assuming default quantity is 1
    }

    // Getters and setters
    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem [cartItemId=" + cartItemId + ", product=" + product + ", quantity=" + quantity + "]";
    }
}
