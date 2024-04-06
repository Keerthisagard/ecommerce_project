<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Order Confirmation</title>
    <style>
        /* Add your CSS styles here */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            text-align: center;
        }
        .container {
            max-width: 800px;
            margin: 100px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        header, footer {
            background-color: #232f3e;
            color: #ffffff;
            padding: 10px 0;
            text-align: center;
        }
        .navbar {
            margin-bottom: 20px;
        }
        .navbar a {
            color: #ffffff;
            text-decoration: none;
            margin: 0 10px;
        }
       h1 {
    color: #007bff; /* Change color to blue (#007bff) */
    margin-top: 20px;
		}
        p {
            color: #666;
        }
    </style>
</head>
<body>
    <header>
        <div class="navbar">
            <a href="index.html">Home</a>
            <a href="OrderItemServlet">Orders</a>
            <a href="userProfile.jsp">Profile</a>
        </div>
        <h1>Order Confirmation</h1> <!-- Added margin-top -->
    </header>
    <div class="container">
        <p>Thank you for your order!</p>
        <p>Your order has been successfully placed.</p>
        <p>An email confirmation has been sent to your email address.</p>
    </div>
    <footer>
        <p>&copy; 2024 Your Website. All rights reserved.</p>
    </footer>
</body>
</html>
