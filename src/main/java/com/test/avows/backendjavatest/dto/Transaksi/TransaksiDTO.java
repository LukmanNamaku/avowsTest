package com.test.avows.backendjavatest.dto.Transaksi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Project backendjavatest
 * @Package com.test.avows.backendjavatest.dto.Transaksi
 * @Author Lukman A, email : lukman.ardie@gmail.com - PC:rapid
 * @Create 25-Jul-23
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransaksiDTO {

    private Integer idTransaction;
    private Integer accountId;
    private String name;
    private String description;
    private Long amount;
    private String debitCreditStatus;

    
}
