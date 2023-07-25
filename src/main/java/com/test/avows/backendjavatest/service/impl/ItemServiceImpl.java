package com.test.avows.backendjavatest.service.impl;

import com.test.avows.backendjavatest.dto.item.ItemCreateRequest;
import com.test.avows.backendjavatest.dto.item.ItemUpdateRequest;
import com.test.avows.backendjavatest.entity.Item;
import com.test.avows.backendjavatest.handler.NotFoundException;
import com.test.avows.backendjavatest.repository.ItemRepository;
import com.test.avows.backendjavatest.service.ItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

/**
 * @Project backendjavatest
 * @Package com.test.avows.backendjavatest.service.impl
 * @Author Lukman A, email : lukman.ardie@gmail.com - PC:rapid
 * @Create 25-Jul-23
 */

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @PersistenceContext
    private EntityManager entityManager;

//    public interface CarRepository extends JpaRepository<TRace, String> {
//        @Query(nativeQuery = true,
//                value = "select *" +
//                        "from car_records" +
//                        "where carVinNo = ?1 and carSerialNo >= ?2")
//    }
//    List<Car> retrieveCars(Long vinNo, Long serialNo); }

    @Override
    public List<Item> getAllItemsNative() {
        List<Item> newItemList = itemRepository.getAllItemsNative();
        return newItemList;
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> newItemList = itemRepository.findAll();
        return newItemList;
    }

    @Override
    public void create(ItemCreateRequest itemCreateRequest) {
        Item newItem = new Item();
        BeanUtils.copyProperties(itemCreateRequest, newItem);
        itemRepository.save(newItem);
    }

    @Override
    public void update(ItemUpdateRequest itemUpdateRequest) {
        Item newItem = itemRepository.findTopByItemId(itemUpdateRequest.getItemId());
        if (newItem == null){
            throw new NotFoundException("error.item-tidak-ditemukan");
        }
        BeanUtils.copyProperties(itemUpdateRequest, newItem);
        itemRepository.save(newItem);
    }

    @Override
    public void delete(Integer id) {
        Item newItem = itemRepository.findTopByItemId(id);
        if (newItem == null){
            throw new NotFoundException("error.Item-id-tidak-ditemukan");
        }
        itemRepository.delete(newItem);
    }
}
