package com.mystudy.exceptionHandler;

import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mystudy.model.ApiErrorResponse;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

 
  //private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

     @Override
     protected ResponseEntity<Object> handleMethodArgumentNotValid(
             MethodArgumentNotValidException methodArgumentNotValidException, HttpHeaders headers, HttpStatus status,
             WebRequest request) {
         String ERROR_MESSAGE = methodArgumentNotValidException.getMessage();
         try {
             ERROR_MESSAGE = methodArgumentNotValidException.getBindingResult().getFieldErrors().stream()
                     .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(", "));
         } catch (Exception e) {
             System.out.println("Error constructing error message "+ e);
         }

         System.out.println(ERROR_MESSAGE + methodArgumentNotValidException);
         ApiErrorResponse errorResponse = getErrorResponse(HttpStatus.BAD_REQUEST, ERROR_MESSAGE);
         return handleExceptionInternal(methodArgumentNotValidException, errorResponse, headers, HttpStatus.BAD_REQUEST,
                 request);
     }
     
     @ExceptionHandler(IllegalArgumentException.class)
     public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException exception,
                                                                  WebRequest webRequest) {
         final String ERROR_MESSAGE = exception.getMessage();
         System.out.println(ERROR_MESSAGE +  exception);
         ApiErrorResponse errorResponse = getErrorResponse(HttpStatus.BAD_REQUEST, ERROR_MESSAGE);
         return handleExceptionInternal(exception, errorResponse, new HttpHeaders(),
                 HttpStatus.BAD_REQUEST, webRequest);
     }

  
     @ExceptionHandler(Exception.class)
     public ResponseEntity<Object> handleAnyException(Exception exception, WebRequest webRequest) {
         final String ERROR_MESSAGE = exception.getMessage();
         exception.printStackTrace();
         ApiErrorResponse errorResponse = getErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ERROR_MESSAGE);
         return handleExceptionInternal(exception, errorResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR,
                 webRequest);
     }
     
     private ApiErrorResponse getErrorResponse(HttpStatus status, String errorMessage) {
         if (StringUtils.isEmpty(errorMessage)) {
             errorMessage = "An unexpected error occurred";
         }
         return new ApiErrorResponse(status.value(), status.name(), errorMessage);
     }
 
}