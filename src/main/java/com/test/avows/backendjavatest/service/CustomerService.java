package com.test.avows.backendjavatest.service;

import java.util.List;

import com.test.avows.backendjavatest.dto.customer.CustomerCreateRequest;
import com.test.avows.backendjavatest.dto.customer.CustomerUpdateRequest;
import com.test.avows.backendjavatest.entity.Customer;
import org.springframework.stereotype.Service;

/**
 * @Project backendjavatest
 * @Package com.test.avows.backendjavatest.entity
 * @Author Lukman A, email : lukman.ardie@gmail.com - PC:rapid
 * @Create 25-Jul-23
 *
 * **/

@Service
public interface CustomerService {

    List<Customer>getAllConsumers();
    void create(CustomerCreateRequest createRequest);
    void update(CustomerUpdateRequest updateRequest);
    void delete(Integer id);

}