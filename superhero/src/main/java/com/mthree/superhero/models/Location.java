package com.mthree.superhero.models;


import javax.persistence.*;

@Entity(name="location")
public class Location {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="locationid")
    private int id;
    @Column(name="locationname")
    private String name;
    @Column(name="locationdescription")
    private String description;
    @Column(name="locationaddress")
    private String address;
    @Column
    private double latitude;
    @Column
    private double longitude;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
