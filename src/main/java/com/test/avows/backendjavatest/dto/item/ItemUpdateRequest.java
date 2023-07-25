package com.test.avows.backendjavatest.dto.item;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Project backendjavatest
 * @Package com.test.avows.backendjavatest.dto.item
 * @Author Lukman A, email : lukman.ardie@gmail.com - PC:rapid
 * @Create 25-Jul-23
 */

@Data
public class ItemUpdateRequest {
    @NotNull(message = "error.id-tidak-boleh-kosong")
    private Integer itemId;

    @NotBlank
    @NotNull(message = "error.title-tidak-boleh-kosong")
    private String titleItem;

    private String text;
}
