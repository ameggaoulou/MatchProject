package com.example.matchproject.Web;


import com.example.matchproject.Dtos.InputDtos.GameInputDto;
import com.example.matchproject.Dtos.OutputDtos.GameOutputDto;
import com.example.matchproject.Exceptions.Custom.InvalidTokenNumberException;
import com.example.matchproject.Exceptions.Custom.MissingFieldsException;
import com.example.matchproject.Services.Games.GameServices;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class GameGraphqlController {
    private GameServices gameServices;

    @MutationMapping
    private GameOutputDto addGame(@Argument GameInputDto gameInputDto) throws MissingFieldsException, InvalidTokenNumberException {
        return gameServices.createGame(gameInputDto);
    }

    @QueryMapping
    private List<GameOutputDto> getGames(){
        return gameServices.gamesList();
    }
}
