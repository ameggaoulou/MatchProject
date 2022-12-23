package com.example.matchproject.Exceptions.Custom;

public class TokenSoldOutException extends Exception{
    public TokenSoldOutException(){
    super("Token For this Game are Sold Out!!!");
}

}
