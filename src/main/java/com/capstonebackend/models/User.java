//package com.capstonebackend.models;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
////this model is what i'm saving to the db
//
//@Data
//@Entity
//@Table(name = "user")
////@Entity indicates that Game is an Entity and @Table specifies the primary table (name game) for the annotated @Entity
//public class User implements Serializable {
//    protected User(){ }
//
//    private static final long serialVersionUID = 1L;
//
//    private @Id @GeneratedValue Long id;
//
//    @Column(name = "firstName")
//    private String firstName;
//    @Column(name = "userName")
//    private String  userName;
//    @Column(name = "gamesPlayed")
//    private Integer gamesPlayed;
//
//    public User(String firstName, String userName, Integer gamesPlayed) {
//        this.firstName = firstName;
//        this.userName = userName;
//        this.gamesPlayed = gamesPlayed;
//    }
//
//    @Override
//    public String toString() {
//        return String.format("User[id=%d, firstName='%s', userName='%s', gamesPlayed='%i']", id, firstName, userName, gamesPlayed);
//    }
//
//}
