package com.cruds.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cruds.entity.User;
import com.cruds.service.UserService;


@WebServlet("/register")
public class UserRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserService userService;

    public void init() {
        userService = new UserService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("phoneNumber");

        // Create a User object
        User user = new User(username, email, password, phoneNumber);

        // Register the user
        boolean registered = userService.registerUser(user);

        if (registered) {
            // Registration successful, redirect to a success page
            response.sendRedirect("registrationSuccess.jsp");
        } else {
            // Registration failed, redirect to an error page
            response.sendRedirect("registrationError.jsp");
        }
    }
}