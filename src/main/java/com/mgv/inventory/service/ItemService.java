package com.mgv.inventory.service;

import com.mgv.inventory.entity.Item;
import com.mgv.inventory.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public List<Item> getItems(){
        return itemRepository.findAll();
    }

    public Item getItemById(String id){
        return itemRepository.findById(id).orElse(null);
    }

    public Item createItem(Item item){
        return itemRepository.save(item);
    }

    public List<Item> createItems(List<Item> items){
        return itemRepository.saveAll(items);
    }

    public Item updateItem(Item updateItem, String id){
        Item item = itemRepository.findById(id).orElse(null);

        if(item != null){
            item.setName(updateItem.getName());
            item.setDescription(updateItem.getDescription());
            item.setIsStolen(updateItem.getIsStolen());

            itemRepository.save(item);
        }
        return item;
    }

    public Item deleteItem(String id){
        Item item = itemRepository.findById(id).orElse(null);

        if(item != null){
            itemRepository.deleteById(id);
        }
        return item;
    }
}
