package com.travisperkins.jobmanager.model;

import javax.persistence.*;
import java.util.ArrayList;
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

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<JobSpec> jobSpecs;

    @Column(name = "CREATED")
    private Date created;

    @Column(name = "CONTRACTOR")
    private Long contractor;

    @Column(name = "CLIENT")
    private Long client;

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

    public void setJobSpecs(ArrayList<JobSpec> jobSpecs) {
        this.jobSpecs = jobSpecs;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Long getContractor() {
        return contractor;
    }

    public void setContractor(Long contractor) {
        this.contractor = contractor;
    }

    public Long getClient() {
        return client;
    }

    public void setClient(Long client) {
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
