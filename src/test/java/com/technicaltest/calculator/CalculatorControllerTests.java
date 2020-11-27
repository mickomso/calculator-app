package com.technicaltest.calculator;

import com.technicaltest.calculator.controller.CalculatorController;
import com.technicaltest.calculator.service.AdditionOperationService;
import com.technicaltest.calculator.service.SubtractOperationService;
import com.technicaltest.calculator.util.TracerLogger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("<== Calculator Controller Tests ==>")
@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CalculatorController calculatorController;

    @MockBean
    private TracerLogger tracerLogger;

    @MockBean
    private AdditionOperationService additionOperationService;

    @MockBean
    private SubtractOperationService subtractOperationService;

    @Test
    @DisplayName("Loads calculator controller context")
    void contextLoads() {
        assertNotNull(calculatorController);
        assertNotNull(mockMvc);
    }

    @Test
    @DisplayName("Resolves add numbers call")
    public void testAddNumbers() throws Exception {
        mockMvc.perform(get("/api/v1/calculator/addition?number1=55&number2=6"))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    @DisplayName("Resolves add numbers call")
    public void testSubtractNumbers() throws Exception {
        mockMvc.perform(get("/api/v1/calculator/subtract?number1=55&number2=6"))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    @DisplayName("Missing parameter returns exception")
    public void testMissingParameter() throws Exception {
        mockMvc.perform(get("/api/v1/calculator/addition?number1=55"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Wrong parameter format returns exception")
    public void testWrongParameterFormat() throws Exception {
        mockMvc.perform(get("/api/v1/calculator/addition?number1=L&number=2"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Wrong Http method returns exception")
    public void testWrongHttpMethod() throws Exception {
        mockMvc.perform(post("/api/v1/calculator/addition?number1=L&number=2"))
                .andExpect(status().isMethodNotAllowed());
    }
}
