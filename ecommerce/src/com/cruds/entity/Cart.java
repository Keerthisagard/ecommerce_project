package com.cruds.entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartItems;

    public Cart() {
        cartItems = new ArrayList<>();
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void addCartItem(CartItem cartItem) {
        cartItems.add(cartItem);
    }

    public void removeCartItem(int cartItemId) {
        cartItems.removeIf(item -> item.getCartItemId() == cartItemId);
    }

    public void updateCartItemQuantity(int cartItemId, int newQuantity) {
        for (CartItem item : cartItems) {
            if (item.getCartItemId() == cartItemId) {
                item.setQuantity(newQuantity);
                break;
            }
        }
    }

    public double getTotalAmount() {
        double total = 0.0;
        for (CartItem item : cartItems) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        return total;
    }
}
