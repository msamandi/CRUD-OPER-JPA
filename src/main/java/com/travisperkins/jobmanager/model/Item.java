package com.travisperkins.jobmanager.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by sverma on 27/02/2017.
 */
@Entity
@Table(name = "ITEM")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "QUANTITY")
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TASK_ID")
    private Task task;

    @ManyToMany
    @JoinTable(
            name = "ITEM_TAG",
            joinColumns = @JoinColumn(name = "ITEM_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "TAG_ID", referencedColumnName = "ID"))
    private List<Tag> tags;

    public Item(Item item) {
        this.quantity = item.getQuantity();
        this.price = item.getPrice();
        this.category = item.getCategory();
        this.description = item.getDescription();
        this.id = item.getId();
    }

    public Item() {
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", task=" + task +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (quantity != item.quantity) return false;
        if (id != null ? !id.equals(item.id) : item.id != null) return false;
        if (category != null ? !category.equals(item.category) : item.category != null) return false;
        if (description != null ? !description.equals(item.description) : item.description != null) return false;
        if (price != null ? !price.equals(item.price) : item.price != null) return false;
        if (task != null ? !task.equals(item.task) : item.task != null) return false;
        return tags != null ? tags.equals(item.tags) : item.tags == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + quantity;
        result = 31 * result + (task != null ? task.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        return result;
    }
}
