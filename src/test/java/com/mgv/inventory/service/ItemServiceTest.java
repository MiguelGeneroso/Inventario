package com.mgv.inventory.service;

import com.mgv.inventory.item.entity.Item;
import com.mgv.inventory.item.repository.ItemRepository;
import com.mgv.inventory.item.service.ItemService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {

    @InjectMocks
    private ItemService itemService;
    @Mock
    private ItemRepository itemRepository;

    @Test
    public void testGetItems() {
        List<Item> items = new ArrayList<>();
        items.add(new Item());
        items.add(new Item());
        items.add(new Item());

        when(itemRepository.findAll()).thenReturn(items);

        List<Item> result = itemService.getItems();
        assertEquals(3,result.size());
    }

    @Test
    public void testGetItemById(){
        Item item = new Item();

        String id = UUID.randomUUID().toString();

        when(itemRepository.findById(id)).thenReturn(item);

        Item resultItem = itemService.getItemById(id);

        assertEquals(item, resultItem);
    }
}
