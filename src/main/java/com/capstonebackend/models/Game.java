package com.capstonebackend.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name = "game") //, schema="capstonebackend"
//@Entity indicates that Game is an Entity and @Table specifies the primary table (name game) for the annotated @Entity
public class Game implements Serializable {

    //(fetch=FetchType.LAZY)  (fetch=FetchType.EAGER)
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="location_id")
    private Location location;


    protected Game(){ }

    private static final long serialVersionUID = 1L;
    
    private @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name="game_id") Long game_id;

    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column (name = "game_date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss Z")
    private Date game_date;

    @ManyToOne
    @JoinColumn(name="organizer_id")  //user_id of the person who created
    private Player organizer; //organizer is a player object

    @ManyToMany(cascade = { CascadeType.ALL})
    @JoinTable(
            name = "game_player",
            joinColumns = { @JoinColumn(name = "game_id", referencedColumnName = "game_id")},
            inverseJoinColumns = { @JoinColumn(name = "player_id", referencedColumnName = "player_id")}
    )
    private List<Player> players;


}
