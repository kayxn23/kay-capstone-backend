package com.capstonebackend.repositories;

import com.capstonebackend.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;


//this repo supports: creating new instances, updating, delete, finding

public interface LocationRepository extends JpaRepository<Location, Long> {
}
