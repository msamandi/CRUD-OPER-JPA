package com.travisperkins.jobmanager.model;

import java.util.Date;
import java.util.List;

/**
 * Created by sverma on 27/02/2017.
 */
public class Job {
    private int id;

    private List<JobSpec> jobSpecs;

    private List<Invoice> invoices;

    private Date created;

    private TPContractor contractor;

    private TPClient client;

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

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public TPContractor getContractor() {
        return contractor;
    }

    public void setContractor(TPContractor contractor) {
        this.contractor = contractor;
    }

    public TPClient getClient() {
        return client;
    }

    public void setClient(TPClient client) {
        this.client = client;
    }
}
