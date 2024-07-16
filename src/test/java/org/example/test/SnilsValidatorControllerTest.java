package org.example.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class SnilsValidatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testValidateSnilsEndpoint() throws Exception {
        mockMvc.perform(get("/api/v1/validateSnils?snils=112-233-445-95"))
                .andExpect(status().isOk())
                .andExpect(content().string("Корректный"));
    }
}