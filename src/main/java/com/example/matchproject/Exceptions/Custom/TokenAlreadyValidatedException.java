package com.example.matchproject.Exceptions.Custom;

public class TokenAlreadyValidatedException extends Exception{
    public TokenAlreadyValidatedException(String id){
        super("Token with id: "+id+", Has Already been used!!");
    }
}
