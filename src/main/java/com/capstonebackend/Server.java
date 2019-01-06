package com.capstonebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //this is a meta-annotation that pulls in component scanning, autoconfiguration, and property support.
public class Server {
    public static void main(String... args) {
        SpringApplication.run(Server.class, args);
    }

}
