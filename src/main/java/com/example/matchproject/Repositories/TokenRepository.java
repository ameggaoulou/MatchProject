package com.example.matchproject.Repositories;

import com.example.matchproject.Entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TokenRepository extends JpaRepository<Token, String>{
}
