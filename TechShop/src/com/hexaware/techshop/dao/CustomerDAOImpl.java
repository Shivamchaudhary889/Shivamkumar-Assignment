package com.hexaware.techshop.dao;

import com.hexaware.techshop.entity.Customer;
import com.hexaware.techshop.util.DBConnUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    private static final String GET_ALL_CUSTOMERS_QUERY = "SELECT * FROM customers";
    private static final String ADD_CUSTOMER_QUERY = "INSERT INTO customers (name, email, phone) VALUES (?, ?, ?)";
    private static final String UPDATE_CUSTOMER_QUERY = "UPDATE customers SET name = ?, email = ?, phone = ? WHERE id = ?";
    private static final String DELETE_CUSTOMER_QUERY = "DELETE FROM customers WHERE id = ?";
    private static final String GET_CUSTOMER_BY_ID_QUERY = "SELECT * FROM customers WHERE id = ?"; // Add this query

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(GET_ALL_CUSTOMERS_QUERY);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Customer customer = new Customer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone")
                );
                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public void addCustomer(Customer customer) {
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(ADD_CUSTOMER_QUERY)) {

            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getEmail());
            stmt.setString(3, customer.getPhone());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_CUSTOMER_QUERY)) {

            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getEmail());
            stmt.setString(3, customer.getPhone());
            stmt.setInt(4, customer.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(int customerId) {
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETE_CUSTOMER_QUERY)) {

            stmt.setInt(1, customerId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Implement getCustomerById method
    @Override
    public Customer getCustomerById(int customerId) {
        Customer customer = null;
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(GET_CUSTOMER_BY_ID_QUERY)) {

            stmt.setInt(1, customerId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    customer = new Customer(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("phone")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
}
