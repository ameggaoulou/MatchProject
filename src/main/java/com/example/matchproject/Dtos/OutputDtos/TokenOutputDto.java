package com.example.matchproject.Dtos.OutputDtos;


import com.example.matchproject.Enum.TokenState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenOutputDto {
    private String id;
    private Double price;
    private TokenState state;
    private String ref;
    private GameOutputDto gameOutputDto;
}
