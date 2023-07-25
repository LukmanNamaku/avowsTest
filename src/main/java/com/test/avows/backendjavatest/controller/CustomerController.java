package com.test.avows.backendjavatest.controller;

import com.test.avows.backendjavatest.dto.customer.CustomerCreateRequest;
import com.test.avows.backendjavatest.dto.customer.CustomerUpdateRequest;
import com.test.avows.backendjavatest.entity.Customer;
import com.test.avows.backendjavatest.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Project backendjavatest
 * @Package com.test.avows.backendjavatest.entity
 * @Author Lukman A, email : lukman.ardie@gmail.com - PC:rapid
 * @Create 25-Jul-23
 */


@Controller
@RequestMapping("/api/managed-customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @ApiOperation("Get All Data Customer")
    @GetMapping
    public ResponseEntity<Object> getAllConsumers(){
//        List<Customer> customerList = customerService.getAllConsumers();
//        return customerService.getAllConsumer;

        List<Customer> customerList = customerService.getAllConsumers();
        List<HashMap> entities = new ArrayList<HashMap>();
        for (Customer n : customerList) {
            HashMap<String, String> entity = new HashMap<>();
            entity.put("name", n.getName());
            entity.put("fullName", n.getFullName());
            entities.add(entity);
        }
        return new ResponseEntity<Object>(entities, HttpStatus.OK);
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