package com.example.matchproject.Exceptions.Custom;

public class GameIdNotFoundException extends Exception{
    public GameIdNotFoundException(String id){
        super("The given game id: "+id+", is not found!!");
    }
}
