package com.travisperkins.jobmanager.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by sverma on 27/02/2017.
 */
@Entity
public class Price {

    @Id
    private Long id;

    private String currency;

    private BigDecimal value;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", currency='" + currency + '\'' +
                ", value=" + value +
                '}';
    }
}
