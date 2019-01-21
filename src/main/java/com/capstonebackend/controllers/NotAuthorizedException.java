package com.capstonebackend.controllers;

public class NotAuthorizedException extends RuntimeException{

    NotAuthorizedException() {
        super("Not authorized to execute this operation");
    }
}
