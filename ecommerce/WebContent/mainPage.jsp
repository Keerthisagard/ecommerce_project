<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>E-commerce Website</title>
    <!-- Font Awesome CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha384-SSpb3YH9dWJhAcpZh0mKXWb9LlHsMHwzgp/LF+dyFO1NYmxx+XH9FtNuKHLwSwg6" crossorigin="anonymous">
    <!-- Your custom styles -->
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
            background-color: #f8f9fa;
            color: #333;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 0 20px;
        }

        /* Header styles */
        header {
            background-color: #232f3e;
            color: #fff;
            padding: 10px 0;
        }

        header .container {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        header h1 {
            font-size: 28px;
            text-transform: uppercase;
            font-weight: bold;
            margin-left: 20px;
        }

        header nav ul {
            list-style: none;
            display: flex;
            align-items: center;
        }

        header nav ul li {
            margin-right: 20px;
        }

        header nav ul li a {
            color: #fff;
            text-decoration: none;
            font-size: 16px;
            transition: color 0.3s ease;
        }

        header nav ul li a:hover {
            color: #f90;
        }

        /* Featured products section styles */
        .featured-products {
            padding: 30px 0;
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
        }

        .product {
            width: 300px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            margin-bottom: 20px;
            transition: transform 0.3s ease;
        }

        .product:hover {
            transform: translateY(-5px);
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
        }

        .product img {
            max-width: 100%;
            height: auto;
            border-radius: 5px;
            margin-bottom: 15px;
        }

        .product h3 {
            font-size: 20px;
            margin-bottom: 10px;
        }

        .product p {
            font-size: 16px;
            color: #888;
            margin-bottom: 15px;
        }

        .product .price {
            font-size: 20px;
            color: #f90;
            font-weight: bold;
        }

        .product .btn {
            display: block;
            width: 100%;
            background-color: #f90;
            color: #fff;
            padding: 10px 0;
            text-decoration: none;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            text-align: center;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .product .btn:hover {
            background-color: #ffaa00;
        }

        /* Footer styles */
        footer {
            background-color: #232f3e;
            color: #fff;
            padding: 20px 0;
            text-align: center;
            margin-top: 50px;
        }

        footer p {
            font-size: 16px;
        }

        /* Success message style */
        .success-message {
            background-color: #dff0d8;
            color: #3c763d;
            padding: 15px;
            border-radius: 5px;
            margin: 20px 0;
            font-size: 18px;
            display: block; /* Ensure the message is visible */
        }
    </style>
</head>
<body>
    <header>
        <div class="container">
            <h1>E-commerce Website</h1>
            <nav>
                <ul>
                	<li><a href="index.html">Home</a></li>
                    <li><a href="OrderItemServlet">Order history</a></li>
                    <li><a href="viewCart.jsp"><i class="fas fa-shopping-cart"></i> Cart</a></li>
                    <li><a href="userProfile.jsp">Profile</a></li>
                </ul>
            </nav>
        </div>
    </header>

    <!-- Display success message if present -->
  <% 
	String successMessage = (String) session.getAttribute("SUCCESS_MESSAGE");
	if (successMessage != null) {
	%>
	<div class="success-message" id="successMessage">
    	<%= successMessage %>
	</div>
	<script>
    	// Hide success message after 5 seconds
    	setTimeout(function(){
        	document.getElementById('successMessage').style.display = 'none';
    	}, 2000); // 5000 milliseconds = 5 seconds
	</script>
	<% 
    	// Remove the success message from session after displaying it
    	session.removeAttribute("SUCCESS_MESSAGE");
		} 
	%>

    <!-- Featured products section -->
    <section class="featured-products">
        <div class="container">
            <!-- Product 1 -->
            <div class="product">
                <img src="images/Product1.jpg" alt="Redmi">
                <h3>Redmi</h3>
                <p>A budget-friendly smartphone with great features.</p>
                <p class="price">$49.99</p>
                <!-- Add to Cart form -->
                <form action="addToCart" method="post">
                    <input type="hidden" name="productId" value="1">
                    <input type="hidden" name="productName" value="Redmi">
                    <input type="hidden" name="productPrice" value="49.99">
                    <input type="hidden" name="productImageUrl" value="images/Product1.jpg">
                    <input type="hidden" name="productDescription" value="A budget-friendly smartphone with great features.">
                    <button type="submit" class="btn">Add to Cart</button>
                </form>
            </div>

            <!-- Product 2 -->
            <div class="product">
                <img src="images/Product2.jpg" alt="Iphone">
                <h3>Iphone</h3>
                <p>A premium smartphone known for its sleek design and powerful performance.</p>
                <p class="price">$39.99</p>
                <!-- Add to Cart form -->
                <form action="addToCart" method="post">
                    <input type="hidden" name="productId" value="2">
                    <input type="hidden" name="productName" value="Iphone">
                    <input type="hidden" name="productPrice" value="39.99">
                    <input type="hidden" name="productImageUrl" value="images/Product2.jpg">
                    <input type="hidden" name="productDescription" value="A premium smartphone known for its sleek design and powerful performance.">
                    <button type="submit" class="btn">Add to Cart</button>
                </form>
            </div>
            
            <!-- Product 3 -->
            <div class="product">
                <img src="images/Product3.jpg" alt="Samsung">
                <h3>Samsung</h3>
                <p>A versatile smartphone with a wide range of features and capabilities.</p>
                <p class="price">$59.99</p>
                <!-- Add to Cart form -->
                <form action="addToCart" method="post">
                    <input type="hidden" name="productId" value="3">
                    <input type="hidden" name="productName" value="Samsung">
                    <input type="hidden" name="productPrice" value="59.99">
                    <input type="hidden" name="productImageUrl" value="images/Product3.jpg">
                    <input type="hidden" name="productDescription" value="A versatile smartphone with a wide range of features and capabilities.">
                    <button type="submit" class="btn">Add to Cart</button>
                </form>
            </div>
            
            <!-- Product 4 -->
            <div class="product">
                <img src="images/Product4.jpg" alt="Oneplus">
                <h3>Oneplus</h3>
                <p>A high-performance smartphone known for its speed and efficiency.</p>
                <p class="price">$60.99</p>
                <!-- Add to Cart form -->
                <form action="addToCart" method="post">
                    <input type="hidden" name="productId" value="4">
                    <input type="hidden" name="productName" value="Oneplus">
                    <input type="hidden" name="productPrice" value="60.99">
                    <input type="hidden" name="productImageUrl" value="images/Product4.jpg">
                    <input type="hidden" name="productDescription" value="A high-performance smartphone known for its speed and efficiency.">
                    <button type="submit" class="btn">Add to Cart</button>
                </form>
            </div>
            
            <!-- Product 5 -->
            <div class="product">
                <img src="images/Product5.jpg" alt="Techno">
                <h3>Techno</h3>
                <p>An affordable smartphone with decent features for everyday use.</p>
                <p class="price">$30.99</p>
                <!-- Add to Cart form -->
                <form action="addToCart" method="post">
                    <input type="hidden" name="productId" value="5">
                    <input type="hidden" name="productName" value="Techno">
                    <input type="hidden" name="productPrice" value="30.99">
                    <input type="hidden" name="productImageUrl" value="images/Product5.jpg">
                    <input type="hidden" name="productDescription" value="An affordable smartphone with decent features for everyday use.">
                    <button type="submit" class="btn">Add to Cart</button>
                </form>
            </div>
            
            <!-- Product 6 -->
            <div class="product">
                <img src="images/Product6.jpg" alt="Poco">
                <h3>Poco</h3>
                <p>A budget-friendly smartphone with impressive specifications.</p>
                <p class="price">$24.99</p>
                <!-- Add to Cart form -->
                <form action="addToCart" method="post">
                    <input type="hidden" name="productId" value="6">
                    <input type="hidden" name="productName" value="Poco">
                    <input type="hidden" name="productPrice" value="24.99">
                    <input type="hidden" name="productImageUrl" value="images/Product6.jpg">
                    <input type="hidden" name="productDescription" value="A budget-friendly smartphone with impressive specifications.">
                    <button type="submit" class="btn">Add to Cart</button>
                </form>
            </div>
            
            <!-- Product 7 -->
            <div class="product">
                <img src="images/Product7.jpg" alt="Vivo">
                <h3>Vivo</h3>
                <p>A stylish smartphone with advanced camera features for photography enthusiasts.</p>
                <p class="price">$45.99</p>
                <!-- Add to Cart form -->
                <form action="addToCart" method="post">
                    <input type="hidden" name="productId" value="7">
                    <input type="hidden" name="productName" value="Vivo">
                    <input type="hidden" name="productPrice" value="45.99">
                    <input type="hidden" name="productImageUrl" value="images/Product7.jpg">
                    <input type="hidden" name="productDescription" value="A stylish smartphone with advanced camera features for photography enthusiasts.">
                    <button type="submit" class="btn">Add to Cart</button>
                </form>
            </div>
            
            <!-- Product 8 -->
            <div class="product">
                <img src="images/Product8.jpg" alt="Lava">
                <h3>Lava</h3>
                <p>A reliable smartphone brand known for its durability and longevity.</p>
                <p class="price">$98.99</p>
                <!-- Add to Cart form -->
                <form action="addToCart" method="post">
                    <input type="hidden" name="productId" value="8">
                    <input type="hidden" name="productName" value="Lava">
                    <input type="hidden" name="productPrice" value="98.99">
                    <input type="hidden" name="productImageUrl" value="images/Product8.jpg">
                    <input type="hidden" name="productDescription" value="A reliable smartphone brand known for its durability and longevity.">
                    <button type="submit" class="btn">Add to Cart</button>
                </form>
            </div>
            
            <!-- Product 9 -->
            <div class="product">
                <img src="images/Product9.jpg" alt="Honor">
                <h3>Honor</h3>
                <p>A mid-range smartphone offering a balance of performance and affordability.</p>
                <p class="price">$22.99</p>
                <!-- Add to Cart form -->
                <form action="addToCart" method="post">
                    <input type="hidden" name="productId" value="9">
                    <input type="hidden" name="productName" value="Honor">
                    <input type="hidden" name="productPrice" value="22.99">
                    <input type="hidden" name="productImageUrl" value="images/Product9.jpg">
                    <input type="hidden" name="productDescription" value="A mid-range smartphone offering a balance of performance and affordability.">
                    <button type="submit" class="btn">Add to Cart</button>
                </form>
            </div>
            
            <!-- Product 10 -->
            <div class="product">
                <img src="images/Product10.jpg" alt="Oppo">
                <h3>Oppo</h3>
                <p>A sleek and stylish smartphone brand known for its innovative camera technology.</p>
                <p class="price">$43.99</p>
                <!-- Add to Cart form -->
                <form action="addToCart" method="post">
                    <input type="hidden" name="productId" value="10">
                    <input type="hidden" name="productName" value="Oppo">
                    <input type="hidden" name="productPrice" value="43.99">
                    <input type="hidden" name="productImageUrl" value="images/Product10.jpg">
                    <input type="hidden" name="productDescription" value="A sleek and stylish smartphone brand known for its innovative camera technology.">
                    <button type="submit" class="btn">Add to Cart</button>
                </form>
            </div>
            
            <!-- Product 11 -->
            <div class="product">
                <img src="images/Product11.jpg" alt="Realme">
                <h3>Realme</h3>
                <p>A budget-friendly smartphone brand offering great value for money.</p>
                <p class="price">$54.99</p>
                <!-- Add to Cart form -->
                <form action="addToCart" method="post">
                    <input type="hidden" name="productId" value="11">
                    <input type="hidden" name="productName" value="Realme">
                    <input type="hidden" name="productPrice" value="54.99">
                    <input type="hidden" name="productImageUrl" value="images/Product11.jpg">
                    <input type="hidden" name="productDescription" value="A budget-friendly smartphone brand offering great value for money.">
                    <button type="submit" class="btn">Add to Cart</button>
                </form>
            </div>
            
            <!-- Product 12 -->
            <div class="product">
                <img src="images/Product12.jpg" alt="Iqoo">
                <h3>Iqoo</h3>
                <p>A gaming-centric smartphone with powerful hardware and performance features.</p>
                <p class="price">$24.99</p>
                <!-- Add to Cart form -->
                <form action="addToCart" method="post">
                    <input type="hidden" name="productId" value="12">
                    <input type="hidden" name="productName" value="Iqoo">
                    <input type="hidden" name="productPrice" value="24.99">
                    <input type="hidden" name="productImageUrl" value="images/Product12.jpg">
                    <input type="hidden" name="productDescription" value="A gaming-centric smartphone with powerful hardware and performance features.">
                    <button type="submit" class="btn">Add to Cart</button>
                </form>
            </div>
        </div>
    </section>

    <footer>
        <p>&copy; 2024 E-commerce Website. All rights reserved.</p>
    </footer>
</body>
</html>
