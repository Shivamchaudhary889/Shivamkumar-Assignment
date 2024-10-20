package com.hexaware.payxpert.dao;

import com.hexaware.payxpert.entity.Employee;
import java.util.List;

public interface IEmployeeService {
    Employee getEmployeeById(int employeeId);
    List<Employee> getAllEmployees();
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void removeEmployee(int employeeId);
}
