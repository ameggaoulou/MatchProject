package com.example.matchproject.Services.Tokens;


import com.example.matchproject.Dtos.InputDtos.TokenInputDto;
import com.example.matchproject.Dtos.OutputDtos.TokenOutputDto;
import com.example.matchproject.Entities.Game;
import com.example.matchproject.Entities.Token;
import com.example.matchproject.Enum.TokenState;
import com.example.matchproject.Exceptions.Custom.*;
import com.example.matchproject.Mapper.MapperService;
import com.example.matchproject.Repositories.GameRepository;
import com.example.matchproject.Repositories.TokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor

public class TokenServicesImpl  implements TokenServices{
    private TokenRepository ticketRepository;
    private MapperService mapperService;
    private GameRepository gameRepository;



    @Override
    public TokenOutputDto buyToken(TokenInputDto tokenInputDto) throws MissingFieldsException, GameIdNotFoundException, TokenSoldOutException {
        if (tokenInputDto.getGameId() == null || tokenInputDto.getGameId().isEmpty()
                || tokenInputDto.getPrice().isNaN() || tokenInputDto.getPrice() <= 0)
            throw new MissingFieldsException();
        Game game = gameRepository.findById(tokenInputDto.getGameId())
                .orElseThrow(
                        () -> new GameIdNotFoundException(tokenInputDto.getGameId())
                );
        if (game.getAvailableTokenNumber() == 0)
            throw new TokenSoldOutException();
        Token token = new Token();
        token.setId(UUID.randomUUID().toString());
        token.setPrice(tokenInputDto.getPrice());
        token.setState(TokenState.ENABLED);
        token.setRef(UUID.randomUUID().toString().substring(0,16));
        token.setGame(game);

        game.setAvailableTokenNumber(game.getAvailableTokenNumber() - 1);
        gameRepository.save(game);
        return mapperService.fromToken(ticketRepository.save(token));
    }

    @Override
    public void validateToken(String id) throws TokenIdNotFoundException, TokenAlreadyValidatedException {
        Token ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new TokenIdNotFoundException(id));
        if (ticket.getState() == TokenState.DISABLED)
            throw new TokenAlreadyValidatedException(id);
        //Do not validate ticket until the day of the game
        ticket.setState(TokenState.DISABLED);
        ticketRepository.save(ticket);
    }
}
