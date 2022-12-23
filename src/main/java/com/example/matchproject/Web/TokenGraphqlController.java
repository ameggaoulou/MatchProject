package com.example.matchproject.Web;


import com.example.matchproject.Dtos.InputDtos.TokenInputDto;
import com.example.matchproject.Dtos.OutputDtos.TokenOutputDto;
import com.example.matchproject.Exceptions.Custom.*;
import com.example.matchproject.Services.Tokens.TokenServices;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;

public class TokenGraphqlController {
    private TokenServices tokenServices;

    @MutationMapping
    private TokenOutputDto getToken(@Argument TokenInputDto tokenInputDto) throws GameIdNotFoundException, MissingFieldsException, TokenSoldOutException {
        return tokenServices.buyToken(tokenInputDto);
    }

    @MutationMapping
    private void updateToken(@Argument String id) throws TokenIdNotFoundException, TokenAlreadyValidatedException {
        tokenServices.validateToken(id);
    }
}
