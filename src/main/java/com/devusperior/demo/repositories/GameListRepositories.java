package com.devusperior.demo.repositories;

import com.devusperior.demo.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepositories extends JpaRepository<GameList, Long> {
}
