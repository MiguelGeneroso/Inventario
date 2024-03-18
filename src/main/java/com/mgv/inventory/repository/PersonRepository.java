package com.mgv.inventory.repository;

import com.mgv.inventory.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,String> {
    public Person findPersonByDni(String dni);

}
