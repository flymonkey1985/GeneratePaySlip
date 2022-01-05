package com.company.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TaxTest {
    Tax tax;
    @BeforeEach
    void setUp() {
        tax = new Tax(20000, 0, 0.1, 200);
    }

    @Test
    @DisplayName("Test if tax constructor created")
    public void testIfEmployeeInstanceIsCreated() {
        assertNotNull(tax);
    }
}
