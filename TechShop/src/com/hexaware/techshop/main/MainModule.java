/*package com.hexaware.techshop.main;


import com.hexaware.techshop.dao.CustomerDAO;
import com.hexaware.techshop.dao.CustomerDAOImpl;
import com.hexaware.techshop.entity.Customer;

import java.util.List;
import java.util.Scanner;

public class MainModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerDAO customerDAO = new CustomerDAOImpl();

        while (true) {
            System.out.println("TechShop Menu:");
            System.out.println("1. View All Customers");
            System.out.println("2. Add Customer");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    List<Customer> customers = customerDAO.getAllCustomers();
                    for (Customer customer : customers) {
                        System.out.println(customer);
                    }
                    break;

                case 2:
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Customer Email: ");
                    String email = scanner.next();
                    System.out.print("Enter Customer Phone: ");
                    String phone = scanner.next();
                    Customer newCustomer = new Customer(name, email, phone);
                    customerDAO.addCustomer(newCustomer);
                    System.out.println("Customer added successfully!");
                    break;

                case 3:
                    System.out.print("Enter Customer ID to Update: ");
                    int idToUpdate = scanner.nextInt();
                    System.out.print("Enter Updated Name: ");
                    String updatedName = scanner.next();
                    System.out.print("Enter Updated Email: ");
                    String updatedEmail = scanner.next();
                    System.out.print("Enter Updated Phone: ");
                    String updatedPhone = scanner.next();
                    Customer updatedCustomer = new Customer(idToUpdate, updatedName, updatedEmail, updatedPhone);
                    customerDAO.updateCustomer(updatedCustomer);
                    System.out.println("Customer updated successfully!");
                    break;

                case 4:
                    System.out.print("Enter Customer ID to Delete: ");
                    int idToDelete = scanner.nextInt();
                    customerDAO.deleteCustomer(idToDelete);
                    System.out.println("Customer deleted successfully!");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
*/
package com.hexaware.techshop.main;

import com.hexaware.techshop.dao.CustomerDAO;
import com.hexaware.techshop.dao.CustomerDAOImpl;
import com.hexaware.techshop.entity.Customer;

import java.util.List;
import java.util.Scanner;

public class MainModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerDAO customerDAO = new CustomerDAOImpl();

        while (true) {
            System.out.println("TechShop Menu:");
            System.out.println("1. View All Customers");
            System.out.println("2. Add Customer");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    List<Customer> customers = customerDAO.getAllCustomers();
                    for (Customer customer : customers) {
                        System.out.println(customer);
                    }
                    break;

                case 2:
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Customer Email: ");
                    String email = scanner.next();
                    System.out.print("Enter Customer Phone: ");
                    String phone = scanner.next();
                    Customer newCustomer = new Customer(name, email, phone);
                    customerDAO.addCustomer(newCustomer);
                    System.out.println("Customer added successfully!");
                    break;

                case 3:
                    System.out.print("Enter Customer ID to Update: ");
                    int idToUpdate = scanner.nextInt();
                    System.out.print("Enter Updated Name: ");
                    String updatedName = scanner.next();
                    System.out.print("Enter Updated Email: ");
                    String updatedEmail = scanner.next();
                    System.out.print("Enter Updated Phone: ");
                    String updatedPhone = scanner.next();
                    Customer updatedCustomer = new Customer(idToUpdate, updatedName, updatedEmail, updatedPhone);
                    customerDAO.updateCustomer(updatedCustomer);
                    System.out.println("Customer updated successfully!");
                    break;

                case 4:
                    System.out.print("Enter Customer ID to Delete: ");
                    int idToDelete = scanner.nextInt();
                    customerDAO.deleteCustomer(idToDelete);
                    System.out.println("Customer deleted successfully!");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
