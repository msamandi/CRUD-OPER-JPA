package com.travisperkins.jobmanager.representation;

import com.travisperkins.jobmanager.model.Task;

import java.math.BigDecimal;

/**
 * Created by sverma on 27/02/2017.
 */
public class ItemRepresentation {

    private Long id;

    private String category;

    private String description;

    private BigDecimal price;

    private int quantity;

    private Task task;


    public ItemRepresentation(ItemRepresentationBuilder itemRepresentationBuilder) {
        this.id = itemRepresentationBuilder.id;
        this.quantity = itemRepresentationBuilder.quantity;
        this.price = itemRepresentationBuilder.price;
        this.category = itemRepresentationBuilder.category;
        this.description = itemRepresentationBuilder.description;
        this.task = itemRepresentationBuilder.task;
    }

    public ItemRepresentation() {
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

    public static class ItemRepresentationBuilder {
        private Long id;

        private String category;

        private String description;

        private BigDecimal price;

        private int quantity;

        private Task task;

        public ItemRepresentationBuilder(Long id) {
            this.id = id;
        }

        public ItemRepresentationBuilder category(String category) {
            this.category = category;
            return this;
        }

        public ItemRepresentationBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ItemRepresentationBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public ItemRepresentationBuilder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public ItemRepresentationBuilder task(Task task) {
            this.task = task;
            return this;
        }

        public ItemRepresentation build() {
            return new ItemRepresentation(this);
        }

    }
}
