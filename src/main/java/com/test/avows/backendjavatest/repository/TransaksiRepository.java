package com.test.avows.backendjavatest.repository;

import com.test.avows.backendjavatest.entity.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @Project backendjavatest
 * @Package com.test.avows.backendjavatest.repository
 * @Author Lukman A, email : lukman.ardie@gmail.com - PC:rapid
 * @Create 25-Jul-23
 */

public interface TransaksiRepository extends JpaRepository<Transaksi, Integer> {
    Optional<Transaksi> findByAccountId(Integer transaksiId);
    Transaksi findTopByAccountId(Integer transaksiId);
    
}
