package com.cruds.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cruds.entity.Cart;
import com.cruds.entity.CartItem;
import com.cruds.entity.User;

public class ViewCartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the cart items from the session
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("CART");

        // Check if the user is logged in
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // If user is not logged in, redirect to login page
            response.sendRedirect("login.jsp");
            return;
        }

        // Check if the cart is not null
        if (cart != null) {
            // Retrieve the list of cart items from the cart
            List<CartItem> cartItems = cart.getCartItems();
            
            // Set the cart items as an attribute in the request
            request.setAttribute("cartItems", cartItems);
        }
        
        // Forward the request to the view cart JSP
        request.getRequestDispatcher("/WEB-INF/viewCart.jsp").forward(request, response);
    }
}
