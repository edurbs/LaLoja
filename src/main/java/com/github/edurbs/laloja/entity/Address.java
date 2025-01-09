package com.github.edurbs.laloja.entity;

import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@JmixEntity
@Embeddable
public class Address {
    @Pattern(message = "O CEP precisa estar no formato 12345-123", regexp = "^\\d{5}-\\d{3}$")
    @Column(name = "ZIP_CODE", length = 9)
    private String zipCode;
    @Column(name = "STREET")
    private String street;
    @Column(name = "NUMBER_", length = 50)
    private String number;
    @Column(name = "COMPLEMENT")
    private String complement;
    @Column(name = "NEIGHBORHOOD")
    private String neighborhood;
    @Column(name = "CITY")
    private String city;
    @Size(message = "Digite a sigla do estado. Por exemplo: MG", min = 2, max = 2)
    @Column(name = "STATE")
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}