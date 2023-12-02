package com.varocode.springbootws.model;


import jakarta.persistence.*;
import org.hibernate.annotations.NaturalId;

/**
 * @author aap
 * Model class for brand mapping
 */
@Entity
@Table(name="BRANDS")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NaturalId
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
