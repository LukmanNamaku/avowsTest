package com.test.avows.backendjavatest.controller;

import com.test.avows.backendjavatest.dto.customer.CustomerCreateRequest;
import com.test.avows.backendjavatest.dto.customer.CustomerDTO;
import com.test.avows.backendjavatest.dto.customer.CustomerUpdateRequest;
import com.test.avows.backendjavatest.entity.Customer;
import com.test.avows.backendjavatest.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Project backendjavatest
 * @Package com.test.avows.backendjavatest.entity
 * @Author Lukman A, email : lukman.ardie@gmail.com - PC:rapid
 * @Create 25-Jul-23
 */


@RestController
@RequestMapping("/api/managed-customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @ApiOperation("Get All Data Customer")
    @GetMapping("/")
    public ResponseEntity<List<CustomerDTO>> getAllConsumers(){
        List<CustomerDTO> customerList = customerService.getAllConsumers().stream().map(n -> {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setAccountId(n.getAccountId());
            customerDTO.setName(n.getName());
            customerDTO.setFullName(n.getFullName());
            return customerDTO;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(customerList);
    }

    @ApiOperation("Get All Data Customer")
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Integer id){
        Customer customer = customerService.findByAccountId(id);
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer, customerDTO);
        return ResponseEntity.ok(customerDTO);
    }

    @ApiOperation("Create New Customer")
    @PostMapping
    ResponseEntity create(@RequestBody CustomerCreateRequest createRequest) {
        customerService.create(createRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @ApiOperation("Update Data Customer")
    @PatchMapping
    ResponseEntity update(@RequestBody CustomerUpdateRequest updateRequest) {
        customerService.update(updateRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation("Delete Data Customer")
    @DeleteMapping("/{id}")
    ResponseEntity delete(@PathVariable Integer id) {
        customerService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}