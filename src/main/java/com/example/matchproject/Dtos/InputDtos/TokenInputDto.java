package com.example.matchproject.Dtos.InputDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenInputDto {
    private Double price;
    private String gameId;
}
