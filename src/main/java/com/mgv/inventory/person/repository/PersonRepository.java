package com.mgv.inventory.person.repository;

import com.mgv.inventory.person.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,String> {
    public Person findPersonByDni(String dni);
    public Person deleteByDni(String dni);

}
