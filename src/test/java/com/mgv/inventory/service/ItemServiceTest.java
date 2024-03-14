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
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
        String id = UUID.randomUUID().toString();
        Item newItem = new Item();
        Optional<Item> item = Optional.of(newItem);

        when(itemRepository.findById(id)).thenReturn(item);

        Item resultItem = itemService.getItemById(id);

        assertNotNull(resultItem);
        assertEquals(newItem, resultItem);
    }

    @Test
    public void testGetItemByIdNull(){
        String id = UUID.randomUUID().toString();

        Item resultItem = itemService.getItemById(id);

        assertNull(resultItem);
    }

    @Test
    public void testCreateItem(){
        Item item = new Item();
        item.setName("Pala");
        item.setDescription("Descripción de una pala");

        when(itemRepository.save(item)).thenReturn(item);

        Item resultItem = itemService.createItem(item);

        assertNotNull(resultItem);
        assertEquals(item,resultItem);
    }

    @Test
    public void testCreateItems(){
        List<Item> items = new ArrayList<Item>();
        items.add(new Item());
        items.add(new Item());
        items.add(new Item());

        when(itemRepository.saveAll(items)).thenReturn(items);

        List<Item> resultItems = itemService.createItems(items);

        assertEquals(items, resultItems);
    }

    @Test
    public void testUpdateItem(){

        String id = UUID.randomUUID().toString();
        Item updateItem = new Item();
        updateItem.setName("Pala");
        updateItem.setDescription("Descripción de una pala");

        Item existingItem = new Item();
        existingItem.setId(id);

        when(itemRepository.findById(id)).thenReturn(Optional.of(existingItem));

        Item resultUpdatedItem = itemService.updateItem(updateItem, id);

        assertEquals("Pala", resultUpdatedItem.getName());
        assertEquals("Descripción de una pala", resultUpdatedItem.getDescription());
        assertEquals(false, resultUpdatedItem.getIsStolen());

    }

    /*@Test
    public void testDeleteItem(){
        String id = UUID.randomUUID().toString();
        Item deleteItem = new Item();
        deleteItem.setId(id);

        when(itemRepository.findById(id)).thenReturn(Optional.of(deleteItem));

        Item resultItem = itemService.deleteItem(id);

        verify(itemRepository, times(1)).deleteById(id);

        assertEquals(id, resultItem.getId());
    }*/
}
