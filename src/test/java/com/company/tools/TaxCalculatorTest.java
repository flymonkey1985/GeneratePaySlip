package com.company.tools;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TaxCalculatorTest {

    @Test
    @DisplayName("Test tax with annual salary below $20000")
    void testTaxForAnnualSalaryBelowTwentyThousand() {
        assertEquals(0, TaxCalculator.calculateMonthlyTax(20000));
    }

    @Test
    @DisplayName("Test tax with annual salary above $20000 and below $40000")
    void testTaxForAnnualSalaryAboveTwentyThousandAndBelowFortyThousand() {
        assertEquals(125, TaxCalculator.calculateMonthlyTax(35000));
    }

    @Test
    @DisplayName("Test tax with annual salary above $40000 and below $80000")
    void testTaxForAnnualSalaryAboveFortyThousandAndBelowEightyThousand() {
        assertEquals(800, TaxCalculator.calculateMonthlyTax(78000));
    }

    @Test
    @DisplayName("Test tax with annual salary above $80000 and below $180000")
    void testTaxForAnnualSalaryAboveEightyThousandAndBelowOneEightyThousand() {
        assertEquals(2033.33, TaxCalculator.calculateMonthlyTax(128000));
    }

    @Test
    @DisplayName("Test tax with annual salary above $180000")
    void testTaxForAnnualSalaryAboveOneEightyThousand() {
        assertEquals(3666.67, TaxCalculator.calculateMonthlyTax(190000));
    }

    @Test
    @DisplayName("Test tax with annual salary less than 0")
    void testTaxForLessThanZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            TaxCalculator.calculateMonthlyTax(-20);
        });
        String expectedMessage = "Invalid annual salary : -20";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
