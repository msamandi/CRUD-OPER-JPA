package com.travisperkins.jobmanager.model;

import javax.persistence.*;

/**
 * Created by sverma on 27/02/2017.
 */
@Entity
@Table(name = "ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "LINE1")
    private String line1;

    @Column(name = "LINE2")
    private String line2;

    @Column(name = "POSTCODE")
    private String postcode;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "COUNTY")
    private String county;

    @Column(name = "CITY")
    private String city;

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", line1='" + line1 + '\'' +
                ", line2='" + line2 + '\'' +
                ", postcode='" + postcode + '\'' +
                ", country='" + country + '\'' +
                ", county='" + county + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (id != null ? !id.equals(address.id) : address.id != null) return false;
        if (line1 != null ? !line1.equals(address.line1) : address.line1 != null) return false;
        if (line2 != null ? !line2.equals(address.line2) : address.line2 != null) return false;
        if (postcode != null ? !postcode.equals(address.postcode) : address.postcode != null) return false;
        if (country != null ? !country.equals(address.country) : address.country != null) return false;
        if (county != null ? !county.equals(address.county) : address.county != null) return false;
        return city != null ? city.equals(address.city) : address.city == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (line1 != null ? line1.hashCode() : 0);
        result = 31 * result + (line2 != null ? line2.hashCode() : 0);
        result = 31 * result + (postcode != null ? postcode.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (county != null ? county.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
