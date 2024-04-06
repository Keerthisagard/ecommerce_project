<!DOCTYPE html>
<%@page import="com.cruds.entity.OrderItem"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Order Items</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f3f3f3;
            margin: 0;
            padding: 20px;
        }
        h1 {
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        }
        th, td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }
        td {
            background-color: #fff;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        .no-data {
            text-align: center;
            font-style: italic;
            color: #777;
        }
    </style>
</head>
<body>
    <h1>Order Items</h1>
    <table>
        <thead>
            <tr>
                <th>Order ID</th>
                <th>Product Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Order Date</th>
                <th>Total Price</th>
            </tr>
        </thead>
        <tbody>
            <% List<OrderItem> orderItems = (List<OrderItem>) request.getAttribute("orderItems");
               if (orderItems != null && !orderItems.isEmpty()) {
                   for (OrderItem orderItem : orderItems) { %>
                       <tr>
                           <td><%= orderItem.getOrderId() %></td>
                           <td><%= orderItem.getProductName() %></td>
                           <td>$<%= orderItem.getPrice() %></td>
                           <td><%= orderItem.getQuantity() %></td>
                           <td><%= orderItem.getOrderDate() %></td>
                           <td>$<%= orderItem.getTotalPrice() %></td>
                       </tr>
               <%    }
               } else { %>
                   <tr>
                       <td colspan="6" class="no-data">No order items found.</td>
                   </tr>
               <% } %>
        </tbody>
    </table>
</body>
</html>
