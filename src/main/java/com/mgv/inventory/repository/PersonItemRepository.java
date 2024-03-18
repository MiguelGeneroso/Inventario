package com.mgv.inventory.repository;

import com.mgv.inventory.entity.PersonItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonItemRepository extends JpaRepository<PersonItem, Long> {

    public List<PersonItem> findPersonItemByIdPerson(String id);
    public PersonItem findPersonItemByIdItem(String id);
}
