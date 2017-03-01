package com.travisperkins.jobmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by sverma on 27/02/2017.
 */
@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Long address;

    private String phone;

    private String email;

    private Long paymentDetails;

    private Long companyDetails;

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

    public Long getAddress() {
        return address;
    }

    public void setAddress(Long address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(Long paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public Long getCompanyDetails() {
        return companyDetails;
    }

    public void setCompanyDetails(Long companyDetails) {
        this.companyDetails = companyDetails;
    }
}
