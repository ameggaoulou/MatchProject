package com.example.matchproject.Services.Games;



import com.example.matchproject.Dtos.InputDtos.GameInputDto;
import com.example.matchproject.Dtos.OutputDtos.GameOutputDto;
import com.example.matchproject.Exceptions.Custom.InvalidTokenNumberException;
import com.example.matchproject.Exceptions.Custom.MissingFieldsException;

import java.util.List;

public interface GameServices {
    GameOutputDto createGame(GameInputDto gameInputDto) throws MissingFieldsException, InvalidTokenNumberException;
    List<GameOutputDto> gamesList();
}
