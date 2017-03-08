package com.travisperkins.jobmanager.representation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.travisperkins.jobmanager.model.TPClient;
import com.travisperkins.jobmanager.model.TPContractor;

import java.util.Date;
import java.util.List;

/**
 * Created by sverma on 27/02/2017.
 */
public class JobRepresentation {
    private Long id;

    private List<TaskRepresentation> tasks;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date created;

    private TPContractor contractor;

    private TPClient client;

    private String name;

    private String paymentTerms;

    private int vat;

    public JobRepresentation(JobRepresentationBuilder jobRepresentationBuilder) {
        this.id = jobRepresentationBuilder.id;
        this.name = jobRepresentationBuilder.name;
        this.created = jobRepresentationBuilder.created;
        this.tasks = jobRepresentationBuilder.tasks;
        this.contractor = jobRepresentationBuilder.contractor;
        this.client = jobRepresentationBuilder.client;
        this.paymentTerms = jobRepresentationBuilder.paymentTerms;
        this.vat = jobRepresentationBuilder.vat;
    }

    public JobRepresentation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TaskRepresentation> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskRepresentation> tasks) {
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

        JobRepresentation that = (JobRepresentation) o;

        if (vat != that.vat) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (tasks != null ? !tasks.equals(that.tasks) : that.tasks != null) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (contractor != null ? !contractor.equals(that.contractor) : that.contractor != null) return false;
        if (client != null ? !client.equals(that.client) : that.client != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return paymentTerms != null ? paymentTerms.equals(that.paymentTerms) : that.paymentTerms == null;
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

    public static class JobRepresentationBuilder {
        private Long id;

        private List<TaskRepresentation> tasks;

        private Date created;

        private TPContractor contractor;

        private TPClient client;

        private String name;

        private String paymentTerms;

        private int vat;

        public JobRepresentationBuilder(Long id) {
            this.id = id;
        }

        public JobRepresentation.JobRepresentationBuilder name(String name) {
            this.name = name;
            return this;
        }

        public JobRepresentation.JobRepresentationBuilder created(Date created) {
            this.created = created;
            return this;
        }

        public JobRepresentation.JobRepresentationBuilder tasks(List<TaskRepresentation> tasks) {
            this.tasks = tasks;
            return this;
        }

        public JobRepresentation.JobRepresentationBuilder contractor(TPContractor contractor) {
            this.contractor = contractor;
            return this;
        }

        public JobRepresentation.JobRepresentationBuilder client(TPClient client) {
            this.client = client;
            return this;
        }

        public JobRepresentation.JobRepresentationBuilder paymentTerms(String paymentTerms) {
            this.paymentTerms = paymentTerms;
            return this;
        }

        public JobRepresentation.JobRepresentationBuilder vat(int vat) {
            this.vat = vat;
            return this;
        }

        public JobRepresentation build() {
            return new JobRepresentation(this);
        }
    }
}
