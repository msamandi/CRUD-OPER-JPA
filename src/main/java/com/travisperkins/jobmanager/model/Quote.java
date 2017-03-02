package com.travisperkins.jobmanager.model;

/**
 * Created by msamandi on 23/02/2017.
 */
public class Quote {
    public Quote(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String name;
    private String type;
    private String description;

}
