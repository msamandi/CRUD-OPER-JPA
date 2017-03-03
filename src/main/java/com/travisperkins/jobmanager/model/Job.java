package com.travisperkins.jobmanager.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by sverma on 27/02/2017.
 */
@Entity
@Table(name = "JOB")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<JobSpec> jobSpecs;

    @Column(name = "CREATED")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date created;

    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn(name="CONTRACTOR_ID", unique= true)
    private TPContractor contractor;

    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn(name="CLIENT_ID", unique= true)
    private TPClient client;

    @Column(name = "NAME")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", jobSpecs=" + jobSpecs +
                ", created=" + created +
                ", contractor=" + contractor +
                ", client=" + client +
                ", name='" + name + '\'' +
                '}';
    }
}
