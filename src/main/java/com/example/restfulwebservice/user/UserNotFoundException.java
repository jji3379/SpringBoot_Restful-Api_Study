package com.example.restfulwebservice.user;

// HTTP Status code
// 2XX -> OK
// 4XX -> Client 잘못
// 5XX -> Server 문제

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
