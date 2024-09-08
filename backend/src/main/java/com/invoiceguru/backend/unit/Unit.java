package com.invoiceguru.backend.unit;

import com.invoiceguru.backend.company.Company;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/* Unit of Measurements */
@Entity
public class Unit {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;
    private Boolean isWhole;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = true)
    private Company company;

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

    public Unit(Long id, String name, Boolean isWhole, Company company) {
        this.id = id;
        this.name = name;
        this.isWhole = isWhole;
        this.company = company;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
