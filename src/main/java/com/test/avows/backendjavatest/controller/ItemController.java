package com.test.avows.backendjavatest.controller;

import com.test.avows.backendjavatest.dto.item.ItemCreateRequest;
import com.test.avows.backendjavatest.dto.item.ItemUpdateRequest;
import com.test.avows.backendjavatest.entity.Item;
import com.test.avows.backendjavatest.service.ItemService;
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
 * @Package com.test.avows.backendjavatest.controller
 * @Author Lukman A, email : lukman.ardie@gmail.com - PC:rapid
 * @Create 25-Jul-23
 */

@Controller
@RequestMapping("/api/managed-item")
public class ItemController {
    
    @Autowired
    private ItemService itemService;

    @ApiOperation("Get All Data Items")
    @GetMapping
    public ResponseEntity<Object> getAllItemsNative() {
        List<Item> newItemList = itemService.getAllItems();
        List<HashMap> entities = new ArrayList<>();
        for (Item itemData : newItemList) {
            HashMap<String, String> entity = new HashMap<>();
            entity.put("titleItem", itemData.getTitleItem());
            entity.put("text", itemData.getText());
            entities.add(entity);
        }
        return new ResponseEntity<Object>(entities, HttpStatus.OK);
    }

    @ApiOperation("Create New Item")
    @PostMapping
    ResponseEntity create(@RequestBody ItemCreateRequest itemCreateRequest) {
        itemService.create(itemCreateRequest);
        return new ResponseEntity(HttpStatus.CREATED);
        
    }

    @ApiOperation("Update Data Item")
    @PatchMapping
    ResponseEntity update(@RequestBody ItemUpdateRequest itemUpdateRequest) {
        itemService.update(itemUpdateRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation("Delete Data Item")
    @DeleteMapping("/{id}")
    ResponseEntity delete(@PathVariable Integer id) {
        itemService.delete(id);
        return new ResponseEntity(HttpStatus.OK);

    }
    
}
