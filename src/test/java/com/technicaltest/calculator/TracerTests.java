package com.technicaltest.calculator;

import com.technicaltest.calculator.util.DefaultTracerLogger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("<== Tracer library Tests ==>")
@SpringBootTest
public class TracerTests {

    @Autowired
    private DefaultTracerLogger log;

    @Test
    @DisplayName("Loads tracer logger context")
    public void contextLoads() {
        assertNotNull(log);
    }
}
