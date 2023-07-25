package com.test.avows.backendjavatest.service.impl;

import com.test.avows.backendjavatest.dto.Transaksi.TransaksiDTO;
import com.test.avows.backendjavatest.dto.Transaksi.TransaksiNewRequest;
import com.test.avows.backendjavatest.dto.Transaksi.TransaksiUpdateRequest;
import com.test.avows.backendjavatest.entity.Customer;
import com.test.avows.backendjavatest.entity.Transaksi;
import com.test.avows.backendjavatest.handler.NotFoundException;
import com.test.avows.backendjavatest.repository.TransaksiRepository;
import com.test.avows.backendjavatest.service.TransaksiService;
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
public class TransaksiServiceImpl implements TransaksiService {

    @Autowired
    private TransaksiRepository transaksiRepository;
    
    @Override
    public List<Transaksi> getAll() {
        List<Transaksi> newTransactionList = transaksiRepository.findAll();
        return newTransactionList;
    }

    @Override
    public void create(TransaksiNewRequest createNewTransction) {
        Transaksi newTransaction = new Transaksi();
        BeanUtils.copyProperties(createNewTransction, newTransaction);
        transaksiRepository.save(newTransaction);
    }

    @Override
    public void update(TransaksiUpdateRequest createUpdateTransction) {
        Transaksi newTransaction = transaksiRepository.findTopByAccountId(createUpdateTransction.getIdTransaction());
        if (newTransaction == null){
            throw new NotFoundException("error.transaksi-tidak-ditemukan");
        }
        BeanUtils.copyProperties(createUpdateTransction, newTransaction);
        transaksiRepository.save(newTransaction);
    }

    @Override
    public void delete(Integer id) {
        Transaksi newTransaction = transaksiRepository.findTopByAccountId(id);
        if (newTransaction == null){
            throw new NotFoundException("error.transaksi-id-tidak-ditemukan");
        }
        transaksiRepository.delete(newTransaction);
    }
}
