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
public class JobSpec {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private ArrayList<Item> items;

    private Date created;

    private boolean isQuoteGenerated;

    private Date quoteCreated;

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
