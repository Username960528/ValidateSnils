package org.example.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.example.SnilsValidator;

public class SnilsValidatorTest {
    @Test
    void testValidSnils() {
        assertEquals(true, SnilsValidator.validateSnils("112-233-445 95"));
    }
    @Test
    void testVeryLongString() {
        assertEquals(true, SnilsValidator.validateSnils("112-233-445 95" + "0".repeat(1000)));
    }
    @Test
    void testValidSnilsAtMaximum() {
        assertEquals(true, SnilsValidator.validateSnils("999-999-999 01"));
    }
    @Test
    void testInvalidSnilsAboveMaximum() {
        assertEquals(false, SnilsValidator.validateSnils("999-999-999 99"));
    }

    @Test
    void testInvalidSnilsWithIncorrectChecksum() {
        assertEquals(false, SnilsValidator.validateSnils("112-233-445 96"));
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
    void testEmptyString() {
        assertEquals(false, SnilsValidator.validateSnils(""));
    }
    @Test
    void testStringOfSpaces() {
        assertEquals(false, SnilsValidator.validateSnils("   "));
    }
    @Test
    void testSnilsWithLetters() {
        assertEquals(false, SnilsValidator.validateSnils("112-233-ABC 95"));
    }
    @Test
    void testSnilsWithoutSeparators() {
        assertEquals(true, SnilsValidator.validateSnils("11223344595"));
    }
    @Test
    void testSnilsWithDifferentSeparators() {
        assertEquals(true, SnilsValidator.validateSnils("112.233.445 95"));
    }
}

