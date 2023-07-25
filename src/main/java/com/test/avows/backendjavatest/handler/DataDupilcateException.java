package com.test.avows.backendjavatest.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Project backendjavatest
 * @Package com.test.avows.backendjavatest.handler
 * @Author Lukman A, email : lukman.ardie@gmail.com - PC:rapid
 * @Create 25-Jul-23
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DataDupilcateException extends RuntimeException {
    public DataDupilcateException(String message) {
        super(message);
    }

    public DataDupilcateException(String message, Throwable cause) {
        super(message, cause);
    }


}
