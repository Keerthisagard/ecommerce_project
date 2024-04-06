package com.cruds.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import com.cruds.db.GetUserDAO;
import com.cruds.entity.User;
import com.cruds.service.AuthenticationService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private AuthenticationService authenticationService;
    private GetUserDAO getUserDAO;

    public void init() {
        authenticationService = new AuthenticationService();
        getUserDAO = new GetUserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (authenticationService.authenticateUser(email, password)) {
            // Successful login
            User user = getUserDAO.getUserByEmail(email); // Retrieve user information from the database
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user); // Store the user object in the session

                // Forward the request to userProfile.jsp
                request.getRequestDispatcher("userProfile.jsp").forward(request, response);
            } else {
                // Error retrieving user information
                response.sendRedirect("login.jsp?error=2"); // Redirect back to login page with error parameter
            }
        } else {
            // Invalid login
            response.sendRedirect("login.jsp?error=1"); // Redirect back to login page with error parameter
        }
    }
}
