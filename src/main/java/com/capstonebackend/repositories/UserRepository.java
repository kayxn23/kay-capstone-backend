package com.capstonebackend.repositories;

import com.capstonebackend.models.Game;
import com.capstonebackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


//this repo supports: creating new instances, updating, delete, finding
public interface UserRepository extends JpaRepository<User, Long> {
}