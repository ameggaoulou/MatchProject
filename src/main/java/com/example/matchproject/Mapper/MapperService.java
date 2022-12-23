package com.example.matchproject.Mapper;


import com.example.matchproject.Dtos.OutputDtos.GameOutputDto;
import com.example.matchproject.Dtos.OutputDtos.TokenOutputDto;
import com.example.matchproject.Entities.Game;
import com.example.matchproject.Entities.Token;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MapperService {
    public GameOutputDto fromGame(Game game){
        GameOutputDto gameOutputDto = new GameOutputDto();
        BeanUtils.copyProperties(game, gameOutputDto);
        return  gameOutputDto;
    }

    public TokenOutputDto fromToken(Token token){
        TokenOutputDto tokenOutputDto = new TokenOutputDto();
        BeanUtils.copyProperties(token, tokenOutputDto);
        tokenOutputDto.setGameOutputDto(this.fromGame(token.getGame()));
        return tokenOutputDto;
    }

}
