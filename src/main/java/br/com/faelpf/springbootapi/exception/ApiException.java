package br.com.faelpf.springbootapi.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ApiException {
    
    private final String message;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp;

    public ApiException(String message,
                        HttpStatus httpStatus,
                        ZonedDateTime timestamp) {

        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;

    }

}
