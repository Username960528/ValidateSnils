package org.example.test;

public class SnilsValidatorTest {
    @Test
    void testValidSnils() {
        assertEquals("Корректный", SnilsValidator.validateSnils("112-233-445-95"));
    }
}
