<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Profile</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f3f3f3;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
            color: #333333;
        }
        h2 {
            color: #333333;
        }
        p {
            color: #666666;
            margin-bottom: 10px;
        }
        button {
            background-color: #ff9900;
            color: #ffffff;
            border: none;
            padding: 10px 20px;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #e68a00;
        }
        a {
            color: #007bff;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>User Profile</h1>
        <% 
            com.cruds.entity.User user = (com.cruds.entity.User) session.getAttribute("user");
            if (user != null) { %>
                <div>
                    <h2>Welcome, <%= user.getUsername() %>!</h2>
                    <p>Email: <%= user.getEmail() %></p>
                    <p>Phone Number: <%= user.getPhoneNumber() %></p>
                    <!-- Add more user information here as needed -->
                    <form action="logout" method="post">
                        <button type="submit">Logout</button>
                    </form>
                    <a href="index.html">Home</a>
                </div>
        <% } else { %>
            <p>Please <a href="login.jsp">login</a> to view your profile.</p>
        <% } %>
    </div>
</body>
</html>
