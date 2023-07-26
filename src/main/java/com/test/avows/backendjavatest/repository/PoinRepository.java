package com.test.avows.backendjavatest.repository;

import com.test.avows.backendjavatest.entity.PoinTransaksi;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Project backendjavatest
 * @Package com.test.avows.backendjavatest.repository
 * @Author Lukman A, email : lukman.ardie@gmail.com - PC:rapid
 * @Create 26-Jul-23
 */


public interface PoinRepository extends JpaRepository<PoinTransaksi, Integer> {

    PoinTransaksi findTopByAccountId(Integer id);
    
}
