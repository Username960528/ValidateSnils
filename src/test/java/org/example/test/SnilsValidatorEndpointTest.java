package org.example.test;

import org.example.ValidateSnilsRequest;
import org.example.ValidateSnilsResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Test
    void testValidateSnilsEndpoint() {
        ValidateSnilsRequest request = new ValidateSnilsRequest();
        request.setSnils("112-233-445-95");

        ValidateSnilsResponse response = (ValidateSnilsResponse) webServiceTemplate.marshalSendAndReceive(request);

        assertEquals("Корректный", response.getResult());
    }
}