package com.mgv.inventory.person.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "persons")
@Data
public class Person {
    @Id
    @Column(name = "dni", length = 9)
    private String dni;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "surnames", nullable = false, length = 50)
    private String surname;

}
