package com.invoiceguru.backend.tax;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Tax {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @Column(precision = 5, scale = 2)
    private BigDecimal rate;

    // Constructors
    public Tax() {
    }

    public Tax(Long id, String name, BigDecimal rate) {
        this.id = id;
        this.name = name;
        this.rate = rate;
    }

    public Tax(String name, BigDecimal rate) {
        this.name = name;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Tax [id=" + id + ", name=" + name + ", rate=" + rate + "]";
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

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
