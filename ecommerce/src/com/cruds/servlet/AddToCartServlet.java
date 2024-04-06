package com.cruds.servlet;

import com.cruds.entity.Product;
import com.cruds.entity.CartItem;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve product details from request parameters
        String productId = request.getParameter("productId");
        String productName = request.getParameter("productName");
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));
        String productImageUrl = request.getParameter("productImageUrl");
        String productDescription = request.getParameter("productDescription");

        // Create a new Product object
        Product product = new Product(productName, productPrice, productImageUrl, productDescription);

        // Retrieve or create the user's cart
        HttpSession session = request.getSession();
        List<CartItem> cart = (List<CartItem>) session.getAttribute("CART");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("CART", cart);
        }

        // Add the product to the cart
        CartItem cartItem = new CartItem(product);
        cart.add(cartItem);

        // Set success message
        session.setAttribute("SUCCESS_MESSAGE", "Product \"" + productName + "\" added to cart.");

        // Redirect the user to the view cart page
        response.sendRedirect("mainPage.jsp");
    }
}
