<%@page import="com.cruds.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Required</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f3f3f3;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 500px;
            margin: 100px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h1 {
            font-size: 24px;
            margin-bottom: 20px;
        }
        p {
            font-size: 16px;
            margin-bottom: 20px;
        }
        a {
            color: #0066c0;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Login Required</h1>
        <% 
            // Check if user is logged in
            User user = (User) session.getAttribute("user");
            if (user == null) {
        %>
        <p>Please <a href="login.jsp">login</a> to proceed to checkout.</p>
        <% } else { %>
        <%-- Redirect to checkout page if user is logged in --%>
        <% response.sendRedirect("checkout.jsp"); %>
        <% } %>
    </div>
</body>
</html>