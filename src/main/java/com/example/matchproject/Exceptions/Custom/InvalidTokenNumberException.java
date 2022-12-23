package com.example.matchproject.Exceptions.Custom;

public class InvalidTokenNumberException extends Exception{
    public InvalidTokenNumberException(Integer num){
        super("Number of token should be between 1 and 2022, you give it a value of:" + num);
    }
}
