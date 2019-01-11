package com.capstonebackend.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//this model is what i'm saving to the db

@Data
@Entity
@Table(name = "game") //, schema="capstonebackend"
//@Entity indicates that Game is an Entity and @Table specifies the primary table (name game) for the annotated @Entity
public class Game implements Serializable {

    @ManyToOne
//    @JoinColumn(name="location_id", nullable=false)
    @JoinColumn(name="location_id", insertable=false, updatable=false)
    private Location location;

//    public Game() {}


    @ManyToMany(cascade = { CascadeType.ALL})
    @JoinTable(
            name = "game_player",
            joinColumns = { @JoinColumn(name = "game_id", referencedColumnName = "game_id")},
            inverseJoinColumns = { @JoinColumn(name = "player_id", referencedColumnName = "player_id")}
    )
    private List<Player> players;
//    Set<Player> players = new HashSet<>();


    protected Game(){ }

    private static final long serialVersionUID = 1L;
    
    private @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name="game_id") Long game_id;

    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column (name = "game_date") //user_id of the person who created
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date game_date;
//    @Column (name = "location_id") //should this be @ something else?
    private Long location_id;

    public Game(String title, String description, Date game_date, Long location_id) {
        this.title = title;
        this.description = description;
        this.game_date = game_date;
        this.description = description;
        this.location_id = location_id;
    }

    @Override
    public String toString() {
        return String.format("Game[game_id=%d, title='%s', description='%s']", game_id, title, description);
    }

}
