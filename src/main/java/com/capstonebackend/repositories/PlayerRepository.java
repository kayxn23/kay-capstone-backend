package com.capstonebackend.repositories;

import com.capstonebackend.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


//this repo supports: creating new instances, updating, delete, finding
public interface PlayerRepository extends JpaRepository<Player, Long> {
    @Query(value="SELECT * FROM player WHERE user_id = :user_id", nativeQuery=true)
    public List<Player> findByUID(@Param("user_id") String user_id);

}