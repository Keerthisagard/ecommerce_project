package com.cruds.servlet;

import com.cruds.entity.CartItem;
import com.cruds.entity.User;
import com.cruds.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ProcessOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 // Retrieve the username from the session
        HttpSession session = request.getSession();
        Object userObject = session.getAttribute("user");
        String email = null;
        if (userObject != null) {
            // Assuming there's a getUsername() method in the User class
            email = ((User) userObject).getEmail();
        }

        // Retrieve the cart items from the session
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("CART");

        // Calculate total price
        double totalAmount = calculateTotalPrice(cartItems);
 
		if (email != null && cartItems != null && !cartItems.isEmpty()) {
           
            OrderService orderService = new OrderService();
            boolean orderPlaced = orderService.placeOrder(email, totalAmount, cartItems);

            if (orderPlaced) {
                // If the order is successfully placed, remove the cart from the session
                session.removeAttribute("CART");

                // Redirect the user to a success page
                response.sendRedirect("placeOrder.jsp");
            } else {
                // If there's an error placing the order, redirect the user to an error page
                response.sendRedirect("orderError.jsp");
            }
        } else {
            // If the username or cart items are invalid, redirect the user to an error page
            response.sendRedirect("orderError.jsp");
        }
    }

    private double calculateTotalPrice(List<CartItem> cartItems) {
        double totalAmount = 0.0;
        if (cartItems != null && !cartItems.isEmpty()) {
            for (CartItem item : cartItems) {
                totalAmount += item.getProduct().getPrice() * item.getQuantity();
            }
        }
        return totalAmount;
    }
}
