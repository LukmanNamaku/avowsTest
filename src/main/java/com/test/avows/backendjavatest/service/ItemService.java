package com.test.avows.backendjavatest.service;

import com.test.avows.backendjavatest.dto.item.ItemCreateRequest;
import com.test.avows.backendjavatest.dto.item.ItemUpdateRequest;
import com.test.avows.backendjavatest.entity.Item;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project backendjavatest
 * @Package com.test.avows.backendjavatest.service
 * @Author Lukman A, email : lukman.ardie@gmail.com - PC:rapid
 * @Create 25-Jul-23
 */

@Service
public interface ItemService {
    List<Item> getAllItems();
    void create(ItemCreateRequest itemCreateRequest);
    void update(ItemUpdateRequest itemUpdateRequest);
    void delete(Integer id);
}
