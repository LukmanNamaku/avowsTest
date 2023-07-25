package com.test.avows.backendjavatest.service;

import java.util.List;

import com.test.avows.backendjavatest.entity.Customer;
import com.test.avows.backendjavatest.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Project backendjavatest
 * @Package com.test.avows.backendjavatest.entity
 * @Author Lukman A, email : lukman.ardie@gmail.com - PC:rapid
 * @Create 25-Jul-23
 *
 * **/

@Service
@Transactional
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public List<Customer> listAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    public Customer get(Integer id) {
        return customerRepository.findById(id).get();
    }

    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }

}