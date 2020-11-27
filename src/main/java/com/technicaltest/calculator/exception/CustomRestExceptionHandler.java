package com.technicaltest.calculator.exception;

import com.technicaltest.calculator.util.TracerLogger;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.METHOD_NOT_ALLOWED;

/**
 * Request handler for managing the API Rest exceptions
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

    private TracerLogger log;

    public CustomRestExceptionHandler(TracerLogger log) {
        this.log = log;
    }

    private ResponseEntity<Object> buildResponseEntity(RestApiError restApiError) {
        log.trace(restApiError.getDebugMessage());
        return new ResponseEntity<>(restApiError, restApiError.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        String error = "'" + ex.getParameterName() + "' parameter is missing";
        return buildResponseEntity(new RestApiError(BAD_REQUEST, error, ex));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        RestApiError restApiError = new RestApiError(BAD_REQUEST);
        restApiError.setMessage("Argument not valid.");
        restApiError.setDebugMessage(ex.getMessage());
        return buildResponseEntity(restApiError);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(
            NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        RestApiError restApiError = new RestApiError(BAD_REQUEST);
        restApiError.setMessage(String.format("Could not find the %s method for URL %s", ex.getHttpMethod(), ex.getRequestURL()));
        restApiError.setDebugMessage(ex.getMessage());
        return buildResponseEntity(restApiError);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        RestApiError restApiError = new RestApiError(METHOD_NOT_ALLOWED);
        restApiError.setMessage(ex.getMessage());
        restApiError.setDebugMessage(ex.getLocalizedMessage());
        return buildResponseEntity(restApiError);
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<Object> handleNumberFormatException(
            NumberFormatException ex) {
        RestApiError restApiError = new RestApiError(BAD_REQUEST);
        restApiError.setMessage(ex.getMessage());
        restApiError.setDebugMessage(ex.getLocalizedMessage());
        return buildResponseEntity(restApiError);
    }
}
