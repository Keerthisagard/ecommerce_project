package com.cruds.service;

import com.cruds.db.CartDAO;

public class CartService {
    private CartDAO cartDAO = new CartDAO();
    
    public void addToCart(int userId, int productId) {
        cartDAO.addProductToCart(userId, productId);
    }
}
