package com.test.avows.backendjavatest.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Project backendjavatest
 * @Package com.test.avows.backendjavatest.handler
 * @Author Lukman A, email : lukman.ardie@gmail.com - PC:rapid
 * @Create 25-Jul-23
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(String.valueOf(message));
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
