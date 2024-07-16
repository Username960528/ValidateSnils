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
}