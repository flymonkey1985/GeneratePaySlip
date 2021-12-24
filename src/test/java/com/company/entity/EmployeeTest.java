package com.company.entity;

import com.company.tools.CurrencyUtil;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class EmployeeTest {
    Employee employee;
    @BeforeEach
    void setUp() {
       employee = new Employee("Ross Mary", 60000d);
    }

    @Test
    @DisplayName("Test get name")
    void testGetName() {
        assertEquals("Ross Mary", employee.getName());

    }

    @AfterEach
    void destroy() {
       employee = null;
    }


}
