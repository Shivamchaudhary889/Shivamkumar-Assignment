package com.hexaware.payxpert.dao;

import com.hexaware.payxpert.entity.Employee;
import com.hexaware.payxpert.entity.Payroll;
import java.time.LocalDate;
import java.util.List;

public interface IPayrollService {
    void generatePayroll(int employeeId, LocalDate startDate, LocalDate endDate);
    Payroll getPayrollById(int payrollId);
    List<Payroll> getPayrollsForEmployee(int employeeId);
    List<Payroll> getPayrollsForPeriod(LocalDate startDate, LocalDate endDate);
    
    // New methods for testing
    double calculateGrossSalary(Employee employee);
    double calculateDeductions(Employee employee);
    double calculateNetSalary(Employee employee);
    boolean processPayroll(List<Employee> employees);
}
