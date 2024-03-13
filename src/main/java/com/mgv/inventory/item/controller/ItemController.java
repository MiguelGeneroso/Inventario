package com.mgv.inventory.item.controller;

import com.mgv.inventory.item.entity.Item;
import com.mgv.inventory.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getItems(){
        List<Item> itemList = itemService.getItems();
        return ResponseEntity.ok(itemList);
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable String id){
        Item item = itemService.getItemById(id);
        return ResponseEntity.ok(item);
    }

    @PostMapping("/items")
    public ResponseEntity<List<Item>> createItem(@RequestBody List<Item> items){
        List<Item> newItem = itemService.createItem(items);
        return ResponseEntity.ok(newItem);
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<Item> updateItem(@RequestBody Item item, @PathVariable String id){
        Item updateItem = itemService.updateItem(item, id);
        return ResponseEntity.ok(updateItem);
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<Item> deleteItem(@PathVariable String id){
        Item deleteItem = itemService.deleteItem(id);
        return ResponseEntity.ok(deleteItem);
    }
}
