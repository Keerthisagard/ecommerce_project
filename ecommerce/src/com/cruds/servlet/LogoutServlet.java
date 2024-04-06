package com.cruds.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            // Set a session attribute to indicate that the user has just logged out
            session.setAttribute("justLoggedOut", true);
            session.invalidate(); // Invalidate the session after setting the attribute
        }
        // Redirect to the index.html page after logout
        response.sendRedirect("index.html");
    }
}
