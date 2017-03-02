package com.travisperkins.jobmanager.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sverma on 27/02/2017.
 */
@Entity
@Table(name = "JOBSPEC")
public class JobSpec {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @OneToMany(mappedBy = "jobSpec", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Item> items;

    @Column(name = "CREATED")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date created;

    @Column(name = "ISQUOTEGENERATED")
    private boolean isQuoteGenerated;

    @Column(name = "QUOTECREATED")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date quoteCreated;

    @Column(name = "UPDATED")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOB_ID")
    private Job job;

    @Column(name = "PAYMENT_TERMS")
    private String paymentTerms;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isQuoteGenerated() {
        return isQuoteGenerated;
    }

    public void setQuoteGenerated(boolean quoteGenerated) {
        isQuoteGenerated = quoteGenerated;
    }

    public Date getQuoteCreated() {
        return quoteCreated;
    }

    public void setQuoteCreated(Date quoteCreated) {
        this.quoteCreated = quoteCreated;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    @Override
    public String toString() {
        return "JobSpec{" +
                "id=" + id +
                ", items=" + items +
                ", created=" + created +
                ", isQuoteGenerated=" + isQuoteGenerated +
                ", quoteCreated=" + quoteCreated +
                ", updated=" + updated +
                ", job=" + job +
                ", paymentTerms='" + paymentTerms + '\'' +
                '}';
    }
}
