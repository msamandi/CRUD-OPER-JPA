package com.travisperkins.jobmanager.model;

import java.math.BigDecimal;

/**
 * Created by sverma on 27/02/2017.
 */
public class Price {
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
}
