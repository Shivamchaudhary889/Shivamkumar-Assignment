package com.hexaware.payxpert.dao;

import com.hexaware.payxpert.entity.Employee;
import com.hexaware.payxpert.entity.Payroll;
import com.hexaware.payxpert.exception.PayrollGenerationException;
import com.hexaware.payxpert.util.DBConnUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PayrollServiceImpl implements IPayrollService {
    private Connection connection;

    public PayrollServiceImpl() {
        this.connection = DBConnUtil.getConnection();
    }

    @Override
    public void generatePayroll(int employeeId, LocalDate startDate, LocalDate endDate) {
        String query = "INSERT INTO Payroll (EmployeeID, PayPeriodStartDate, PayPeriodEndDate, BasicSalary, OvertimePay, Deductions, NetSalary) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, employeeId);
            pstmt.setDate(2, Date.valueOf(startDate));
            pstmt.setDate(3, Date.valueOf(endDate));
            double basicSalary = 5000.0;
            double overtimePay = 500.0;
            double deductions = 1000.0;
            double netSalary = basicSalary + overtimePay - deductions;
            pstmt.setDouble(4, basicSalary);
            pstmt.setDouble(5, overtimePay);
            pstmt.setDouble(6, deductions);
            pstmt.setDouble(7, netSalary);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PayrollGenerationException("Failed to generate payroll for employee ID: " + employeeId);
        }
    }

    @Override
    public Payroll getPayrollById(int payrollId) {
        String query = "SELECT * FROM Payroll WHERE PayrollID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, payrollId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return extractPayrollFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Payroll> getPayrollsForEmployee(int employeeId) {
        List<Payroll> payrolls = new ArrayList<>();
        String query = "SELECT * FROM Payroll WHERE EmployeeID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, employeeId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                payrolls.add(extractPayrollFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payrolls;
    }

    @Override
    public List<Payroll> getPayrollsForPeriod(LocalDate startDate, LocalDate endDate) {
        List<Payroll> payrolls = new ArrayList<>();
        String query = "SELECT * FROM Payroll WHERE PayPeriodStartDate >= ? AND PayPeriodEndDate <= ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setDate(1, Date.valueOf(startDate));
            pstmt.setDate(2, Date.valueOf(endDate));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                payrolls.add(extractPayrollFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payrolls;
    }
    
    @Override
    public double calculateGrossSalary(Employee employee) {
        double baseSalary = 50000; // Assume a base salary
        int yearsOfService = LocalDate.now().getYear() - employee.getJoiningDate().getYear();
        return baseSalary + (yearsOfService * 1000); // Increase by 1000 for each year of service
    }

    @Override
    public double calculateDeductions(Employee employee) {
        double grossSalary = calculateGrossSalary(employee);
        return grossSalary * 0.2; // Assume 20% deductions
    }

    @Override
    public double calculateNetSalary(Employee employee) {
        double grossSalary = calculateGrossSalary(employee);
        double deductions = calculateDeductions(employee);
        return grossSalary - deductions;
    }

    @Override
    public boolean processPayroll(List<Employee> employees) {
        try {
            for (Employee employee : employees) {
                double netSalary = calculateNetSalary(employee);
                System.out.println("Processed payroll for employee " + employee.getEmployeeID() + ": $" + netSalary);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private Payroll extractPayrollFromResultSet(ResultSet rs) throws SQLException {
        Payroll payroll = new Payroll();
        payroll.setPayrollID(rs.getInt("PayrollID"));
        payroll.setEmployeeID(rs.getInt("EmployeeID"));
        payroll.setPayPeriodStartDate(rs.getDate("PayPeriodStartDate").toLocalDate());
        payroll.setPayPeriodEndDate(rs.getDate("PayPeriodEndDate").toLocalDate());
        payroll.setBasicSalary(rs.getDouble("BasicSalary"));
        payroll.setOvertimePay(rs.getDouble("OvertimePay"));
        payroll.setDeductions(rs.getDouble("Deductions"));
        payroll.setNetSalary(rs.getDouble("NetSalary"));
        return payroll;
    }
}
