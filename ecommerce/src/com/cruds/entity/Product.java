package com.cruds.entity;

public class Product {
    private int productId;
    private String name;
    private double price;
    private String imageUrl;
    private String description; // Added description field
    
    public Product() {
        super();
    }

    public Product(String name, double price, String imageUrl, String description) {
        super();
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.description = description;
    }

  
    
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product [ name=" + name + ", price=" + price + ", imageUrl=" + imageUrl
                + ", description=" + description + "]";
    }
}
