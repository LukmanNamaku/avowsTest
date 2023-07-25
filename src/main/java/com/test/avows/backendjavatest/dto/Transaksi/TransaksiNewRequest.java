package com.test.avows.backendjavatest.dto.Transaksi;

import lombok.Data;

import java.util.Date;

/**
 * @Project backendjavatest
 * @Package com.test.avows.backendjavatest.dto.Transaksi
 * @Author Lukman A, email : lukman.ardie@gmail.com - PC:rapid
 * @Create 25-Jul-23
 */

@Data
public class TransaksiNewRequest {
    private Integer accountId;
    private String description;
    private Long amount;
    private Date transactionDate;
    private String debitCreditStatus;

}
