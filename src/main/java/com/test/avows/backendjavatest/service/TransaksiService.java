package com.test.avows.backendjavatest.service;

import com.test.avows.backendjavatest.dto.Transaksi.TransaksiNewRequest;
import com.test.avows.backendjavatest.dto.Transaksi.TransaksiUpdateRequest;
import com.test.avows.backendjavatest.entity.Transaksi;

import java.util.List;

/**
 * @Project backendjavatest
 * @Package com.test.avows.backendjavatest.service
 * @Author Lukman A, email : lukman.ardie@gmail.com - PC:rapid
 * @Create 25-Jul-23
 */


public interface TransaksiService {

    List<Transaksi> getAll();
    void create(TransaksiNewRequest createNewTransction);
    void update(TransaksiUpdateRequest createUpdateTransction);
    void delete(Integer id);
    
}
