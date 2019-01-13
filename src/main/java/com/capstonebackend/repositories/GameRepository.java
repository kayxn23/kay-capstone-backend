package com.capstonebackend.repositories;

import com.capstonebackend.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


//this repo supports: creating new instances, updating, delete, finding
public interface GameRepository extends JpaRepository<Game, Long> {
    @Query(value="SELECT * FROM game WHERE location_id = :location_id", nativeQuery=true)
    public List<Game> findByLocationId(@Param("location_id") Long location_id);


}



