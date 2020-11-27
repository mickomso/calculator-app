package com.technicaltest.calculator.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Class used for saving relevant information about errors that happen during REST calls.
 */
@Data
public class RestApiError {

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;

    public RestApiError() {
        timestamp = LocalDateTime.now(ZoneId.of("Europe/Madrid"));
    }

    public RestApiError(HttpStatus status) {
        this();
        this.status = status;
    }

    public RestApiError(HttpStatus status, String message, Throwable ex) {
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }
}
