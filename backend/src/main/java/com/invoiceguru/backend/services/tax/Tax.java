package com.invoiceguru.backend.services.tax;

import java.math.BigDecimal;

import com.invoiceguru.backend.services.company.Company;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Tax {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = true)
    private Company company;

    @Column(precision = 5, scale = 2)
    private BigDecimal rate;

    // Constructors
    public Tax() {
    }

    public Tax(Long id, String name, BigDecimal rate, Company company) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.rate = rate;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
