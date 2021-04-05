package com.mthree.superhero.models;

import javax.persistence.*;

@Entity(name="superpowers")
public class Superpower {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="powerid")
    private int id;
    @Column(name="powername")
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
