package com.hexaware.payxpert.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.hexaware.payxpert.dao.ITaxService;
import com.hexaware.payxpert.dao.TaxServiceImpl;
import com.hexaware.payxpert.entity.Employee;
import com.hexaware.payxpert.entity.Tax;

import java.time.LocalDate;
import java.util.List;

public class TaxServiceTest {

    private ITaxService taxService;

    @Before
    public void setup() {
        taxService = new TaxServiceImpl();
    }

    @Test
    public void testCalculateTax() {
        int employeeId = 1;
        int taxYear = 2023;
        
        taxService.calculateTax(employeeId, taxYear);
        
        List<Tax> taxes = taxService.getTaxesForEmployee(employeeId);
        assertFalse(taxes.isEmpty());
        
        Tax calculatedTax = taxes.get(taxes.size() - 1);
        assertEquals(taxYear, calculatedTax.getTaxYear());
    }

    @Test
    public void testGetTaxById() {
        // Make sure from database tax record with ID 1 exists
        int taxId = 1;
        Tax tax = taxService.getTaxById(taxId);
        assertNotNull(tax);
        assertEquals(taxId, tax.getTaxID());
    }

    @Test
    public void testGetTaxesForYear() {
        int taxYear = 2023;
        List<Tax> taxes = taxService.getTaxesForYear(taxYear);
        assertFalse(taxes.isEmpty());
        
        for (Tax tax : taxes) {
            assertEquals(taxYear, tax.getTaxYear());
        }
    }
}
