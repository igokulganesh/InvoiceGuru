package com.invoicepro.backend.services.company;

import com.invoicepro.backend.services.address.Address;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Company {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @Column(unique = true, nullable = false, length = 15)
    private String gstin;

    public Company() {
    }

    public Company(Long id, String name, Address address, String gstin) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.gstin = gstin;
    }

    @Override
    public String toString() {
        return "Company [id=" + id + ", name=" + name + ", address_id=" + address + ", gstin=" + gstin + "]";
    }

    public Long getId() {
        return this.id;
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

    public Address getAddress_id() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getGstin() {
        return gstin;
    }

    public void setGstin(String gstin) {
        this.gstin = gstin;
    }
}
