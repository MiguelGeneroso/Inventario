package com.mgv.inventory.item.repository;

import com.mgv.inventory.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,String> {


}
