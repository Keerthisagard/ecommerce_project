package com.cruds.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cruds.entity.CartItem;
import com.cruds.entity.Product;

public class CartDAO {
    
    // Add product to cart
    public void addProductToCart(int userId, int productId) {
        String query = "INSERT INTO cart (user_id, product_id, quantity) VALUES (?, ?, 1)"; // Default quantity is 1
        try (
            Connection conn = DBConnectionManager.getconnection();
            PreparedStatement pstmt = conn.prepareStatement(query)
        ) {
            pstmt.setInt(1, userId);
            pstmt.setInt(2, productId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Retrieve cart items for a user
    public List<CartItem> getCartItems(int userId) {
        List<CartItem> cartItems = new ArrayList<>();
        String query = "SELECT cart.cart_id, products.product_id, products.product_name, products.price, cart.quantity FROM cart "
                + "JOIN products ON cart.product_id = products.product_id WHERE cart.user_id = ?";
        try (
            Connection conn = DBConnectionManager.getconnection();
            PreparedStatement pstmt = conn.prepareStatement(query)
        ) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
              //  int cartItemId = rs.getInt("cart_id");
              //  int productId = rs.getInt("product_id");
                String productName = rs.getString("product_name");
                double price = rs.getDouble("price");
             //   int quantity = rs.getInt("quantity");
                
                // Create a Product object and add it to the list
                Product product = new Product(productName, price, null, null); // null for imageUrl and description as they are not retrieved
                CartItem cartItem = new CartItem(product);
                cartItems.add(cartItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartItems;
    }
    
    // Remove product from cart
    public void removeProductFromCart(int cartItemId) {
        String query = "DELETE FROM cart WHERE cart_id = ?";
        try (
            Connection conn = DBConnectionManager.getconnection();
            PreparedStatement pstmt = conn.prepareStatement(query)
        ) {
            pstmt.setInt(1, cartItemId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Update quantity of a product in the cart
    public void updateCartItemQuantity(int cartItemId, int quantity) {
        String query = "UPDATE cart SET quantity = ? WHERE cart_id = ?";
        try (
            Connection conn = DBConnectionManager.getconnection();
            PreparedStatement pstmt = conn.prepareStatement(query)
        ) {
            pstmt.setInt(1, quantity);
            pstmt.setInt(2, cartItemId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
