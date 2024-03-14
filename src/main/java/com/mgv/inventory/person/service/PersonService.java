package com.mgv.inventory.person.service;

import com.mgv.inventory.person.entity.Person;
import com.mgv.inventory.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public Person getPersonByDNI(String dni){
        return personRepository.findPersonByDni(dni);
    }

    public List<Person> getPersons(){
        return personRepository.findAll();
    }

    public Person createPerson(Person person){
        return personRepository.save(person);
    }

    public List<Person> createPersons(List<Person> persons){
        return personRepository.saveAll(persons);
    }

    public Person updatePerson(Person person, String dni){
        Person updatePerson = personRepository.findPersonByDni(dni);

        if(updatePerson != null){
            updatePerson.setName(person.getName());
            updatePerson.setSurname(person.getSurname());

            personRepository.save(updatePerson);
        }

        return updatePerson;
    }

    public List<Person> updatePersons(List<Person> persons, String dni) {
        List<Person> updatePerson = new ArrayList<Person>();

        for (Person originalPerson : persons) {
            Person person = personRepository.findPersonByDni(originalPerson.getDni());

            if (person != null) {
                person.setName(originalPerson.getName());
                person.setSurname(originalPerson.getSurname());
            }

            updatePerson.add(person);
        }
        return updatePerson;
    }

    public Person deletePerson(String dni){
        Person person = personRepository.findPersonByDni(dni);

        if(person != null){
            personRepository.deleteByDni(dni);
        }
        return person;
    }

    /*TODO: falta borrar un array de personas*/
    public Person deletePersons(List<Person> persons){
        List<Person> deletePerson = new ArrayList<Person>();

        for(Person originalPerson : persons){
            Person person = personRepository.findPersonByDni(originalPerson.getDni());

            if(person != null){
                personRepository.deleteByDni(person.getDni());
            }

        }

        return null;
    }
}
