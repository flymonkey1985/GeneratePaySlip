package com.company.entity;

import com.company.exception.PaySlipException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PaySlipTest {

    PaySlip paySlip;
    @BeforeEach
    void setUp() {
        paySlip = new PaySlip("Ross Mary", 60000d, 200d);
    }

    @Test
    @DisplayName("Test if payslip constructor created")
    public void testIfEmployeeInstanceIsCreated() {
        assertNotNull(paySlip);
    }

    @Test
    @DisplayName("Test payslip constructor with negative case")
    void testEmployeeConstructorWithNegativeCaseForMonthlyIncome() {
        Exception exception = assertThrows(PaySlipException.class, () -> {
            new PaySlip("ross mary", -6000d, 500d);
        });
        String expectedMessage = "Monthly Income is negative : $-6000";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Test payslip constructor with negative case")
    void testEmployeeConstructorWithNegativeCaseForMonthlyTax() {
        Exception exception = assertThrows(PaySlipException.class, () -> {
            new PaySlip("ross mary", 6000d, -500d);
        });
        String expectedMessage = "Monthly Tax is negative : $-500";
        String actualMessage = exception.getMessage();


        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Test payslip constructor with negative case")
    void testEmployeeConstructorWithNegativeCaseForMonthlyNetIncome() {
        Exception exception = assertThrows(PaySlipException.class, () -> {
            new PaySlip("ross mary", 200d, 500d);
        });
        String expectedMessage = "Monthly Net Income is negative : $-300";
        String actualMessage = exception.getMessage();


        assertTrue(actualMessage.contains(expectedMessage));
    }



}
