package com.codecool.fplbackend.model;

public class InvalidSquadException extends Exception{
    public InvalidSquadException(String errorMessage) {
        super(errorMessage);
    }
}
