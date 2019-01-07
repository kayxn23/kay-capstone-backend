package com.capstonebackend.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

//this model is what i'm saving to the db

@Data
@Entity
@Table(name = "game")
//@Entity indicates that Game is an Entity and @Table specifies the primary table (name game) for the annotated @Entity
public class Game implements Serializable {
    protected Game(){ }

    private static final long serialVersionUID = 1L;
    
    private @Id @GeneratedValue Long id;

    @Column(name = "organizer")
    private String organizer;
    @Column(name = "location")
    private String location;

    public Game(String organizer, String location) {
        this.organizer = organizer;
        this.location = location;
    }

    @Override
    public String toString() {
        return String.format("Game[id=%d, organizer='%s', location='%s']", id, organizer, location);
    }

}
