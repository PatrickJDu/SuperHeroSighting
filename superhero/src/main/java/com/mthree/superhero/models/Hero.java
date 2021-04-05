package com.mthree.superhero.models;


import javax.persistence.*;

@Entity(name="hero")
public class Hero {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "heroid")
    private int id;
    @Column(name="heroname")
    private String name;
    @Column(name="herodescription")
    private String description;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "powerid")
    private Superpower superpower;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Superpower getSuperpower() {
        return superpower;
    }

    public void setSuperpower(Superpower superpower) {
        this.superpower = superpower;
    }
}
