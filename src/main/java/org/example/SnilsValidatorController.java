package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SnilsValidatorController {

    @GetMapping("/validate")
    public String validateSnils(@RequestParam String snils) {
        boolean isValid = SnilsValidator.validateSnils(snils);
        return isValid ? "Корректный" : "Некорректный";
    }
}
