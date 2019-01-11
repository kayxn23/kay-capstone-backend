package com.capstonebackend.repositories;

import com.capstonebackend.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;


//this repo supports: creating new instances, updating, delete, finding
public interface PlayerRepository extends JpaRepository<Player, Long> {
}