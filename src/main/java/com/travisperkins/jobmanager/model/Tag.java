package com.travisperkins.jobmanager.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by msamandi on 07/03/2017.
 */
@Entity
@Table(name = "TAG")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "ITEMS")

    @ManyToMany(mappedBy = "tags")
    List<Item> items ;

    @Column(name = "NAME")
    private String name ;


    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


}
