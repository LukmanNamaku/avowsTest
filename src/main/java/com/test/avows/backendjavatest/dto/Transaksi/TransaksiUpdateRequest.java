package com.test.avows.backendjavatest.dto.Transaksi;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Project backendjavatest
 * @Package com.test.avows.backendjavatest.dto.Transaksi
 * @Author Lukman A, email : lukman.ardie@gmail.com - PC:rapid
 * @Create 25-Jul-23
 */

@Data
public class TransaksiUpdateRequest {
    @NotNull(message = "error.id-transaction-tidak-boleh-kosong")
    private Integer idTransaction;

    @NotBlank
    @NotNull(message = "error.id-account-tidak-boleh-kosong")
    private Integer accountId;

    @NotBlank
    @NotNull(message = "error.description-tidak-boleh-kosong")
    private String description;

    @NotBlank
    @NotNull(message = "error.amount-tidak-boleh-kosong")
    private Long amount;

    @NotBlank
    @NotNull(message = "error.status-tidak-boleh-kosong")
    private String debitCreditStatus;

}
