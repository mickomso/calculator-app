package com.technicaltest.calculator.util;

import io.corp.calculator.TracerImpl;
import org.springframework.stereotype.Service;

@Service
public class DefaultTracerLogger implements TracerLogger {

    private TracerImpl tracer;

    public DefaultTracerLogger() {
        this.tracer = new TracerImpl();
    }

    public TracerImpl getTracer() {
        return this.tracer == null ? new TracerImpl() : this.tracer;
    }

    @Override
    public void trace(String message) {
        this.getTracer().trace(message);
    }
}
