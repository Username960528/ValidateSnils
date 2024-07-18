package org.example.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.example.SnilsValidator;

public class SnilsValidatorTest {
    @Test
    void testValidSnilsLessThan100() {
        assertEquals(true, SnilsValidator.validateSnils("112-233-445 95"));
    }

    @Test
    void testValidSnilsEqual100() {
        assertEquals(true, SnilsValidator.validateSnils("087-654-303 00"));
    }

    @Test
    void testValidSnilsEqual101() {
        assertEquals(true, SnilsValidator.validateSnils("021-006-999 00"));
    }

    @Test
    void testValidSnilsAtMaximum() {
        assertEquals(true, SnilsValidator.validateSnils("999-999-999 01"));
    }

    @Test
    void testValidSnilsWithAdditionalDigits() {
        assertEquals(true, SnilsValidator.validateSnils("112-233-445-95-000"));
    }

    @Test
    void testValidSnilsWithoutSeparators() {
        assertEquals(true, SnilsValidator.validateSnils("11223344595"));
    }

    @Test
    void testValidSnilsWithSpaces() {
        assertEquals(true, SnilsValidator.validateSnils("112 233 445 95"));
    }

    @Test
    void testInvalidSnilsWithOneDigitError() {
        assertEquals(false, SnilsValidator.validateSnils("087-654-302 00"));
    }

    @Test
    void testInvalidSnilsWithSwappedDigits() {
        assertEquals(false, SnilsValidator.validateSnils("086-754-303 00"));
    }

    @Test
    void testInvalidSnilsAboveMaximum() {
        assertEquals(false, SnilsValidator.validateSnils("999-999-999 99"));
    }

    @Test
    void testInvalidSnilsWithLessThan11Digits() {
        assertEquals(false, SnilsValidator.validateSnils("112-233-445"));
    }

    @Test
    void testInvalidSnilsWithLeadingZeros() {
        assertEquals(false, SnilsValidator.validateSnils("001-001-998 00"));
    }

    @Test
    void testInvalidSnilsWithNull() {
        assertEquals(false, SnilsValidator.validateSnils(null));
    }

    @Test
    void testInvalidSnilsWithLetters() {
        assertEquals(false, SnilsValidator.validateSnils("abrakadabra"));
    }

    @Test
    void testEmptyString() {
        assertEquals(false, SnilsValidator.validateSnils(""));
    }
    @Test
    void testVeryLongString() {
        assertEquals(true, SnilsValidator.validateSnils("112-233-445 95" + "0".repeat(1000)));
    }

    @Test
    void testInvalidSnilsWithSpecialCharacters() {
        assertEquals(false, SnilsValidator.validateSnils("«%*@#$^*()»"));
    }
}