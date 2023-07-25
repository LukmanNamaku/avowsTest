package com.test.avows.backendjavatest.service.impl;

import com.test.avows.backendjavatest.dto.customer.CustomerCreateRequest;
import com.test.avows.backendjavatest.dto.customer.CustomerUpdateRequest;
import com.test.avows.backendjavatest.entity.Customer;
import com.test.avows.backendjavatest.handler.NotFoundException;
import com.test.avows.backendjavatest.repository.CustomerRepository;
import com.test.avows.backendjavatest.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project backendjavatest
 * @Package com.test.avows.backendjavatest.service.impl
 * @Author Lukman A, email : lukman.ardie@gmail.com - PC:rapid
 * @Create 25-Jul-23
 */

@Service
public class CustomerServiceImpl implements CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllConsumers() {
        List<Customer> newCustomerList = customerRepository.findAll();
        return newCustomerList;
    }

    @Override
    public void create(CustomerCreateRequest createRequest) {
        Customer newCustomer = new Customer();
        BeanUtils.copyProperties(createRequest, newCustomer);
        customerRepository.save(newCustomer);

    }

    @Override
    public void update(CustomerUpdateRequest updateRequest) {
        Customer newCustomer = customerRepository.findTopByAccountId(updateRequest.getAccountId());
        if (newCustomer == null){
            throw new NotFoundException("error.nasabah-tidak-ditemukan");
        }
        BeanUtils.copyProperties(updateRequest, newCustomer);
        customerRepository.save(newCustomer);

    }

    @Override
    public void delete(Integer id) {
        Customer newCustomer = customerRepository.findTopByAccountId(id);
        if (newCustomer == null){
            throw new NotFoundException("error.nasabah-id-tidak-ditemukan");
        }
        customerRepository.delete(newCustomer);

    }
}
