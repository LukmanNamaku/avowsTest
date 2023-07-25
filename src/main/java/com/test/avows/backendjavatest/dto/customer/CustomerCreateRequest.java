package com.test.avows.backendjavatest.dto.customer;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * @Project backendjavatest
 * @Package com.test.avows.backendjavatest.dto
 * @Author Lukman A, email : lukman.ardie@gmail.com - PC:rapid
 * @Create 25-Jul-23
 */

@Data
public class CustomerCreateRequest {

    @NotBlank
    @NotNull(message = "error.nama-menu-tidak-boleh-kosong")
    private String name;

    @NotBlank
    @NotNull(message = "error.full-nama-menu-tidak-boleh-kosong")
    private String fullName;

}
