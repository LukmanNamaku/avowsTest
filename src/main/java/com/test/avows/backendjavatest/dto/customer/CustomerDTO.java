package com.test.avows.backendjavatest.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Project backendjavatest
 * @Package com.test.avows.backendjavatest.dto
 * @Author Lukman A, email : lukman.ardie@gmail.com - PC:rapid
 * @Create 25-Jul-23
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private Integer accountId;
    private String name;
    private String fullName;

}
