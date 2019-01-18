package com.capstonebackend.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
@Entity
@Table(name = "location")
@ToString(exclude = {"games"})
public class Location implements Serializable {

    //mappedBy property is what we use to tell Hibernate which variable we are using to represent the parent class in our child class.
    @OneToMany(mappedBy="location")
    @JsonIgnore
//    private Set<Game> games; //think if this should be plural
    private List<Game> games;

    //one location to many games
    protected Location(){}

    private static final long serialVersionUID = 1L;

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id") Long id;

    @Column(name = "latitude")
    private Float latitude;
    @Column(name = "longitude")
    private Float longitude;
    @Column(name = "location_title")
    private String location_title;

    public Location(Float latitude, Float longitude, String location_title) {
        this.latitude= latitude;
        this.longitude = longitude;
        this.location_title = location_title;
    }

}


