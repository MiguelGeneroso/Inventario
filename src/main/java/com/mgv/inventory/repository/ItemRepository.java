package com.mgv.inventory.repository;

import com.mgv.inventory.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,String> {


}
