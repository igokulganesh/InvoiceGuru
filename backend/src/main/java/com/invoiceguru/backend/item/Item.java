package com.invoiceguru.backend.item;

import java.math.BigDecimal;

import com.invoiceguru.backend.company.Company;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Item {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private Purpose purpose;

    @Column(precision = 10, scale = 2)
    private BigDecimal rate;

    @Column(name = "hsn_code")
    private String hsnCode;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    // Enums
    public enum Purpose {
        Purchases,
        Sales,
        Both
    }
}
