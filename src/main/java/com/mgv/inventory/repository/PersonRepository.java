package com.mgv.inventory.repository;

import com.mgv.inventory.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,String> {
    public Person findPersonByDni(String dni);

}
