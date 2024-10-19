package com.hexaware.techshop.dao;


import com.hexaware.techshop.entity.Order;
import java.util.List;

public interface OrderDAO {
    List<Order> getAllOrders();
    Order getOrderById(int orderId);
    void addOrder(Order order);
    void updateOrder(Order order);
    void deleteOrder(int orderId);
}
