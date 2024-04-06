package com.cruds.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cruds.entity.CartItem;

public class RemoveFromCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RemoveFromCartServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve productId parameter from the request
        int productId = Integer.parseInt(request.getParameter("productId"));

        // Get the current session
        HttpSession session = request.getSession();

        // Retrieve cart items from session
        List<CartItem> cart = (List<CartItem>) session.getAttribute("CART");

        // If cart exists and is not empty
        if (cart != null && !cart.isEmpty()) {
            // Use iterator to safely remove items while iterating over the list
            Iterator<CartItem> iterator = cart.iterator();
            while (iterator.hasNext()) {
                CartItem item = iterator.next();
                if (item.getProduct().getProductId() == productId) {
                    iterator.remove();
                    break; // Stop iterating once the item is removed
                }
            }

            // Update the session attribute with the modified cart
            session.setAttribute("CART", cart);
        }

        // Redirect back to the cart page
        response.sendRedirect("viewCart.jsp");
    }
}
