package com.hexaware.techshop.dao;

import com.hexaware.techshop.entity.Order;
import com.hexaware.techshop.util.DBConnUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    private static final String GET_ALL_ORDERS_QUERY = "SELECT * FROM orders";
    private static final String GET_ORDER_BY_ID_QUERY = "SELECT * FROM orders WHERE id = ?";
    private static final String ADD_ORDER_QUERY = "INSERT INTO orders (customerId, productId, quantity, orderDate) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_ORDER_QUERY = "UPDATE orders SET customerId = ?, productId = ?, quantity = ?, orderDate = ? WHERE id = ?";
    private static final String DELETE_ORDER_QUERY = "DELETE FROM orders WHERE id = ?";

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        try (Connection conn = DBConnUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(GET_ALL_ORDERS_QUERY)) {
            while (rs.next()) {
                // Use the correct constructor with appropriate parameters
                Order order = new Order(rs.getInt("id"), rs.getInt("customerId"), rs.getInt("productId"), rs.getInt("quantity"), rs.getDate("orderDate"));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public Order getOrderById(int orderId) {
        Order order = null;
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(GET_ORDER_BY_ID_QUERY)) {
            pstmt.setInt(1, orderId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                order = new Order(rs.getInt("id"), rs.getInt("customerId"), rs.getInt("productId"), rs.getInt("quantity"), rs.getDate("orderDate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public void addOrder(Order order) {
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(ADD_ORDER_QUERY)) {
            pstmt.setInt(1, order.getCustomerId());
            pstmt.setInt(2, order.getProductId());
            pstmt.setInt(3, order.getQuantity());
            pstmt.setDate(4, new java.sql.Date(order.getOrderDate().getTime()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateOrder(Order order) {
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE_ORDER_QUERY)) {
            pstmt.setInt(1, order.getCustomerId());
            pstmt.setInt(2, order.getProductId());
            pstmt.setInt(3, order.getQuantity());
            pstmt.setDate(4, new java.sql.Date(order.getOrderDate().getTime()));
            pstmt.setInt(5, order.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(int orderId) {
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(DELETE_ORDER_QUERY)) {
            pstmt.setInt(1, orderId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
