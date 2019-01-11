//package com.capstonebackend.database;
//
//import com.capstonebackend.models.Location;
//import com.capstonebackend.models.Player;
//import com.capstonebackend.repositories.LocationRepository;
//import com.capstonebackend.repositories.PlayerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DataLoader {
//
//    private PlayerRepository playerRepository;
//
//    @Autowired
//    public DataLoader(PlayerRepository playerRepository) {
//        this.playerRepository = playerRepository;
//        LoadPlayers();
//    }
//
//    private void LoadPlayers() {
//        playerRepository.save(new Player("lala", "lala", 2, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png"));
//    }
//
//
//
//
//
//
//    private LocationRepository locationRepository;
//
//    @Autowired
//    public DataLoader(LocationRepository locationRepository) {
//        this.locationRepository = locationRepository;
//        LoadPlayers();
//    }
//
//    private void LoadLocations() {
//        locationRepository.save(new Location( 47.635647f, -122.277260f));
//    }
//}