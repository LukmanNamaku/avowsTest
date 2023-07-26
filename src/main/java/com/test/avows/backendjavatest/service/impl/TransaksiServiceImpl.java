package com.test.avows.backendjavatest.service.impl;

import com.test.avows.backendjavatest.dto.Transaksi.TransaksiNewRequest;
import com.test.avows.backendjavatest.entity.PoinTransaksi;
import com.test.avows.backendjavatest.entity.Transaksi;
import com.test.avows.backendjavatest.handler.NotFoundException;
import com.test.avows.backendjavatest.repository.PoinRepository;
import com.test.avows.backendjavatest.repository.TransaksiRepository;
import com.test.avows.backendjavatest.service.TransaksiService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private PoinRepository poinRepository;


    @Override
    public List<Transaksi> getAll() {
        List<Transaksi> newTransactionList = transaksiRepository.findAll();
        return newTransactionList;
    }

    @Override
    public List<Transaksi> getByAccountId(Integer accountId) {
//        List<Transaksi> dataTransaksi = poinRepository.findTopByAccountId(accountId);
//        return dataTransaksi;
        return null;
    }

    @Transactional
    @Override
    public void create(TransaksiNewRequest createNewTransction) {
        Transaksi newTransaksi = new Transaksi();
        BeanUtils.copyProperties(createNewTransction, newTransaksi);

        String descriptionU = newTransaksi.getDescription().toUpperCase();
        newTransaksi.setDescription(descriptionU);

        int nilaiTransaksiReal = (int)(long)newTransaksi.getAmount();
        int sisaPulsa1 = 0, sisaPulsa2 = 0, sisaPulsa3 = 0;
        int sisaListrik1 = 0, sisaListrik2 = 0, sisaListrik3 = 0;

        int poin1 = 0;
        int poin2 = 1;
        int poin3 = 2;

        PoinTransaksi newPointransaksi;
        int poin;
        int totPoinOld;
        int totPoinNew;

        int nilaiSP, nilaiSP2, nilaiSP3;
        int nilaiTR, nilaiTR2, nilaiTR3;
        
        switch(descriptionU) {
            case "BELI PULSA":
                //Jika Nilai Transaksi >= 0 atau Nilai Transaksi <= 10000
                if ((nilaiTransaksiReal >= 0 && nilaiTransaksiReal <= 10000) || nilaiTransaksiReal >= 0 || nilaiTransaksiReal <= 10000|| nilaiTransaksiReal == 10000 || nilaiTransaksiReal >= 10000) {
                    nilaiSP = nilaiTransaksiReal - 10000;
                    sisaPulsa1 = nilaiSP;

                    if (sisaPulsa1 < 0) {
                        poin = nilaiTransaksiReal/1000 * poin1;
                    } else {
                        poin = 10000/1000 * poin1;
                    }

                    newPointransaksi = poinRepository.findTopByAccountId(createNewTransction.getAccountId());
                    if (newPointransaksi == null) {
                        newPointransaksi = new PoinTransaksi();
                        newPointransaksi.setTotPoin(poin);
                    } else {
                        totPoinOld = newPointransaksi.getTotPoin();
                        totPoinNew = totPoinOld + poin;
                        newPointransaksi.setTotPoin(totPoinNew);
                    }

                    newPointransaksi.setAccountId(createNewTransction.getAccountId());
                    poinRepository.save(newPointransaksi);

                }
                
                //Jika Nilai Transaksi >= 10001 atau  Nilai Transaksi <= 30000 dan Nilai Transaksi == 30000 atau Nilai Transaksi >= 30000 
                if ((nilaiTransaksiReal >= 10001 && nilaiTransaksiReal <= 30000) || nilaiTransaksiReal >= 10001 || nilaiTransaksiReal <= 30000 || nilaiTransaksiReal == 30000){
                    nilaiSP2 = nilaiTransaksiReal - 10000;
                    sisaPulsa2 = nilaiSP2;

                    if (sisaPulsa2 != 0 && sisaPulsa2 <= 0){
                        poin = nilaiTransaksiReal/1000*poin1;
                    } else {
                        poin = 10000/1000*poin2;
                    }

                    newPointransaksi = poinRepository.findTopByAccountId(createNewTransction.getAccountId());
                    if(newPointransaksi == null){
                        newPointransaksi = new PoinTransaksi();
                        newPointransaksi.setTotPoin(poin);
                    } else {
                        totPoinOld = newPointransaksi.getTotPoin();
                        totPoinNew = totPoinOld + poin;
                        newPointransaksi.setTotPoin(totPoinNew);
                    }

                    newPointransaksi.setAccountId(createNewTransction.getAccountId());
                    poinRepository.save(newPointransaksi);
                }

                if (nilaiTransaksiReal > 30000){
                    nilaiSP3 = nilaiTransaksiReal - 30000;
                    sisaPulsa3 = nilaiSP3;
                    if(sisaPulsa3 < 0){
                        poin = nilaiTransaksiReal/1000*poin1;
                    } else {
                        poin = 30000/1000*poin3;    
                    }
                    
                    newPointransaksi = poinRepository.findTopByAccountId(createNewTransction.getAccountId());
                    if(newPointransaksi == null){
                        newPointransaksi = new PoinTransaksi();
                        newPointransaksi.setTotPoin(poin);
                    }else{
                        totPoinOld = newPointransaksi.getTotPoin();
                        totPoinNew = totPoinOld + poin;
                        newPointransaksi.setTotPoin(totPoinNew);
                    }

                    newPointransaksi.setAccountId(createNewTransction.getAccountId());
                    poinRepository.save(newPointransaksi);

                }
                break;
                
            case "BAYAR LISTRIK":
                if ((nilaiTransaksiReal >= 0 && nilaiTransaksiReal <= 50000) || nilaiTransaksiReal >= 0 || nilaiTransaksiReal <= 50000 ||nilaiTransaksiReal == 50000 || nilaiTransaksiReal >= 50000) {
                    nilaiTR = nilaiTransaksiReal-50000;
                    sisaListrik1 = nilaiTR;
                    if (sisaListrik1 != 0 && sisaListrik1 <= 0){
                        poin = nilaiTransaksiReal/2000*poin1;
                    }else{
                        poin = 50000/2000*poin1;
                    }

                    newPointransaksi = poinRepository.findTopByAccountId(createNewTransction.getAccountId());
                    if(newPointransaksi == null){
                        newPointransaksi = new PoinTransaksi();
                        newPointransaksi.setTotPoin(poin);
                    }else{
                        totPoinOld = newPointransaksi.getTotPoin();
                        totPoinNew = totPoinOld+poin;
                        newPointransaksi.setTotPoin(totPoinNew);
                    }

                    newPointransaksi.setAccountId(createNewTransction.getAccountId());
                    poinRepository.save(newPointransaksi);

                } 
                
                if ((nilaiTransaksiReal >= 50001 && nilaiTransaksiReal <= 100000) || nilaiTransaksiReal >= 50001 || nilaiTransaksiReal <= 100000 || nilaiTransaksiReal == 100000 || nilaiTransaksiReal >= 100000){
                    nilaiTR2 = nilaiTransaksiReal-50000;
                    sisaListrik2 = nilaiTR2;
                    if(sisaListrik2 < 0){
                        poin = nilaiTransaksiReal/2000*poin1;
                    } else {
                        poin = 50000/2000*poin2;
                    }

                    newPointransaksi = poinRepository.findTopByAccountId(createNewTransction.getAccountId());
                    if(newPointransaksi == null){
                        newPointransaksi = new PoinTransaksi();
                        newPointransaksi.setTotPoin(poin);
                    }else{
                        totPoinOld = newPointransaksi.getTotPoin();
                        totPoinNew = totPoinOld+poin;
                        newPointransaksi.setTotPoin(totPoinNew);
                    }

                    newPointransaksi.setAccountId(createNewTransction.getAccountId());
                    poinRepository.save(newPointransaksi);

                }

                if (nilaiTransaksiReal > 100000){
                    nilaiTR3 = nilaiTransaksiReal-100000;
                    sisaListrik3 = nilaiTR3;
                    if(sisaListrik3 < 0){
                        poin = sisaListrik3/2000*poin1;    
                    } else {
                        poin = 100000/2000*poin3;
                    }
                    
                    newPointransaksi = poinRepository.findTopByAccountId(createNewTransction.getAccountId());
                    if(newPointransaksi == null){
                        newPointransaksi = new PoinTransaksi();
                        newPointransaksi.setTotPoin(poin);
                    }else{
                        totPoinOld = newPointransaksi.getTotPoin();
                        totPoinNew = totPoinOld+poin;
                        newPointransaksi.setTotPoin(totPoinNew);
                    }

                    newPointransaksi.setAccountId(createNewTransction.getAccountId());
                    poinRepository.save(newPointransaksi);

                }
                break;
            default:
                throw new NotFoundException("error.jenis-transaksi-tidak-ditemukan");
        }
        
        transaksiRepository.save(newTransaksi);


    }

}
