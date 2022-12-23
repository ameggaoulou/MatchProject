package com.example.matchproject.Repositories;


import com.example.matchproject.Entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, String> {
}
