package com.capstonebackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//this model is what i'm saving to the db

@Data
@Entity
@Table(name = "player")
@ToString(exclude={"games"})
//@Entity indicates that Game is an Entity and @Table specifies the primary table (name game) for the annotated @Entity
public class Player implements Serializable {

    @ManyToMany(mappedBy = "players")
    @JsonIgnore
    private List<Game> games;

//    private Set<Game> game = new HashSet<>();

    protected Player(){ }

    private static final long serialVersionUID = 1L;

    private @Id
            @GeneratedValue (strategy = GenerationType.IDENTITY)
            @Column(name="player_id") Long player_id;

    @Column(name = "first_name")
    private String first_name;
    @Column(name = "user_name")
    private String  user_name;
    @Column(name = "games_played")
    private Integer games_played;
    @Column(name = "profile_picture")
    private String profile_picture;

    public Player(String first_name, String user_name, Integer games_played, String profile_picture) {
        this.first_name = first_name;
        this.user_name = user_name;
        this.games_played = games_played;
        this.profile_picture = profile_picture;
    }

//    @Override
//    public String toString() {
//        return String.format("Player[id=%d, firstName='%s', userName='%s', gamesPlayed='%i']", id, firstName, userName, gamesPlayed);
//    }

}
