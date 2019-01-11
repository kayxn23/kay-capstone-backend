package com.capstonebackend.models;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "location")

public class Location implements Serializable {

    //mappedBy property is what we use to tell Hibernate which variable we are using to represent the parent class in our child class.
    @OneToMany(mappedBy="location")
    private Set<Game> game; //think if this should be plural
//one location to many games
    protected Location(){}

    private static final long serialVersionUID = 1L;

    private @Id
    @GeneratedValue //(strategy = GenerationType.IDENTITY)
    @Column(name="id") Long id;

    @Column(name = "latitude")
    private Float latitude;
    @Column(name = "longitude")
    private Float longitude;

    public Location(Float latitude, Float longitude) {
        this.latitude= latitude;
        this.longitude = longitude;
    }

}


