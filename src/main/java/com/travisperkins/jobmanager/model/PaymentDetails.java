package com.travisperkins.jobmanager.model;

import javax.persistence.*;

/**
 * Created by sverma on 27/02/2017.
 */
@Entity
@Table(name = "PAYMENT_DETAILS")
public class PaymentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "SORTCODE")
    private String sortCode;

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name = "ACCOUNT_HOLDER_NAME")
    private String accountHolderName;

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PaymentDetails{" +
                "id=" + id +
                ", sortCode='" + sortCode + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountHolderName='" + accountHolderName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaymentDetails that = (PaymentDetails) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (sortCode != null ? !sortCode.equals(that.sortCode) : that.sortCode != null) return false;
        if (accountNumber != null ? !accountNumber.equals(that.accountNumber) : that.accountNumber != null)
            return false;
        return accountHolderName != null ? accountHolderName.equals(that.accountHolderName) : that.accountHolderName == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (sortCode != null ? sortCode.hashCode() : 0);
        result = 31 * result + (accountNumber != null ? accountNumber.hashCode() : 0);
        result = 31 * result + (accountHolderName != null ? accountHolderName.hashCode() : 0);
        return result;
    }
}
