package com.cruds.servlet;

import com.cruds.db.OrderItemDAO;
import com.cruds.entity.OrderItem;
import com.cruds.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class OrderItemServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the user's email from the session
        HttpSession session = request.getSession();
        Object userObject = session.getAttribute("user");
        String email = null;
        if (userObject != null) {
            email = ((User) userObject).getEmail();
        }

        // If email is not null, proceed to fetch order items
        if (email != null) {
            // Instantiate OrderItemDAO
            OrderItemDAO orderItemDAO = new OrderItemDAO();

            // Retrieve order items for the user's email
            List<OrderItem> orderItems = orderItemDAO.getOrderItemsByEmail(email);

            // Set the order items as an attribute in the request
            request.setAttribute("orderItems", orderItems);

            // Forward the request to the JSP to display the order items
            request.getRequestDispatcher("orderItems.jsp").forward(request, response);
        } else {
            // If email is null, redirect to login page or handle the case accordingly
            response.sendRedirect("login.jsp");
        }
    }
}
