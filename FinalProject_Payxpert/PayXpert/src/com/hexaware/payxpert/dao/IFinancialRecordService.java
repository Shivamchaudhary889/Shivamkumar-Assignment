package com.hexaware.payxpert.dao;

import com.hexaware.payxpert.entity.FinancialRecord;

import java.time.LocalDate;
import java.util.List;

public interface IFinancialRecordService {
    void addFinancialRecord(FinancialRecord record);
    FinancialRecord getFinancialRecordById(int recordId);
    List<FinancialRecord> getFinancialRecordsForEmployee(int employeeId);
    List<FinancialRecord> getFinancialRecordsForDate(LocalDate recordDate);
}
