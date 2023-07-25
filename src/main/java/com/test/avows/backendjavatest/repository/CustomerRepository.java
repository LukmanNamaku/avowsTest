package com.test.avows.backendjavatest.repository;

import java.util.List;
import java.util.Optional;

import com.test.avows.backendjavatest.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Project backendjavatest
 * @Package com.test.avows.backendjavatest.entity
 * @Author Lukman A, email : lukman.ardie@gmail.com - PC:rapid
 * @Create 25-Jul-23
 */

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByAccountId(Integer accountId);
    Customer findTopByAccountId(Integer accountId);
    
}
