package com.mthree.superhero.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name="sighting")
public class Sighting implements Comparable<Sighting>{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="sightingid")
    private int id;
    @Column(name="heroname")
    private String name;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="locationid")
    private Location location;
    @Column(name="dateseen")
    private LocalDateTime dateSeen;

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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public LocalDateTime getDateSeen() {
        return dateSeen;
    }

    public void setDateSeen(LocalDateTime dateSeen) {
        this.dateSeen = dateSeen;
    }

    @Override
    public int compareTo(Sighting o) {
        if(this.getDateSeen().isAfter(o.getDateSeen())){
            return 1;
        }
        else if (this.getDateSeen().isEqual(o.getDateSeen())){
            return 0;
        }
        else{
            return -1;
        }
    }
}
