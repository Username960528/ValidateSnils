package org.example;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SnilsValidatorEndpoint {

    private static final String NAMESPACE_URI = "http://example.org/snils";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "validateSnilsRequest")
    @ResponsePayload
    public ValidateSnilsResponse validateSnils(@RequestPayload ValidateSnilsRequest request) {
        ValidateSnilsResponse response = new ValidateSnilsResponse();
        boolean isValid = SnilsValidator.validateSnils(request.getSnils());
        response.setResult(isValid ? "Корректный" : "Некорректный");
        return response;
    }
}