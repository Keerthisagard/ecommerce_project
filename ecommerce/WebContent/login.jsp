<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <style>
        /* Reset default margin and padding */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        /* Global styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f2f5;
            color: #333;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            font-size: 24px;
            margin-bottom: 20px;
            text-align: center;
        }

        .signup-form input[type="text"],
        .signup-form input[type="password"],
        .signup-form input[type="tel"],
        .signup-form button {
            font-size: 16px;
            width: 100%;
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
            margin-bottom: 15px;
            transition: border-color 0.3s ease;
        }

        .signup-form input[type="text"]:focus,
        .signup-form input[type="password"]:focus,
        .signup-form input[type="tel"]:focus {
            border-color: #007bff;
            outline: none;
        }

        .signup-form button {
            background-color: #f90;
            color: #fff;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .signup-form button:hover {
            background-color: #e08000;
        }

        .login-link {
            text-align: center;
            margin-top: 20px;
        }

        .login-link a {
            color: #007bff;
            text-decoration: none;
            transition: color 0.3s ease;
        }

        .login-link a:hover {
            color: #0056b3;
        }

        /* Style for the warning message */
        .error-message {
            color: red;
            text-align: center;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Login</h1>
       <%-- Check for error parameter and display corresponding message --%>
    <% String error = request.getParameter("error");
       if (error != null && error.equals("1")) { %>
           <div style="color: red;">Invalid email or password. Please try again.</div>
    <% } else if (error != null && error.equals("2")) { %>
           <div style="color: red;">Error retrieving user information. Please try again later.</div>
    <% } %>
        <form class="signup-form" action="login" method="post">
            <input type="text" name="email" placeholder="Email" required>
            <input type="password" name="password" placeholder="Password" required>
            <button type="submit">Login</button>
        </form>
        <div class="login-link">
            <p>Don't have an account? <a href="signup.jsp">Sign up</a></p>
        </div>
    </div>
</body>
</html>
