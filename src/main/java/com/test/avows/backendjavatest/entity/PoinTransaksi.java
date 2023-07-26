package com.test.avows.backendjavatest.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @Project backendjavatest
 * @Package com.test.avows.backendjavatest.entity
 * @Author Lukman A, email : lukman.ardie@gmail.com - PC:rapid
 * @Create 26-Jul-23
 */

@Data
@Entity
@Table(name = "t_poin")
public class PoinTransaksi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private Integer accountId;

    @Column(nullable = false)
    @ColumnDefault("0")
    private Integer TotPoin;
    
}
