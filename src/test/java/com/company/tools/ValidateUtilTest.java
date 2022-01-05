package com.company.tools;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidateUtilTest {

    @Test
    @DisplayName("Test positive case for validate name")
    void testValidateNameShouldReturnTrue() {
        assertTrue(ValidateUtil.validateName("ross mary"));
    }

    @Test
    @DisplayName("Test negative case for validate name")
    void testValidateNameShouldReturnFalse() {
        assertFalse(ValidateUtil.validateName("ross mary12"));
        assertFalse(ValidateUtil.validateName("12ross mary"));
        assertFalse(ValidateUtil.validateName("ross 12 mary"));

    }
}
