package com.test.avows.backendjavatest.controller;

import com.test.avows.backendjavatest.dto.Transaksi.TransaksiNewRequest;
import com.test.avows.backendjavatest.entity.Transaksi;
import com.test.avows.backendjavatest.service.TransaksiService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Project backendjavatest
 * @Package com.test.avows.backendjavatest.controller
 * @Author Lukman A, email : lukman.ardie@gmail.com - PC:rapid
 * @Create 25-Jul-23
 */

@RestController
@RequestMapping("/api/managed-transaksi")
public class ManagedTransactionController {

    @Autowired
    private TransaksiService transaksiService;

    @ApiOperation("Get All Data Transaction")
    @GetMapping
    List<Transaksi> getAllConsumers(){
        List<Transaksi> transaksiList = transaksiService.getAll();
        return transaksiList;
    }

    @ApiOperation("Create New Transaksi")
    @PostMapping
    ResponseEntity create(@RequestBody TransaksiNewRequest transaksiCreateRequest) {
        transaksiService.create(transaksiCreateRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    
}
