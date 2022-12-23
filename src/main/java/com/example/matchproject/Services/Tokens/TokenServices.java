package com.example.matchproject.Services.Tokens;


import com.example.matchproject.Dtos.InputDtos.TokenInputDto;
import com.example.matchproject.Dtos.OutputDtos.TokenOutputDto;
import com.example.matchproject.Exceptions.Custom.*;

public interface TokenServices {


    TokenOutputDto buyToken(TokenInputDto tokenInputDto) throws MissingFieldsException, GameIdNotFoundException, TokenSoldOutException;



    void validateToken(String id) throws TokenIdNotFoundException, TokenAlreadyValidatedException;
}
