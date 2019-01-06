package com.capstonebackend.repositories;

import com.capstonebackend.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

//this repo supports: creating new instances, updating, delete, finding
public interface GameRepository extends JpaRepository<Game, Long> {


}



