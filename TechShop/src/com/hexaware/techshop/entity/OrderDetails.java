package com.hexaware.techshop.entity;


public class OrderDetails {
    private int orderDetailId;
    private int orderId;
    private int productId;
    private int quantity;
    private double price;

    // Constructors
    public OrderDetails(int orderDetailId, int orderId, int productId, int quantity, double price) {
        this.orderDetailId = orderDetailId;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters
    public int getOrderDetailId() { return orderDetailId; }
    public void setOrderDetailId(int orderDetailId) { this.orderDetailId = orderDetailId; }

    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "OrderDetails [orderDetailId=" + orderDetailId + ", orderId=" + orderId + ", productId=" + productId + ", quantity=" + quantity + ", price=" + price + "]";
    }
}
