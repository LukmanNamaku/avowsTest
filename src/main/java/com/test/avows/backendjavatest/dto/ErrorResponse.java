package com.test.avows.backendjavatest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * @Project backendjavatest
 * @Package com.test.avows.backendjavatest.dto
 * @Author Lukman A, email : lukman.ardie@gmail.com - PC:rapid
 * @Create 25-Jul-23
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private int status;
    private Date timestamp;
    private String error;
    private String message;
    private String path;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String, String> details;

    public ErrorResponse(int status, String error, String message, HttpServletRequest request) {
        this.status = status;
        this.timestamp = new Date();
        this.error = error;
        this.message = message;
        this.path = request.getServletPath();
    }

}
