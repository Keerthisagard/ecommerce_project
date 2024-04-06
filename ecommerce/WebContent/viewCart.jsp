<%@page import="com.cruds.entity.Product"%>
<%@page import="com.cruds.entity.CartItem"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Cart</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f3f3f3;
    }
    header {
        background-color: #131921;
        color: #ffffff;
        padding: 20px 0;
        text-align: center;
    }
    .container {
        margin: 20px auto;
        max-width: 1200px;
        padding: 0 20px;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        background-color: #ffffff;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }
    th, td {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 12px;
    }
    th {
        background-color: #f0f2f2;
        color: #111;
    }
    tr:nth-child(even) {
        background-color: #f8f8f8;
    }
    img {
        max-width: 80px;
        max-height: 80px;
        display: block;
        margin: auto;
    }
    footer {
        background-color: #131921;
        color: #ffffff;
        text-align: center;
        padding: 10px 0;
        width: 100%;
        position: fixed;
        bottom: 0;
        left: 0;
    }
    .empty-cart-message {
        text-align: center;
        font-size: 18px;
        padding: 20px 0;
        color: #666666;
    }
    .checkout-btn {
        background-color: #f0c14b;
        color: #111;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        font-size: 16px;
        cursor: pointer;
        text-decoration: none;
        transition: background-color 0.3s;
        display: block;
        margin: 20px auto;
        width: fit-content;
    }
    .checkout-btn:hover {
        background-color: #ddb347;
    }
    .remove-btn {
        background-color: #FF9900; /* Orange color */
        color: #fff;
        padding: 8px 16px;
        border: none;
        border-radius: 4px;
        font-size: 14px;
        cursor: pointer;
        text-decoration: none;
        transition: background-color 0.3s;
    }
    .remove-btn:hover {
        background-color: #e68a00; /* Darker orange color on hover */
    }
</style>

</head>
<body>
    <header>
        <h1>View Cart</h1>
        <a href="mainPage.jsp" style="color: #ffffff; text-decoration: none;">Products</a>
        <a href="index.html" style="color: #ffffff; text-decoration: none;">Home</a>
    </header>

    <div class="container">
        <table>
            <thead>
                <tr>
                    <th>Product</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <% 
                // Retrieve cart items from session
                List<CartItem> cart = (List<CartItem>) session.getAttribute("CART");
                if (cart != null && !cart.isEmpty()) {
                    for (CartItem item : cart) {
                        Product product = item.getProduct();
                %>
                <tr>
                    <td>
                        <img src="<%= product.getImageUrl() %>" alt="<%= product.getName() %>">
                        <div><%= product.getName() %></div>
                    </td>
                    <td>$<%= product.getPrice() %></td>
                    <td><%= item.getQuantity() %></td>
                    <td>$<%= product.getPrice() * item.getQuantity() %></td>
                    <td>
                        <form action="RemoveFromCartServlet" method="post">
                            <input type="hidden" name="productId" value="<%= product.getProductId() %>">
                            <button type="submit" class="remove-btn">Remove</button>
                        </form>
                    </td>
                </tr>
                <% 
                    }
                } else {
                %>
                <tr>
                    <td colspan="5" class="empty-cart-message">Your cart is empty</td>
                </tr>
                <% } %>
            </tbody>
        </table>
        
        
        <div style="text-align: center; margin-top: 20px;">
            <a href="loginRequired.jsp" class="checkout-btn">Proceed to Checkout</a>
        </div>
    </div>

    <footer>
        <p>&copy; 2024 E-commerce Website. All rights reserved.</p>
    </footer>
    
     <!-- JavaScript to toggle checkout button visibility -->
    <script>
        // Get the checkout button element
        const checkoutBtn = document.querySelector('.checkout-btn');
        
        // Check if cart is empty to show/hide the checkout button
        <% if (cart == null || cart.isEmpty()) { %>
            checkoutBtn.style.display = 'none';
        <% } else { %>
            checkoutBtn.style.display = 'block';
        <% } %>
    </script>
</body>
</html>

