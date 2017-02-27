package com.travisperkins.jobmanager.model;

/**
 * Created by sverma on 27/02/2017.
 */
public class Item {
    private Product product;

    private int quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
