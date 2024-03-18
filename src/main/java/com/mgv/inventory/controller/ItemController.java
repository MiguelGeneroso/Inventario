package com.mgv.inventory.controller;

import com.mgv.inventory.entity.Item;
import com.mgv.inventory.service.ItemService;
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

    @PostMapping("/item")
    public ResponseEntity<Item> createItem(@RequestBody Item item){
        Item newItem = itemService.createItem(item);
        return ResponseEntity.ok(newItem);
    }

    @PostMapping("/items")
    public ResponseEntity<List<Item>> createItems(@RequestBody List<Item> items){
        List<Item> newItems = itemService.createItems(items);
        return ResponseEntity.ok(newItems);
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

    @GetMapping("/persons/{dni}/items")
    public ResponseEntity<List<Item>> getItemsByDni(@PathVariable String dni){
        List<Item> items = itemService.getItemsByDni(dni);
        return ResponseEntity.ok(items);
    }
}
