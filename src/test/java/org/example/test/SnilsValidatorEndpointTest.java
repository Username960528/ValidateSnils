package org.example.test;

import org.example.ValidateSnilsRequest;
import org.example.ValidateSnilsResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.example.config.WebServiceConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ContextConfiguration(classes = {WebServiceConfig.class})
public class SnilsValidatorEndpointTest {

    @Autowired
    private WebServiceTemplate webServiceTemplate;

    private void validateSnils(String snils, String expectedResult) {
        ValidateSnilsRequest request = new ValidateSnilsRequest();
        request.setSnils(snils);

        ValidateSnilsResponse response = (ValidateSnilsResponse) webServiceTemplate.marshalSendAndReceive(request);

        assertEquals(expectedResult, response.getResult());
    }

    @Test
    void testValidSnilsEndpoint() {
        validateSnils("112-233-445 95", "Корректный");
    }

    @Test
    void testValidSnilsAtMaximumEndpoint() {
        validateSnils("999-999-999 01", "Корректный");
    }

    @Test
    void testValidSnilsWithExtraDigitsEndpoint() {
        validateSnils("112-233-445-95-000", "Корректный");
    }

    @Test
    void testInvalidSnilsAboveMaximumEndpoint() {
        validateSnils("999-999-999 99", "Некорректный");
    }

    @Test
    void testInvalidSnilsWithIncorrectChecksumEndpoint() {
        validateSnils("112-233-445 96", "Некорректный");
    }

    @Test
    void testInvalidSnilsWithLessThan11DigitsEndpoint() {
        validateSnils("112-233-445", "Некорректный");
    }

    @Test
    void testInvalidSnilsWithLeadingZerosEndpoint() {
        validateSnils("001-001-998 00", "Некорректный");
    }

    @Test
    void testInvalidSnilsWithNullEndpoint() {
        validateSnils(null, "Некорректный");
    }
    void testInvalidSnilsWithWords() {
        validateSnils("abrakadabra", "Неккоректный");
    }
}