package com.mgv.inventory.person.service;

import com.mgv.inventory.person.entity.Person;
import com.mgv.inventory.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

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

    public Person createPerson(Person person) {
        boolean validDNI = validateDNI(person.getDni());

        if (!validDNI) {
            throw new IllegalArgumentException("Invalid DNI");
        }

        Person existingPerson = personRepository.findPersonByDni(person.getDni());
        if (existingPerson != null) {
            return null;
        }

        return personRepository.save(person);
    }

    public List<Person> createPersons(List<Person> persons) {
        List<Person> newPersons = new ArrayList<>();

        for (Person person : persons) {
            boolean validDNI = validateDNI(person.getDni());
            if (!validDNI) {
                throw new IllegalArgumentException("Invalid DNI");
            }

            Person existingPerson = personRepository.findPersonByDni(person.getDni());
            if (existingPerson == null) {
                newPersons.add(person);
            }
        }

        if (!newPersons.isEmpty()) {
            return personRepository.saveAll(newPersons);
        } else {
            return Collections.emptyList();
        }
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

    public List<Person> updatePersons(List<Person> persons) {
        List<Person> updatePerson = new ArrayList<Person>();

        for (Person originalPerson : persons) {
            Person person = personRepository.findPersonByDni(originalPerson.getDni());

            if (person != null) {
                person.setName(originalPerson.getName());
                person.setSurname(originalPerson.getSurname());
            }

            updatePerson.add(person);
        }

        personRepository.saveAll(updatePerson);
        return updatePerson;
    }

    public Person deletePerson(String dni){
        Person person = personRepository.findPersonByDni(dni);

        if(person != null){
            personRepository.deleteById(dni);
        }
        return person;
    }

    public List<Person> deletePersons(List<Person> persons){
        List<Person> deletePerson = new ArrayList<Person>();

        for(Person originalPerson : persons){
            Person person = personRepository.findPersonByDni(originalPerson.getDni());

            if(person != null){
               deletePerson.add(person);
                personRepository.deleteById(person.getDni());
            }

        }

        return deletePerson;
    }

    private boolean validateDNI(String dni) {
        dni = dni.trim().toUpperCase();

        if (!dni.matches("\\d{8}[A-HJ-NP-TV-Z]")) {
            return false;
        }

        String number = dni.substring(0, 8);
        char letter = dni.charAt(8);

        char expectedLetter = calculateDNILetter(Integer.parseInt(number));

        return letter == expectedLetter;
    }

    private char calculateDNILetter(int dniNumber) {
        String letters = "TRWAGMYFPDXBNJZSQVHLCKE";
        return letters.charAt(dniNumber % 23);
    }
}
