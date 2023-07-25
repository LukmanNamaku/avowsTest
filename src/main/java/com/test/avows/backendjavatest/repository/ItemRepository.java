package com.test.avows.backendjavatest.repository;

import com.test.avows.backendjavatest.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @Project backendjavatest
 * @Package com.test.avows.backendjavatest.repository
 * @Author Lukman A, email : lukman.ardie@gmail.com - PC:rapid
 * @Create 25-Jul-23
 */

public interface ItemRepository  extends JpaRepository<Item, Integer> {
    @Query(value = "SELECT * FROM item t", nativeQuery = true)
    List<Item> getAllItemsNative();
    Item findTopByItemId(Integer itemId);

}
