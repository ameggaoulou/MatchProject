package com.example.matchproject.Entities;



import com.example.matchproject.Enum.TokenState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Token {
    @Id
    private String id;
    private Double price;
    @Enumerated(EnumType.STRING)
    private TokenState state;
    private String ref;
    @ManyToOne
    private Game game;
}
