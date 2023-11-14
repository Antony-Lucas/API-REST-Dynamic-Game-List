package com.devusperior.demo.repositories;

import com.devusperior.demo.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepositories extends JpaRepository<Game, Long> {
}
