package com.mgv.inventory.repository;

import com.mgv.inventory.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,String> {

    List<Item> getItemsByOwner(String owner);

    Item getItemById(String id);

}
