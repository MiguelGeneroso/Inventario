package com.mgv.inventory.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "person_item")
@Data
public class PersonItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "id_person", nullable = false, length = 9)
    private String idPerson;

    @Column(name = "id_item", nullable = false, length = 36)
    private String idItem;

}
