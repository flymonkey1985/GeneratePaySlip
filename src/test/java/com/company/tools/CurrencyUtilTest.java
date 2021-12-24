package com.company.tools;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CurrencyUtilTest {
    @Test
    @DisplayName("Test convert value with scale")
    void testConvertValueWithScale() {

        assertEquals(3.26, CurrencyUtil.convertValueWithScale(3.25674, 2));
        assertEquals(3.25, CurrencyUtil.convertValueWithScale(3.25374, 2));

        assertNotEquals(3.26, CurrencyUtil.convertValueWithScale(3.25374, 2));
    }

    @Test
    @DisplayName("Test display value as currency")
    void testDisplayValueAsCurrency() {
        assertEquals("$23.56", CurrencyUtil.displayValueAsCurrency(23.56));
    }
}
