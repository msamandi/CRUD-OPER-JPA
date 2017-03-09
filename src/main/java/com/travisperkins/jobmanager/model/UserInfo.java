package com.travisperkins.jobmanager.model;

import javax.persistence.*;

/**
 * Created by sverma on 27/02/2017.
 */
@Entity
@Table(name = "USERINFO")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn(name="ADDRESS_ID", unique= true)
    private Address address;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "EMAIL")
    private String email;

    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn(name="PAYMENT_DETAILS_ID", unique= true)
    private PaymentDetails paymentDetails;

    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn(name="COMPANY_DETAILS_ID", unique= true)
    private CompanyDetails companyDetails;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
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

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public CompanyDetails getCompanyDetails() {
        return companyDetails;
    }

    public void setCompanyDetails(CompanyDetails companyDetails) {
        this.companyDetails = companyDetails;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", paymentDetails=" + paymentDetails +
                ", companyDetails=" + companyDetails +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfo userInfo = (UserInfo) o;

        if (id != null ? !id.equals(userInfo.id) : userInfo.id != null) return false;
        if (name != null ? !name.equals(userInfo.name) : userInfo.name != null) return false;
        if (address != null ? !address.equals(userInfo.address) : userInfo.address != null) return false;
        if (phone != null ? !phone.equals(userInfo.phone) : userInfo.phone != null) return false;
        if (email != null ? !email.equals(userInfo.email) : userInfo.email != null) return false;
        if (paymentDetails != null ? !paymentDetails.equals(userInfo.paymentDetails) : userInfo.paymentDetails != null)
            return false;
        return companyDetails != null ? companyDetails.equals(userInfo.companyDetails) : userInfo.companyDetails == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (paymentDetails != null ? paymentDetails.hashCode() : 0);
        result = 31 * result + (companyDetails != null ? companyDetails.hashCode() : 0);
        return result;
    }
}
