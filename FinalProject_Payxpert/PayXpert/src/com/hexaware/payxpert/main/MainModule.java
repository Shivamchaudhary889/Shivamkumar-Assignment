package com.hexaware.payxpert.main;

import com.hexaware.payxpert.dao.*;
import com.hexaware.payxpert.entity.*;
import com.hexaware.payxpert.exception.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MainModule {
    private static IEmployeeService employeeService = new EmployeeServiceImpl();
    private static IPayrollService payrollService = new PayrollServiceImpl();
    private static ITaxService taxService = new TaxServiceImpl();
    private static IFinancialRecordService financialRecordService = new FinancialRecordServiceImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- PayXpert: Payroll Management System --- \n           By SHIVAM & ALZEB");
            System.out.println("1. Employee Management");
            System.out.println("2. Payroll Processing");
            System.out.println("3. Tax Management");
            System.out.println("4. Financial Records");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    employeeManagement();
                    break;
                case 2:
                    payrollProcessing();
                    break;
                case 3:
                    taxManagement();
                    break;
                case 4:
                    financialRecords();
                    break;
                case 5:
                    System.out.println("Thank you for using PayXpert. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void employeeManagement() {
        while (true) {
            System.out.println("\n--- Employee Management ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. View Employee");
            System.out.println("5. View All Employees");
            System.out.println("6. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    removeEmployee();
                    break;
                case 4:
                    viewEmployee();
                    break;
                case 5:
                    viewAllEmployees();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void payrollProcessing() {
        while (true) {
            System.out.println("\n--- Payroll Processing ---");
            System.out.println("1. Generate Payroll");
            System.out.println("2. View Payroll by ID");
            System.out.println("3. View Payrolls for Employee");
            System.out.println("4. View Payrolls for Period");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    generatePayroll();
                    break;
                case 2:
                    viewPayrollById();
                    break;
                case 3:
                    viewPayrollsForEmployee();
                    break;
                case 4:
                    viewPayrollsForPeriod();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void taxManagement() {
        while (true) {
            System.out.println("\n--- Tax Management ---");
            System.out.println("1. Calculate Tax");
            System.out.println("2. View Tax by ID");
            System.out.println("3. View Taxes for Employee");
            System.out.println("4. View Taxes for Year");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    calculateTax();
                    break;
                case 2:
                    viewTaxById();
                    break;
                case 3:
                    viewTaxesForEmployee();
                    break;
                case 4:
                    viewTaxesForYear();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void financialRecords() {
        while (true) {
            System.out.println("\n--- Financial Records ---");
            System.out.println("1. Add Financial Record");
            System.out.println("2. View Financial Record by ID");
            System.out.println("3. View Financial Records for Employee");
            System.out.println("4. View Financial Records for Date");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addFinancialRecord();
                    break;
                case 2:
                    viewFinancialRecordById();
                    break;
                case 3:
                    viewFinancialRecordsForEmployee();
                    break;
                case 4:
                    viewFinancialRecordsForDate();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Employee Management Methods
    private static void addEmployee() {
        try {
            System.out.println("Enter employee details:");
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("Date of Birth (YYYY-MM-DD): ");
            LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine());
            System.out.print("Gender: ");
            String gender = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Phone Number: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Address: ");
            String address = scanner.nextLine();
            System.out.print("Position: ");
            String position = scanner.nextLine();
            System.out.print("Joining Date (YYYY-MM-DD): ");
            LocalDate joiningDate = LocalDate.parse(scanner.nextLine());

            Employee employee = new Employee(0, firstName, lastName, dateOfBirth, gender, email, phoneNumber, address, position, joiningDate, null);
            employeeService.addEmployee(employee);
            System.out.println("Employee added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding employee: " + e.getMessage());
        }
    }

    private static void updateEmployee() {
        try {
            System.out.print("Enter Employee ID to update: ");
            int employeeId = scanner.nextInt();
            scanner.nextLine();

            Employee employee = employeeService.getEmployeeById(employeeId);
            if (employee == null) {
                System.out.println("Employee not found.");
                return;
            }

            System.out.println("Enter new details (press enter to keep current value):");
            System.out.print("First Name (" + employee.getFirstName() + "): ");
            String firstName = scanner.nextLine();
            if (!firstName.isEmpty()) employee.setFirstName(firstName);


            employeeService.updateEmployee(employee);
            System.out.println("Employee updated successfully.");
        } catch (Exception e) {
            System.out.println("Error updating employee: " + e.getMessage());
        }
    }

    private static void removeEmployee() {
        try {
            System.out.print("Enter Employee ID to remove: ");
            int employeeId = scanner.nextInt();
            scanner.nextLine();

            employeeService.removeEmployee(employeeId);
            System.out.println("Employee removed successfully.");
        } catch (Exception e) {
            System.out.println("Error removing employee: " + e.getMessage());
        }
    }

    private static void viewEmployee() {
        try {
            System.out.print("Enter Employee ID: ");
            int employeeId = scanner.nextInt();
            scanner.nextLine();

            Employee employee = employeeService.getEmployeeById(employeeId);
            if (employee != null) {
                System.out.println(employee);
            } else {
                System.out.println("Employee not found.");
            }
        } catch (Exception e) {
            System.out.println("Error viewing employee: " + e.getMessage());
        }
    }

    private static void viewAllEmployees() {
        try {
            List<Employee> employees = employeeService.getAllEmployees();
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        } catch (Exception e) {
            System.out.println("Error viewing employees: " + e.getMessage());
        }
    }

    // Payroll Processing Methods
    private static void generatePayroll() {
        try {
            System.out.print("Enter Employee ID: ");
            int employeeId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Start Date (YYYY-MM-DD): ");
            LocalDate startDate = LocalDate.parse(scanner.nextLine());
            System.out.print("Enter End Date (YYYY-MM-DD): ");
            LocalDate endDate = LocalDate.parse(scanner.nextLine());

            payrollService.generatePayroll(employeeId, startDate, endDate);
            System.out.println("Payroll generated successfully.");
        } catch (Exception e) {
            System.out.println("Error generating payroll: " + e.getMessage());
        }
    }

    private static void viewPayrollById() {
        try {
            System.out.print("Enter Payroll ID: ");
            int payrollId = scanner.nextInt();
            scanner.nextLine();

            Payroll payroll = payrollService.getPayrollById(payrollId);
            if (payroll != null) {
                System.out.println(payroll);
            } else {
                System.out.println("Payroll not found.");
            }
        } catch (Exception e) {
            System.out.println("Error viewing payroll: " + e.getMessage());
        }
    }

    private static void viewPayrollsForEmployee() {
        try {
            System.out.print("Enter Employee ID: ");
            int employeeId = scanner.nextInt();
            scanner.nextLine();

            List<Payroll> payrolls = payrollService.getPayrollsForEmployee(employeeId);
            for (Payroll payroll : payrolls) {
                System.out.println(payroll);
            }
        } catch (Exception e) {
            System.out.println("Error viewing payrolls: " + e.getMessage());
        }
    }

    private static void viewPayrollsForPeriod() {
        try {
            System.out.print("Enter Start Date (YYYY-MM-DD): ");
            LocalDate startDate = LocalDate.parse(scanner.nextLine());
            System.out.print("Enter End Date (YYYY-MM-DD): ");
            LocalDate endDate = LocalDate.parse(scanner.nextLine());

            List<Payroll> payrolls = payrollService.getPayrollsForPeriod(startDate, endDate);
            for (Payroll payroll : payrolls) {
                System.out.println(payroll);
            }
        } catch (Exception e) {
            System.out.println("Error viewing payrolls: " + e.getMessage());
        }
    }

    // Tax Management Methods
    private static void calculateTax() {
        try {
            System.out.print("Enter Employee ID: ");
            int employeeId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Tax Year: ");
            int taxYear = scanner.nextInt();
            scanner.nextLine();

            taxService.calculateTax(employeeId, taxYear);
            System.out.println("Tax calculated successfully.");
        } catch (Exception e) {
            System.out.println("Error calculating tax: " + e.getMessage());
        }
    }

    private static void viewTaxById() {
        try {
            System.out.print("Enter Tax ID: ");
            int taxId = scanner.nextInt();
            scanner.nextLine();

            Tax tax = taxService.getTaxById(taxId);
            if (tax != null) {
                System.out.println(tax);
            } else {
                System.out.println("Tax record not found.");
            }
        } catch (Exception e) {
            System.out.println("Error viewing tax: " + e.getMessage());
        }
    }

    private static void viewTaxesForEmployee() {
        try {
            System.out.print("Enter Employee ID: ");
            int employeeId = scanner.nextInt();
            scanner.nextLine();

            List<Tax> taxes = taxService.getTaxesForEmployee(employeeId);
            for (Tax tax : taxes) {
                System.out.println(tax);
            }
        } catch (Exception e) {
            System.out.println("Error viewing taxes: " + e.getMessage());
        }
    }

    private static void viewTaxesForYear() {
        try {
            System.out.print("Enter Tax Year: ");
            int taxYear = scanner.nextInt();
            scanner.nextLine();

            List<Tax> taxes = taxService.getTaxesForYear(taxYear);
            for (Tax tax : taxes) {
                System.out.println(tax);
            }
        } catch (Exception e) {
            System.out.println("Error viewing taxes: " + e.getMessage());
        }
    }


    // Financial Records Methods
    private static void addFinancialRecord() {
        try {
            System.out.println("Enter financial record details:");
            System.out.print("Employee ID: ");
            int employeeId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Record Date (YYYY-MM-DD): ");
            LocalDate recordDate = LocalDate.parse(scanner.nextLine());
            System.out.print("Description: ");
            String description = scanner.nextLine();
            System.out.print("Amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Record Type: ");
            String recordType = scanner.nextLine();

            FinancialRecord record = new FinancialRecord(0, employeeId, recordDate, description, amount, recordType);
            financialRecordService.addFinancialRecord(record);
            System.out.println("Financial record added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding financial record: " + e.getMessage());
        }
    }

    private static void viewFinancialRecordById() {
        try {
            System.out.print("Enter Financial Record ID: ");
            int recordId = scanner.nextInt();
            scanner.nextLine();

            FinancialRecord record = financialRecordService.getFinancialRecordById(recordId);
            if (record != null) {
                System.out.println(record);
            } else {
                System.out.println("Financial record not found.");
            }
        } catch (Exception e) {
            System.out.println("Error viewing financial record: " + e.getMessage());
        }
    }

    private static void viewFinancialRecordsForEmployee() {
        try {
            System.out.print("Enter Employee ID: ");
            int employeeId = scanner.nextInt();
            scanner.nextLine();

            List<FinancialRecord> records = financialRecordService.getFinancialRecordsForEmployee(employeeId);
            for (FinancialRecord record : records) {
                System.out.println(record);
            }
        } catch (Exception e) {
            System.out.println("Error viewing financial records: " + e.getMessage());
        }
    }

    private static void viewFinancialRecordsForDate() {
        try {
            System.out.print("Enter Date (YYYY-MM-DD): ");
            LocalDate date = LocalDate.parse(scanner.nextLine());

            List<FinancialRecord> records = financialRecordService.getFinancialRecordsForDate(date);
            for (FinancialRecord record : records) {
                System.out.println(record);
            }
        } catch (Exception e) {
            System.out.println("Error viewing financial records: " + e.getMessage());
        }
    }

    // Helper methods for input validation and error handling
    private static int getValidIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    private static double getValidDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private static LocalDate getValidDateInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return LocalDate.parse(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid date format. Please use YYYY-MM-DD.");
            }
        }
    }

    // Method to display results in a formatted manner
    private static void displayResults(List<?> results) {
        if (results.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (Object result : results) {
                System.out.println("----------------------------------------");
                String[] lines = result.toString().split(", ");
                for (String line : lines) {
                    System.out.println(line.replace("{", "").replace("}", ""));
                }
            }
            System.out.println("----------------------------------------");
        }
    }
}
