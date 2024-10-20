package com.hexaware.payxpert.dao;

import com.hexaware.payxpert.entity.FinancialRecord;
import com.hexaware.payxpert.exception.FinancialRecordException;
import com.hexaware.payxpert.util.DBConnUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FinancialRecordServiceImpl implements IFinancialRecordService {
    private Connection connection;

    public FinancialRecordServiceImpl() {
        this.connection = DBConnUtil.getConnection();
    }

    @Override
    public void addFinancialRecord(FinancialRecord record) {
        String query = "INSERT INTO FinancialRecord (EmployeeID, RecordDate, Description, Amount, RecordType) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, record.getEmployeeID());
            pstmt.setDate(2, Date.valueOf(record.getRecordDate()));
            pstmt.setString(3, record.getDescription());
            pstmt.setDouble(4, record.getAmount());
            pstmt.setString(5, record.getRecordType());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new FinancialRecordException("Failed to add financial record for employee ID: " + record.getEmployeeID());
        }
    }

    @Override
    public FinancialRecord getFinancialRecordById(int recordId) {
        String query = "SELECT * FROM FinancialRecord WHERE RecordID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, recordId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return extractFinancialRecordFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<FinancialRecord> getFinancialRecordsForEmployee(int employeeId) {
        List<FinancialRecord> records = new ArrayList<>();
        String query = "SELECT * FROM FinancialRecord WHERE EmployeeID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, employeeId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                records.add(extractFinancialRecordFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }

    @Override
    public List<FinancialRecord> getFinancialRecordsForDate(LocalDate recordDate) {
        List<FinancialRecord> records = new ArrayList<>();
        String query = "SELECT * FROM FinancialRecord WHERE RecordDate = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setDate(1, Date.valueOf(recordDate));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                records.add(extractFinancialRecordFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }
    

    
    private FinancialRecord extractFinancialRecordFromResultSet(ResultSet rs) throws SQLException {
        FinancialRecord record = new FinancialRecord();
        record.setRecordID(rs.getInt("RecordID"));
        record.setEmployeeID(rs.getInt("EmployeeID"));
        record.setRecordDate(rs.getDate("RecordDate").toLocalDate());
        record.setDescription(rs.getString("Description"));
        record.setAmount(rs.getDouble("Amount"));
        record.setRecordType(rs.getString("RecordType"));
        return record;
    }
}
