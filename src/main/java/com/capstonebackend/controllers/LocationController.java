package com.capstonebackend.controllers;


import com.capstonebackend.models.Location;
import com.capstonebackend.repositories.LocationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sspickup")
public class LocationController {
    private final LocationRepository locationRepository;

    LocationController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @GetMapping("/locations")
    public List<Location> all() {return locationRepository.findAll();}

    @PostMapping("/locations")
    Location newLocation(@RequestBody Location newLocation) {return locationRepository.save(newLocation);}

    @DeleteMapping("/locations/{id}")
    void deleteLocation(@PathVariable Long id) {
        locationRepository.deleteById(id);
    }

    @PutMapping("/locations/{id}")
    Location replaceLocation(@RequestBody Location newLocation, @PathVariable Long id) {
        return locationRepository.findById(id)
                .map(location -> {
                    location.setLatitude(newLocation.getLatitude());
                    location.setLongitude(newLocation.getLongitude());
                    location.setLocation_title(newLocation.getLocation_title());

                    return locationRepository.save(location);
                })
                .orElseGet(() -> {
                    newLocation.setId(id);
                    return locationRepository.save(newLocation);
                });
    }

}



