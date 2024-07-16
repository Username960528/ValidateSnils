package org.example.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.example.SnilsValidator;

public class SnilsValidatorTest {
    @Test
    void testValidSnils() {
        boolean isValid = SnilsValidator.validateSnils("112-233-445-95");
        assertEquals(true, isValid);
    }
    @Test
    void testMinimumValidSnils() {
        boolean isValid = SnilsValidator.validateSnils("00100199901");
        assertEquals(true, isValid);
    }
    @Test
    void testJustBelowMinimumValidSnils() {
        boolean isValid = SnilsValidator.validateSnils("00100199900");
        assertEquals(false, isValid);
    }

    @Test
    void testMaximumValidSnils() {
        boolean isValid = SnilsValidator.validateSnils("99999999999");
        assertEquals(true, isValid);
    }

    @Test
    void testInvalidSnilsWithIncorrectChecksum() {
        boolean isValid = SnilsValidator.validateSnils("112-233-445-96");
        assertEquals(false, isValid);
    }

    @Test
    void testInvalidSnilsWithLessThan11Digits() {
        boolean isValid = SnilsValidator.validateSnils("112-233-445");
        assertEquals(false, isValid);
    }

    @Test
    void testInvalidSnilsWithMoreThan11Digits() {
        boolean isValid = SnilsValidator.validateSnils("112-233-445-95123");
        assertEquals(true, isValid);
    }

    @Test
    void testInvalidSnilsWithLeadingZeros() {
        boolean isValid = SnilsValidator.validateSnils("001-001-998-00");
        assertEquals(false, isValid);
    }
    @Test
    void testInvalidSnilsWithNull() {
        boolean isValid = SnilsValidator.validateSnils(null);
        assertEquals(false, isValid);
    }
}