package com.test.avows.backendjavatest.repository;

import com.test.avows.backendjavatest.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Project backendjavatest
 * @Package com.test.avows.backendjavatest.repository
 * @Author Lukman A, email : lukman.ardie@gmail.com - PC:rapid
 * @Create 25-Jul-23
 */

@Repository
public interface ItemRepository  extends JpaRepository<Item, Integer> {
    Optional<Item> findByItemId(Integer itemId);
    Item findTopByItemId(Integer itemId);

}
