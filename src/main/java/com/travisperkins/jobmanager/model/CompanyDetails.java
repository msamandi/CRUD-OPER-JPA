package com.travisperkins.jobmanager.model;

/**
 * Created by sverma on 27/02/2017.
 */
public class CompanyDetails {
    private String name;

    private Address address;

    private String vat;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }
}
