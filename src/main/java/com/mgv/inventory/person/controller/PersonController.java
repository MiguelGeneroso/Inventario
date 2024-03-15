package com.mgv.inventory.person.controller;

import com.mgv.inventory.person.entity.Person;
import com.mgv.inventory.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/persons/{dni}")
    public ResponseEntity<Person> getPerson(@PathVariable String dni){
        Person person = personService.getPersonByDNI(dni);

        return ResponseEntity.ok(person);
    }

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getPersons(){
        List<Person> persons = personService.getPersons();

        return  ResponseEntity.ok(persons);
    }

    @PostMapping("/person")
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        Person newPerson = personService.createPerson(person);

        return ResponseEntity.ok(newPerson);
    }

    @PostMapping("/persons")
    public ResponseEntity<List<Person>> createPersons(@RequestBody List<Person> persons){
        List<Person> newPersons = personService.createPersons(persons);

        return ResponseEntity.ok(newPersons);
    }

    @PutMapping("/person/{dni}")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person, @PathVariable String dni){
        Person updatePerson = personService.updatePerson(person, dni);

        return ResponseEntity.ok(updatePerson);
    }

    @PutMapping("/persons")
    public ResponseEntity<List<Person>> updatePersons(@RequestBody List<Person> person){
        List<Person> updatePersons = personService.updatePersons(person);

        return ResponseEntity.ok(updatePersons);
    }

    @DeleteMapping("/persons/{dni}")
    public ResponseEntity<Person> deletePerson(@PathVariable String dni){
        Person person = personService.deletePerson(dni);

        return ResponseEntity.ok(person);
    }

    @DeleteMapping("/persons")
    public ResponseEntity<List<Person>> deletePersons(@RequestBody List<Person> persons){
        List<Person> personList = personService.deletePersons(persons);

        return  ResponseEntity.ok(personList);
    }
}
