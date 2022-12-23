package com.example.matchproject.Services.Games;


import com.example.matchproject.Dtos.InputDtos.GameInputDto;
import com.example.matchproject.Dtos.OutputDtos.GameOutputDto;
import com.example.matchproject.Entities.Game;
import com.example.matchproject.Exceptions.Custom.InvalidTokenNumberException;
import com.example.matchproject.Exceptions.Custom.MissingFieldsException;
import com.example.matchproject.Mapper.MapperService;
import com.example.matchproject.Repositories.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class GameServicesImpl implements GameServices{
    private GameRepository gameRepository;
    private MapperService mapperService;
    @Override
    public GameOutputDto createGame(GameInputDto gameInputDto) throws MissingFieldsException, InvalidTokenNumberException {
        if (gameInputDto.getDateAndTime() == null || gameInputDto.getAvailableToken() == null
                || gameInputDto.getStadium()==null || gameInputDto.getStadium().isEmpty()
                || gameInputDto.getTeam1() == null || gameInputDto.getTeam1().isEmpty()
                || gameInputDto.getTeam2() == null || gameInputDto.getTeam2().isEmpty())
            throw new MissingFieldsException();
        if (gameInputDto.getAvailableToken() > 2022 || gameInputDto.getAvailableToken() <= 0)
            throw new InvalidTokenNumberException(gameInputDto.getAvailableToken());
        Game game = new Game();
        game.setId(UUID.randomUUID().toString());
        game.setDateAndTime(gameInputDto.getDateAndTime());
        game.setStadium(gameInputDto.getStadium());
        game.setTeam1(gameInputDto.getTeam1());
        game.setTeam2(gameInputDto.getTeam2());
        game.setRef(UUID.randomUUID().toString());
        game.setAvailableTokenNumber(gameInputDto.getAvailableToken());
        return mapperService.fromGame(gameRepository.save(game));
    }
    @Override
    public List<GameOutputDto> gamesList(){
        return gameRepository.findAll().stream().map(
                g -> mapperService.fromGame(g)
        ).toList();
    }
}
