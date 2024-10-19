package com.hexaware.techshop.entity;

public class Product {
    private int productId;
    private String productName;
    private double price;
    private int stock;
	public int getProductId() {
		return productId;
	}
	
	/**
	 * 
	 */
	public Product() {
		super();
	}


	/**
	 * @param productId
	 * @param productName
	 * @param price
	 * @param stock
	 */
	public Product(int productId, String productName, double price, int stock) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.stock = stock;
	}



	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

    // Constructors, Getters, and Setters
    
    
    
}
