package com.hexaware.payxpert.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.hexaware.payxpert.dao.IEmployeeService;
import com.hexaware.payxpert.dao.EmployeeServiceImpl;
import com.hexaware.payxpert.entity.Employee;
import com.hexaware.payxpert.exception.EmployeeNotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class EmployeeServiceTest {

    private IEmployeeService employeeService;

    @Before
    public void setup() {
        employeeService = new EmployeeServiceImpl();
    }

    @Test
    public void testAddAndGetEmployee() {
        String uniqueEmail = "tony.stark" + UUID.randomUUID().toString().substring(0, 8) + "@avengers.com";
        Employee newEmployee = new Employee(0, "Tony", "Stark", LocalDate.of(1970, 05, 29), "Male", uniqueEmail, "1234567890", "10880 Malibu Point, Malibu", "CEO", LocalDate.of(2010, 01, 01), null);
        employeeService.addEmployee(newEmployee);

        Employee retrievedEmployee = employeeService.getEmployeeById(newEmployee.getEmployeeID());
        assertNotNull(retrievedEmployee);
        assertEquals(newEmployee.getFirstName(), retrievedEmployee.getFirstName());
        assertEquals(newEmployee.getLastName(), retrievedEmployee.getLastName());
        assertEquals(uniqueEmail, retrievedEmployee.getEmail());
    }

    @Test
    public void testUpdateEmployee() {
        // First, add a new employee
        String uniqueEmail = "update.test" + UUID.randomUUID().toString().substring(0, 8) + "@avengers.com";
        Employee employee = new Employee(0, "Update", "Test", LocalDate.of(1980, 1, 1), "Female", uniqueEmail, "9876543210", "123 Test St", "Tester", LocalDate.now(), null);
        employeeService.addEmployee(employee);

        // Now update the employee
        String newLastName = "UpdatedLastName";
        employee.setLastName(newLastName);
        employeeService.updateEmployee(employee);

        Employee updatedEmployee = employeeService.getEmployeeById(employee.getEmployeeID());
        assertEquals(newLastName, updatedEmployee.getLastName());
    }

    @Test(expected = EmployeeNotFoundException.class)
    public void testRemoveEmployee() {
        // First, add a new employee
        String uniqueEmail = "remove.test" + UUID.randomUUID().toString().substring(0, 8) + "@avengers.com";
        Employee employee = new Employee(0, "Remove", "Test", LocalDate.of(1990, 1, 1), "Male", uniqueEmail, "5555555555", "456 Test Ave", "Temp", LocalDate.now(), null);
        employeeService.addEmployee(employee);

        // Now remove the employee
        employeeService.removeEmployee(employee.getEmployeeID());

        // This should throw EmployeeNotFoundException
        employeeService.getEmployeeById(employee.getEmployeeID());
    }

    @Test
    public void testGetAllEmployees() {
        String uniqueEmail = "list.test" + UUID.randomUUID().toString().substring(0, 8) + "@avengers.com";
        Employee employee = new Employee(0, "List", "Test", LocalDate.of(2000, 1, 1), "Female", uniqueEmail, "1111111111", "789 Test Blvd", "Lister", LocalDate.now(), null);
        employeeService.addEmployee(employee);

        List<Employee> employees = employeeService.getAllEmployees();
        assertFalse(employees.isEmpty());
    }
}