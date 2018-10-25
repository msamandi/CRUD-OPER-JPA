package com.travisperkins.jobmanager.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by msamandi on 27/02/2017.
 */
@Entity
@Table(name = "JOB")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Task> tasks;

    @Column(name = "CREATED")
    private Date created;

    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn(name="CONTRACTOR_ID", unique= true)
    private TPContractor contractor;

    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn(name="CLIENT_ID", unique= true)
    private TPClient client;

    @Column(name = "NAME")
    private String name;

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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", tasks=" + tasks +
                ", created=" + created +
                ", contractor=" + contractor +
                ", client=" + client +
                ", name='" + name + '\'' +
                ", paymentTerms='" + paymentTerms + '\'' +
                ", vat=" + vat +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        if (vat != job.vat) return false;
        if (id != null ? !id.equals(job.id) : job.id != null) return false;
        if (tasks != null ? !tasks.equals(job.tasks) : job.tasks != null) return false;
        if (created != null ? !created.equals(job.created) : job.created != null) return false;
        if (contractor != null ? !contractor.equals(job.contractor) : job.contractor != null) return false;
        if (client != null ? !client.equals(job.client) : job.client != null) return false;
        if (name != null ? !name.equals(job.name) : job.name != null) return false;
        return paymentTerms != null ? paymentTerms.equals(job.paymentTerms) : job.paymentTerms == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tasks != null ? tasks.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (contractor != null ? contractor.hashCode() : 0);
        result = 31 * result + (client != null ? client.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (paymentTerms != null ? paymentTerms.hashCode() : 0);
        result = 31 * result + vat;
        return result;
    }
}
