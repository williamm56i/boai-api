package org.boai.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
@Slf4j
public class BoaiExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity<String> exceptionHandler(Exception e) {
        e.printStackTrace();
        log.error("ExceptionHandler: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

    @ExceptionHandler(value = ResponseStatusException.class)
    @ResponseBody
    public ResponseEntity<String> responseStatusExceptionHandler(Exception e) {
        e.printStackTrace();
        log.error("responseStatusExceptionHandler: {}", e.getMessage());
        if (HttpStatus.UNAUTHORIZED.toString().equals(e.getMessage())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        } else if (HttpStatus.FORBIDDEN.toString().equals(e.getMessage())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}
