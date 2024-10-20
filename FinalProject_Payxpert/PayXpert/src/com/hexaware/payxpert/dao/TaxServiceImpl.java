package com.hexaware.payxpert.dao;

import com.hexaware.payxpert.entity.Employee;
import com.hexaware.payxpert.entity.Tax;
import com.hexaware.payxpert.exception.TaxCalculationException;
import com.hexaware.payxpert.util.DBConnUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaxServiceImpl implements ITaxService {
    private Connection connection;

    public TaxServiceImpl() {
        this.connection = DBConnUtil.getConnection();
    }

    @Override
    public void calculateTax(int employeeId, int taxYear) {
        String query = "INSERT INTO Tax (EmployeeID, TaxYear, TaxableIncome, TaxAmount) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, employeeId);
            pstmt.setInt(2, taxYear);
            double taxableIncome = 50000.0;
            double taxAmount = 10000.0;
            pstmt.setDouble(3, taxableIncome);
            pstmt.setDouble(4, taxAmount);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TaxCalculationException("Failed to calculate tax for employee ID: " + employeeId);
        }
    }

    @Override
    public Tax getTaxById(int taxId) {
        String query = "SELECT * FROM Tax WHERE TaxID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, taxId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return extractTaxFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Tax> getTaxesForEmployee(int employeeId) {
        List<Tax> taxes = new ArrayList<>();
        String query = "SELECT * FROM Tax WHERE EmployeeID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, employeeId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                taxes.add(extractTaxFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taxes;
    }

    @Override
    public List<Tax> getTaxesForYear(int taxYear) {
        List<Tax> taxes = new ArrayList<>();
        String query = "SELECT * FROM Tax WHERE TaxYear = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, taxYear);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                taxes.add(extractTaxFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taxes;
    }
    
    @Override
    public double calculateTax(Employee employee, int taxYear) {
        double taxableIncome = calculateTaxableIncome(employee);
        
        if (taxableIncome <= 50000) {
            return taxableIncome * 0.1; // 10% tax rate for income up to 50,000
        } else if (taxableIncome <= 100000) {
            return 5000 + (taxableIncome - 50000) * 0.2; // 20% tax rate for income between 50,000 and 100,000
        } else {
            return 15000 + (taxableIncome - 100000) * 0.3; // 30% tax rate for income over 100,000
        }
    }
    
    private double calculateTaxableIncome(Employee employee) {
        IPayrollService payrollService = new PayrollServiceImpl();
        double grossSalary = payrollService.calculateGrossSalary(employee);
        return grossSalary * 0.9; // Assume 10% of gross salary is non-taxable
    }


    private Tax extractTaxFromResultSet(ResultSet rs) throws SQLException {
        Tax tax = new Tax();
        tax.setTaxID(rs.getInt("TaxID"));
        tax.setEmployeeID(rs.getInt("EmployeeID"));
        tax.setTaxYear(rs.getInt("TaxYear"));
        tax.setTaxableIncome(rs.getDouble("TaxableIncome"));
        tax.setTaxAmount(rs.getDouble("TaxAmount"));
        return tax;
    }
}
