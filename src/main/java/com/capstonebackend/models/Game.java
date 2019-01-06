package com.capstonebackend.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//this model is what i'm saving to the db

@Data
@Entity
public class Game {
    private @Id @GeneratedValue Long id;
    private String organizer;
    private String location;

    public Game(String organizer, String location) {
        this.organizer = organizer;
        this.location = location;
    }

}
