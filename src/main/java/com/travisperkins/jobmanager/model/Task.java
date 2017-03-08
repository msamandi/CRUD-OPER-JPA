package com.travisperkins.jobmanager.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by sverma on 27/02/2017.
 */
@Entity
@Table(name = "TASK")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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

    @Column(name = "VAT")
    private int vat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
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

    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (isQuoteGenerated != task.isQuoteGenerated) return false;
        if (vat != task.vat) return false;
        if (id != null ? !id.equals(task.id) : task.id != null) return false;
        if (name != null ? !name.equals(task.name) : task.name != null) return false;
        if (items != null ? !items.equals(task.items) : task.items != null) return false;
        if (created != null ? !created.equals(task.created) : task.created != null) return false;
        if (quoteCreated != null ? !quoteCreated.equals(task.quoteCreated) : task.quoteCreated != null) return false;
        if (updated != null ? !updated.equals(task.updated) : task.updated != null) return false;
        if (job != null ? !job.equals(task.job) : task.job != null) return false;
        return paymentTerms != null ? paymentTerms.equals(task.paymentTerms) : task.paymentTerms == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (items != null ? items.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (isQuoteGenerated ? 1 : 0);
        result = 31 * result + (quoteCreated != null ? quoteCreated.hashCode() : 0);
        result = 31 * result + (updated != null ? updated.hashCode() : 0);
        result = 31 * result + (job != null ? job.hashCode() : 0);
        result = 31 * result + (paymentTerms != null ? paymentTerms.hashCode() : 0);
        result = 31 * result + vat;
        return result;
    }
}
