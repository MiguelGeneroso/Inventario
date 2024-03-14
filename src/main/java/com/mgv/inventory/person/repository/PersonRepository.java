package com.mgv.inventory.person.repository;

import com.mgv.inventory.person.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,String> {
    public Person findPersonByDni(String dni);
    public Person deleteByDni(String dni);
}
