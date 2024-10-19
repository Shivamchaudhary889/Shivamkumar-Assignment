package com.hexaware.techshop.dao;


import com.hexaware.techshop.entity.Customer;
import java.util.List;

public interface CustomerDAO {
    List<Customer> getAllCustomers();
    Customer getCustomerById(int customerId);
    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(int customerId);
}
