package com.test.avows.backendjavatest.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @Project backendjavatest
 * @Package com.test.avows.backendjavatest.entity
 * @Author Lukman A, email : lukman.ardie@gmail.com - PC:rapid
 * @Create 25-Jul-23
 */

@Data
@Entity
@Table(name = "trx_transaksi")
public class Transaksi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTransaction;

    private Integer accountId;
    private String description;
    private String debitCreditStatus;
    private Long amount;

    @Temporal(TemporalType.DATE)
    private Date transactionDate;

}
