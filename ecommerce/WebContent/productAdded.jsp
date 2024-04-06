<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Added</title>
    <!-- Font Awesome CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha384-SSpb3YH9dWJhAcpZh0mKXWb9LlHsMHwzgp/LF+dyFO1NYmxx+XH9FtNuKHLwSwg6" crossorigin="anonymous">
</head>
<body>
    <header>
        <div class="container">
            <h1>E-commerce Website</h1>
            <nav>
                <ul>
                    <li><a href="orderConfirmation.jsp">Orders</a></li>
                    <li><a href="viewCart.jsp"><i class="fas fa-shopping-cart"></i> Cart</a></li>
                    <li><a href="login.jsp">Profile</a></li>
                </ul>
            </nav>
        </div>
    </header>

    <section class="product-added">
        <div class="container">
            <h2>Product Added</h2>
            <div class="product">
                <img src="<%= request.getAttribute("productImageUrl") %>" alt="<%= request.getAttribute("productName") %>">
                <h3><%= request.getAttribute("productName") %></h3>
                <p><%= request.getAttribute("productDescription") %></p>
                <p class="price">$<%= request.getAttribute("productPrice") %></p>
            </div>
            <p><a href="viewCart.jsp">View Cart</a></p>
        </div>
    </section>

    <footer>
        <p>&copy; 2024 E-commerce Website. All rights reserved.</p>
    </footer>
</body>
</html>
