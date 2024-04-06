package com.cruds.service;

import com.cruds.db.ProductDAO;
import com.cruds.entity.Product;

public class AddProduct {

    public static void main(String[] args) {
        // Create Product objects with the product details including descriptions
        Product product1 = new Product("Redmi", 49.99, "images/Product1.jpg", "A budget-friendly smartphone with great features.");
        Product product2 = new Product("Iphone", 39.99, "images/Product2.jpg", "A premium smartphone known for its sleek design and powerful performance.");
        Product product3 = new Product("Samsung", 59.99, "images/Product3.jpg", "A versatile smartphone with a wide range of features and capabilities.");
        Product product4 = new Product("Oneplus", 60.99, "images/Product4.jpg", "A high-performance smartphone known for its speed and efficiency.");
        Product product5 = new Product("Techno", 30.99, "images/Product5.jpg", "An affordable smartphone with decent features for everyday use.");
        Product product6 = new Product("Poco", 24.99, "images/Product6.jpg", "A budget-friendly smartphone with impressive specifications.");
        Product product7 = new Product("Vivo", 45.99, "images/Product7.jpg", "A stylish smartphone with advanced camera features for photography enthusiasts.");
        Product product8 = new Product("Lava", 98.99, "images/Product8.jpg", "A reliable smartphone brand known for its durability and longevity.");
        Product product9 = new Product("Honor", 22.99, "images/Product9.jpg", "A mid-range smartphone offering a balance of performance and affordability.");
        Product product10 = new Product("Oppo", 43.99, "images/Product10.jpg", "A sleek and stylish smartphone brand known for its innovative camera technology.");
        Product product11 = new Product("Realme", 54.99, "images/Product11.jpg", "A budget-friendly smartphone brand offering great value for money.");
        Product product12 = new Product("Iqoo", 24.99, "images/Product12.jpg", "A gaming-centric smartphone with powerful hardware and performance features.");
        
        // Create a ProductDAO instance
        ProductDAO productDAO = new ProductDAO();
        
        try {
            // Add the products to the database
            productDAO.addProduct(product1);
            productDAO.addProduct(product2);
            productDAO.addProduct(product3);
            productDAO.addProduct(product4);
            productDAO.addProduct(product5);
            productDAO.addProduct(product6);
            productDAO.addProduct(product7);
            productDAO.addProduct(product8);
            productDAO.addProduct(product9);
            productDAO.addProduct(product10);
            productDAO.addProduct(product11);
            productDAO.addProduct(product12);
            
            // Print confirmation message
            System.out.println("Products added successfully.");
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
            System.out.println("Failed to add products. Check the console for details.");
        }
    }
}
