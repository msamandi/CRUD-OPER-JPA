package com.travisperkins.jobmanager.model;

import java.util.Date;
import java.util.List;

/**
 * Created by sverma on 27/02/2017.
 */
public class Invoice {
    private int id;

    private List<JobSpec> jobSpecs;

    private Date created;

    private Price invoiceValue;

    private Job job;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<JobSpec> getJobSpecs() {
        return jobSpecs;
    }

    public void setJobSpecs(List<JobSpec> jobSpecs) {
        this.jobSpecs = jobSpecs;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Price getInvoiceValue() {
        return invoiceValue;
    }

    public void setInvoiceValue(Price invoiceValue) {
        this.invoiceValue = invoiceValue;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
