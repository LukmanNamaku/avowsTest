package com.test.avows.backendjavatest.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Project backendjavatest
 * @Package com.test.avows.backendjavatest.entity
 * @Author Lukman A, email : lukman.ardie@gmail.com - PC:rapid
 * @Create 25-Jul-23
 */

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;
    private String name;
    private String fullName;

}
