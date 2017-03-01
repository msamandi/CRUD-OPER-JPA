package com.travisperkins.jobmanager.model;

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

    @Column(name = "ITEMS")
    private ArrayList<Item> items;

    @Column(name = "CREATED")
    private Date created;

    @Column(name = "ISQUOTEGENERATED")
    private boolean isQuoteGenerated;

    @Column(name = "QUOTECREATED")
    private Date quoteCreated;

    @Column(name = "UPDATED")
    private Date updated;

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
}
