package com.invoiceguru.backend.item;

import java.math.BigDecimal;

import com.invoiceguru.backend.company.Company;
import com.invoiceguru.backend.tax.Tax;
import com.invoiceguru.backend.unit.Unit;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    private Unit unit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tax_id", referencedColumnName = "id")
    private Tax tax;

    // Enums
    public enum Purpose {
        Purchases,
        Sales,
        Both
    }

    public Item(Long id, String name, Purpose purpose, BigDecimal rate, String hsnCode, String description,
            Company company, Unit unit, Tax tax) {
        this.id = id;
        this.name = name;
        this.purpose = purpose;
        this.rate = rate;
        this.hsnCode = hsnCode;
        this.description = description;
        this.company = company;
        this.unit = unit;
        this.tax = tax;
    }

    public Item() {
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", name=" + name + ", purpose=" + purpose.name() + ", rate=" + rate + ", hsnCode="
                + hsnCode + ", description=" + description + ", company=" + company.getName() + ", unit="
                + unit.getName() + ", tax=" + tax.getName() + "]";
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

    public Purpose getPurpose() {
        return purpose;
    }

    public void setPurpose(Purpose purpose) {
        this.purpose = purpose;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getHsnCode() {
        return hsnCode;
    }

    public void setHsnCode(String hsnCode) {
        this.hsnCode = hsnCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

}
