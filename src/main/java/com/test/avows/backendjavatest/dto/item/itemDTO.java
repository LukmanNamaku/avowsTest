package com.test.avows.backendjavatest.dto.item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Project backendjavatest
 * @Package com.test.avows.backendjavatest.dto.item
 * @Author Lukman A, email : lukman.ardie@gmail.com - PC:rapid
 * @Create 25-Jul-23
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class itemDTO {
    private Long itemId;
    private String titleItem;
    private String text;
    
}
