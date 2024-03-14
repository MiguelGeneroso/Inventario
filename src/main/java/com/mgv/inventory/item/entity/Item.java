package com.mgv.inventory.item.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "items")
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "description", nullable = true, length = 250)
    private String description;

    @Column(name = "is_stolen", nullable = false, columnDefinition = "boolean default false")
    private Boolean isStolen = false;
}
