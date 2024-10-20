package com.hexaware.payxpert.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.hexaware.payxpert.dao.IFinancialRecordService;
import com.hexaware.payxpert.dao.FinancialRecordServiceImpl;
import com.hexaware.payxpert.entity.FinancialRecord;
import com.hexaware.payxpert.exception.FinancialRecordException;

import java.time.LocalDate;
import java.util.List;

public class FinancialRecordServiceTest {

    private IFinancialRecordService financialRecordService;

    @Before
    public void setup() {
        financialRecordService = new FinancialRecordServiceImpl();
    }

    @Test
    public void testAddAndGetFinancialRecord() {
        FinancialRecord record = new FinancialRecord(1, 1, LocalDate.of(2024, 9, 30), "Salary Payment", 9500.00, "Income");
        financialRecordService.addFinancialRecord(record);

        FinancialRecord retrievedRecord = financialRecordService.getFinancialRecordById(record.getRecordID());
        assertNotNull(retrievedRecord);
        assertEquals(record.getDescription(), retrievedRecord.getDescription());
        assertEquals(record.getAmount(), retrievedRecord.getAmount(), 0.001);
    }

    @Test
    public void testGetFinancialRecordsForEmployee() {
        int employeeId = 1;
        List<FinancialRecord> records = financialRecordService.getFinancialRecordsForEmployee(employeeId);
        assertFalse(records.isEmpty());
        for (FinancialRecord record : records) {
            assertEquals(employeeId, record.getEmployeeID());
        }
    }

    @Test
    public void testGetFinancialRecordsForDate() {
        LocalDate testDate = LocalDate.now();
        List<FinancialRecord> records = financialRecordService.getFinancialRecordsForDate(testDate);
        for (FinancialRecord record : records) {
            assertEquals(testDate, record.getRecordDate());
        }
    }

}
