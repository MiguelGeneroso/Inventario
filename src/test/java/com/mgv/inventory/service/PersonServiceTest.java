package com.mgv.inventory.service;

import com.mgv.inventory.entity.Person;
import com.mgv.inventory.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @InjectMocks
    private PersonService personService;

    @Mock
    private PersonRepository personRepository;

    @Test
    public void testGetPersons() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person());
        personList.add(new Person());
        personList.add(new Person());

        when(personRepository.findAll()).thenReturn(personList);

        List<Person> result = personService.getPersons();
        assertEquals(3,result.size());
    }

    @Test
    public void testGetPersonById(){
        String dni = "12345678Z";
        Person newPerson = new Person();

        when(personRepository.findPersonByDni(dni)).thenReturn(newPerson);

        Person resultPerson = personService.getPersonByDNI(dni);

        assertNotNull(resultPerson);
        assertEquals(newPerson, resultPerson);
    }

    @Test
    public void testGetPersonByDniNull(){
        String id = "12345678H";

        Person resultPerson = personService.getPersonByDNI(id);

        assertNull(resultPerson);
    }

    @Test
    public void testCreatePerson(){
        Person person = new Person();
        person.setDni("12345678Z");
        person.setName("Pedro");
        person.setSurname("Garcia Garcia");

        when(personRepository.save(person)).thenReturn(person);

        Person resultPerson = personService.createPerson(person);

        assertNotNull(resultPerson);
        assertEquals(person,resultPerson);
    }

    @Test
    public void testCreatePersons(){
        List<Person> personList = new ArrayList<>();
        Person person1 = mock(Person.class);
        Person person2 = mock(Person.class);
        Person person3 = mock(Person.class);

        when(person1.getDni()).thenReturn("12345678Z");
        when(person2.getDni()).thenReturn("98765432M");
        when(person3.getDni()).thenReturn("87654321X");

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);

        when(personRepository.saveAll(personList)).thenReturn(personList);

        List<Person> resultPerson = personService.createPersons(personList);

        assertEquals(personList, resultPerson);
    }

    @Test
    public void testUpdatePerson(){

        String dni = "12345678Z";
        Person updatePerson = new Person();
        updatePerson.setDni(dni);
        updatePerson.setName("Pedro");
        updatePerson.setSurname("Garcia Garcia");

        Person existingPerson = new Person();
        existingPerson.setDni(dni);

        when(personRepository.findPersonByDni(dni)).thenReturn(existingPerson);

        Person resultUpdatedPerson = personService.updatePerson(updatePerson, dni);

        assertEquals("12345678Z", resultUpdatedPerson.getDni());
        assertEquals("Pedro", resultUpdatedPerson.getName());
        assertEquals("Garcia Garcia", resultUpdatedPerson.getSurname());

    }

    /*TODO: MODIFICAR VARIAS PERSONAS ARRAY LIST*/

    @Test
    public void testDeletePerson(){
        String dni = "12345678Z";
        Person deletePerson = new Person();
        deletePerson.setDni(dni);

        when(personRepository.findPersonByDni(dni)).thenReturn(deletePerson);

        Person resultPerson = personService.deletePerson(dni);

        verify(personRepository, times(1)).deleteById(dni);

        assertEquals(dni, resultPerson.getDni());
    }
    /*TODO: BORRAR VARIAS PERSONAS ARRAY LIST*/
}
