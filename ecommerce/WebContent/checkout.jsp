<%@ page import="com.cruds.entity.User"%>
<%@ page import="com.cruds.entity.Product"%>
<%@ page import="com.cruds.entity.CartItem"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Checkout</title>
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
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h1 {
            font-size: 24px;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
            color: #333;
        }
        tbody tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        p {
            font-size: 16px;
            margin-bottom: 20px;
        }
        button {
            background-color: #f90;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        button:hover {
            background-color: #e08000;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Checkout</h1>
        
        <!-- Order Summary -->
        <h2>Order Summary</h2>
        <table>
            <thead>
                <tr>
                    <th>Product</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    // Retrieve cart items from session
                    List<CartItem> cartItems = (List<CartItem>) session.getAttribute("CART");
                    double totalAmount = 0.0;
                    if (cartItems != null && !cartItems.isEmpty()) {
                        for (CartItem item : cartItems) {
                            Product product = item.getProduct();
                            totalAmount += product.getPrice() * item.getQuantity();
                %>
                <tr>
                    <td><%= product.getName() %></td>
                    <td>$<%= product.getPrice() %></td>
                    <td><%= item.getQuantity() %></td>
                    <td>$<%= product.getPrice() * item.getQuantity() %></td>
                </tr>
                <% 
                        }
                    }
                %>
            </tbody>
        </table>
        
        <!-- Total Amount -->
        <p>Total Amount: $<%= totalAmount %></p>
        
        <!-- Checkout button -->
        <form action="ProcessOrderServlet" method="post">
            <button type="submit">Place Order</button>
        </form>
    </div>
</body>
</html>
