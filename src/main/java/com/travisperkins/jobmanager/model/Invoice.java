package com.travisperkins.jobmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sverma on 27/02/2017.
 */
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private ArrayList<JobSpec> jobSpecs;

    private Date created;

    private Double invoiceValue;

    private Long job;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<JobSpec> getJobSpecs() {
        return jobSpecs;
    }

    public void setJobSpecs(ArrayList<JobSpec> jobSpecs) {
        this.jobSpecs = jobSpecs;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Double getInvoiceValue() {
        return invoiceValue;
    }

    public void setInvoiceValue(Double invoiceValue) {
        this.invoiceValue = invoiceValue;
    }

    public Long getJob() {
        return job;
    }

    public void setJob(Long job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", jobSpecs=" + jobSpecs +
                ", created=" + created +
                ", invoiceValue=" + invoiceValue +
                ", job=" + job +
                '}';
    }
}
