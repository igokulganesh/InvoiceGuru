package com.invoiceguru.backend.services.party;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.invoiceguru.backend.services.address.Address;
import com.invoiceguru.backend.services.company.Company;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Party {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @Column(name = "outstanding_amount", precision = 15, scale = 2)
    private BigDecimal outstandingAmount;

    @Column(length = 15, nullable = true)
    private String gstin;

    @Column(name = "gst_type")
    @Enumerated(value = EnumType.STRING)
    private GstType gstType;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    // Constructors
    public Party() {
        this.gstType = GstType.unregistered;
        this.role = Role.Both;
    }

    public Party(Long id, String name, Role role, Address address, BigDecimal outstandingAmount, String gstin,
            GstType gstType, Company company) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.address = address;
        this.outstandingAmount = outstandingAmount;
        this.gstin = gstin;
        this.gstType = gstType;
        this.company = company;
    }

    // Enums
    public enum GstType {
        registered,
        unregistered,
        Consumer
    }

    public enum Role {
        Customer,
        Supplier,
        Both,
    }

    @Override
    public String toString() {
        return "Party [id=" + id + ", name=" + name + ", role=" + role + ", address=" + address + ", outstandingAmount="
                + outstandingAmount + ", gstin=" + gstin + ", gstType=" + gstType + "]";
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public BigDecimal getOutstandingAmount() {
        return outstandingAmount;
    }

    public void setOutstandingAmount(BigDecimal outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }

    public String getGstin() {
        return gstin;
    }

    public void setGstin(String gstin) {
        this.gstin = gstin;
    }

    public GstType getGstType() {
        return gstType;
    }

    public void setGstType(GstType gstType) {
        this.gstType = gstType;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
