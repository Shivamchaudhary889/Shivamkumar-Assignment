package com.hexaware.payxpert.dao;

import com.hexaware.payxpert.entity.Employee;
import com.hexaware.payxpert.exception.EmployeeNotFoundException;
import com.hexaware.payxpert.util.DBConnUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {
    private Connection connection;

    public EmployeeServiceImpl() {
        this.connection = DBConnUtil.getConnection();
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        String sql = "SELECT * FROM Employee WHERE EmployeeID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, employeeId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return extractEmployeeFromResultSet(rs);
                } else {
                    throw new EmployeeNotFoundException("Employee with ID " + employeeId + " not found.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM Employee";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                employees.add(extractEmployeeFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO Employee (FirstName, LastName, DateOfBirth, Gender, Email, PhoneNumber, Address, Position, JoiningDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, employee.getFirstName());
            pstmt.setString(2, employee.getLastName());
            pstmt.setDate(3, java.sql.Date.valueOf(employee.getDateOfBirth()));
            pstmt.setString(4, employee.getGender());
            pstmt.setString(5, employee.getEmail());
            pstmt.setString(6, employee.getPhoneNumber());
            pstmt.setString(7, employee.getAddress());
            pstmt.setString(8, employee.getPosition());
            pstmt.setDate(9, java.sql.Date.valueOf(employee.getJoiningDate()));

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating employee failed, no rows affected.");
            }

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    employee.setEmployeeID(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating employee failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        String sql = "UPDATE Employee SET FirstName = ?, LastName = ?, DateOfBirth = ?, Gender = ?, Email = ?, PhoneNumber = ?, Address = ?, Position = ?, JoiningDate = ?, TerminationDate = ? WHERE EmployeeID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, employee.getFirstName());
            pstmt.setString(2, employee.getLastName());
            pstmt.setDate(3, java.sql.Date.valueOf(employee.getDateOfBirth()));
            pstmt.setString(4, employee.getGender());
            pstmt.setString(5, employee.getEmail());
            pstmt.setString(6, employee.getPhoneNumber());
            pstmt.setString(7, employee.getAddress());
            pstmt.setString(8, employee.getPosition());
            pstmt.setDate(9, java.sql.Date.valueOf(employee.getJoiningDate()));
            pstmt.setDate(10, employee.getTerminationDate() != null ? java.sql.Date.valueOf(employee.getTerminationDate()) : null);
            pstmt.setInt(11, employee.getEmployeeID());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new EmployeeNotFoundException("Employee with ID " + employee.getEmployeeID() + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeEmployee(int employeeId) {
        String query = "DELETE FROM Employee WHERE EmployeeID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, employeeId);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new EmployeeNotFoundException("Employee not found with ID: " + employeeId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Employee extractEmployeeFromResultSet(ResultSet rs) throws SQLException {
        return new Employee(
            rs.getInt("EmployeeID"),
            rs.getString("FirstName"),
            rs.getString("LastName"),
            rs.getDate("DateOfBirth").toLocalDate(),
            rs.getString("Gender"),
            rs.getString("Email"),
            rs.getString("PhoneNumber"),
            rs.getString("Address"),
            rs.getString("Position"),
            rs.getDate("JoiningDate").toLocalDate(),
            rs.getDate("TerminationDate") != null ? rs.getDate("TerminationDate").toLocalDate() : null
        );
    }
}
