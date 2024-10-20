package com.hexaware.payxpert.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.hexaware.payxpert.dao.IPayrollService;
import com.hexaware.payxpert.dao.PayrollServiceImpl;
import com.hexaware.payxpert.entity.Employee;
import com.hexaware.payxpert.entity.Payroll;

import java.time.LocalDate;
import java.util.List;

public class PayrollServiceTest {

    private IPayrollService payrollService;

    @Before
    public void setup() {
        payrollService = new PayrollServiceImpl();
    }

    @Test
    public void testGeneratePayroll() {
        int employeeId = 1;
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 1, 31);
        
        payrollService.generatePayroll(employeeId, startDate, endDate);
        
        List<Payroll> payrolls = payrollService.getPayrollsForEmployee(employeeId);
        assertFalse(payrolls.isEmpty());
        
        Payroll generatedPayroll = payrolls.get(payrolls.size() - 1);
        assertEquals(startDate, generatedPayroll.getPayPeriodStartDate());
        assertEquals(endDate, generatedPayroll.getPayPeriodEndDate());
    }

    @Test
    public void testGetPayrollById() {
        // Make sure from database, payroll ID 1 exists
        int payrollId = 1;
        Payroll payroll = payrollService.getPayrollById(payrollId);
        assertNotNull(payroll);
        assertEquals(payrollId, payroll.getPayrollID());
    }

    @Test
    public void testGetPayrollsForPeriod() {
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);
        
        List<Payroll> payrolls = payrollService.getPayrollsForPeriod(startDate, endDate);
        assertFalse(payrolls.isEmpty());
        
        for (Payroll payroll : payrolls) {
            assertTrue(payroll.getPayPeriodStartDate().compareTo(startDate) >= 0);
            assertTrue(payroll.getPayPeriodEndDate().compareTo(endDate) <= 0);
        }
    }
}