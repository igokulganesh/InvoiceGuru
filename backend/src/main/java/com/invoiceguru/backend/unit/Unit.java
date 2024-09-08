package com.invoiceguru.backend.unit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/* Unit of Measurements */
@Entity
public class Unit {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;
    private Boolean isWhole;

    // Constructors
    public Unit() {
    }

    public Unit(Long id, String name, Boolean isWhole) {
        this.id = id;
        this.name = name;
        this.isWhole = isWhole;
    }

    public Unit(String name, Boolean isWhole) {
        this.name = name;
        this.isWhole = isWhole;
    }

    @Override
    public String toString() {
        return "Unit [id=" + id + ", name=" + name + ", isWhole=" + isWhole + "]";
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsWhole() {
        return isWhole;
    }

    public void setIsWhole(Boolean isWhole) {
        this.isWhole = isWhole;
    }
}
