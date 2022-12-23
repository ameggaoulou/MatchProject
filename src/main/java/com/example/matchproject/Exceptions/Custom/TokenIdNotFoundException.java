package com.example.matchproject.Exceptions.Custom;

public class TokenIdNotFoundException extends Exception{
    public TokenIdNotFoundException(String id){
    super("The given Token id: "+id+", is not found!!");
}
}
