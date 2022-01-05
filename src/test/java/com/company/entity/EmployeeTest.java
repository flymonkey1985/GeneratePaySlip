package com.company.entity;

import com.company.exception.EmployeeException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {
    Employee employee;
    @BeforeEach
    void setUp() {
       employee = new Employee("Ross Mary", 60000d);
    }

    @Test
    @DisplayName("Test if employee constructor created")
    public void testIfEmployeeInstanceIsCreated() {
        assertNotNull(employee);
    }

    @Test
    @DisplayName("Test employee constructor with negative case")
    void testEmployeeConstructorWithNegativeCaseForName() {
        Exception exception = assertThrows(EmployeeException.class, () -> {
            new Employee("123 ross mary", 6000);
        });
        String expectedMessage = "Employee has invalid name : 123 ross mary";
        String actualMessage = exception.getMessage();


        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Test employee constructor with negative case")
    void testEmployeeConstructorWithNegativeCaseForSalary() {
        Exception exception = assertThrows(EmployeeException.class, () -> {
            new Employee("ross mary", -6000);
        });
        String expectedMessage = "Employee has invalid annual salary : $-6000";
        String actualMessage = exception.getMessage();


        assertTrue(actualMessage.contains(expectedMessage));
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
