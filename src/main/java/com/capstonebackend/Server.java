package com.capstonebackend;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootApplication //this is a meta-annotation that pulls in component scanning, autoconfiguration, and property support.
public class Server {
    public static void main(String... args) throws IOException {
        SpringApplication.run(Server.class, args);

        FileInputStream serviceAccount =
                new FileInputStream("src/main/resources/firebase-server-secret-key.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://kay-capstone-frontend.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);
    }

}


