package com.travisperkins.jobmanager.representation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.travisperkins.jobmanager.model.Job;

import java.util.Date;

/**
 * Created by sverma on 27/02/2017.
 */

public class TaskRepresentation {

    private Long id;

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date created;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updated;

    private Job job;

    public TaskRepresentation(TaskRepresentationBuilder taskRepresentationBuilder) {
        this.id = taskRepresentationBuilder.id;
        this.name = taskRepresentationBuilder.name;
        this.created = taskRepresentationBuilder.created;
        this.updated = taskRepresentationBuilder.updated;
        this.job = taskRepresentationBuilder.job;
    }

    public TaskRepresentation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
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

        TaskRepresentation task = (TaskRepresentation) o;

        if (id != null ? !id.equals(task.id) : task.id != null) return false;
        if (name != null ? !name.equals(task.name) : task.name != null) return false;
        if (created != null ? !created.equals(task.created) : task.created != null) return false;
        if (updated != null ? !updated.equals(task.updated) : task.updated != null) return false;
        return (job != null ? !job.equals(task.job) : task.job != null);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (updated != null ? updated.hashCode() : 0);
        result = 31 * result + (job != null ? job.hashCode() : 0);
        return result;
    }

    public static class TaskRepresentationBuilder {
        private Long id;

        private String name;

        private Date created;

        private Date updated;

        private Job job;

        public TaskRepresentationBuilder(Long id) {
            this.id = id;
        }

        public TaskRepresentation.TaskRepresentationBuilder name(String name) {
            this.name = name;
            return this;
        }

        public TaskRepresentation.TaskRepresentationBuilder created(Date created) {
            this.created = created;
            return this;
        }

        public TaskRepresentation.TaskRepresentationBuilder updated(Date updated) {
            this.updated = updated;
            return this;
        }

        public TaskRepresentation.TaskRepresentationBuilder job(Job job) {
            this.job = job;
            return this;
        }

        public TaskRepresentation build() {
            return new TaskRepresentation(this);
        }
    }
}
