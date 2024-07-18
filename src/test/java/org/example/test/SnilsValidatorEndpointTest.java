package org.example.test;

import org.example.SnilsValidatorApplication;
import org.example.ValidateSnilsRequest;
import org.example.ValidateSnilsResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.example.config.WebServiceConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = {SnilsValidatorApplication.class, WebServiceConfig.class})
public class SnilsValidatorEndpointTest {

    @LocalServerPort
    private int port;

    @Autowired
    private WebServiceTemplate webServiceTemplate;

    @BeforeEach
    public void setUp() {
        webServiceTemplate.setDefaultUri("http://localhost:" + port + "/ws");
    }

    private void validateSnils(String snils, String expectedResult) {
        ValidateSnilsRequest request = new ValidateSnilsRequest();
        request.setSnils(snils);

        ValidateSnilsResponse response = (ValidateSnilsResponse) webServiceTemplate.marshalSendAndReceive(request);

        assertEquals(expectedResult, response.getResult());
    }

    @Test
    void testValidSnilsLessThan100Endpoint() {
        validateSnils("112-233-445 95", "Корректный");
    }

    @Test
    void testValidSnilsEqual100Endpoint() {
        validateSnils("087-654-303 00", "Корректный");
    }

    @Test
    void testValidSnilsEqual101Endpoint() {
        validateSnils("021-006-999 00", "Корректный");
    }

    @Test
    void testValidSnilsAtMaximumEndpoint() {
        validateSnils("999-999-999 01", "Корректный");
    }

    @Test
    void testValidSnilsWithAdditionalDigitsEndpoint() {
        validateSnils("112-233-445-95-000", "Корректный");
    }

    @Test
    void testValidSnilsWithoutSeparatorsEndpoint() {
        validateSnils("11223344595", "Корректный");
    }

    @Test
    void testValidSnilsWithSpacesEndpoint() {
        validateSnils("112 233 445 95", "Корректный");
    }

    @Test
    void testInvalidSnilsWithOneDigitErrorEndpoint() {
        validateSnils("087-654-302 00", "Некорректный");
    }

    @Test
    void testInvalidSnilsWithSwappedDigitsEndpoint() {
        validateSnils("086-754-303 00", "Некорректный");
    }

    @Test
    void testInvalidSnilsAboveMaximumEndpoint() {
        validateSnils("999-999-999 99", "Некорректный");
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

    @Test
    void testInvalidSnilsWithLettersEndpoint() {
        validateSnils("abrakadabra", "Некорректный");
    }

    @Test
    void testEmptyStringEndpoint() {
        validateSnils("", "Некорректный");
    }

    @Test
    void testVeryLongStringEndpoint() {
        validateSnils("112-233-445 95" + "0".repeat(1000), "Корректный");
    }

    @Test
    void testInvalidSnilsWithSpecialCharactersEndpoint() {
        validateSnils("«%*@#$^*()»", "Некорректный");
    }
}