package com.hexaware.payxpert.dao;

import com.hexaware.payxpert.entity.Employee;
import com.hexaware.payxpert.entity.Tax;
import java.util.List;

public interface ITaxService {
    void calculateTax(int employeeId, int taxYear);
    Tax getTaxById(int taxId);
    List<Tax> getTaxesForEmployee(int employeeId);
    List<Tax> getTaxesForYear(int taxYear);
    
 // New method for testing
    double calculateTax(Employee employee, int taxYear);
}
