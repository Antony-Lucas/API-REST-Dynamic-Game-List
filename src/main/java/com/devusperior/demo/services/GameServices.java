package com.devusperior.demo.services;

import com.devusperior.demo.DTO.GameDTO;
import com.devusperior.demo.entities.Game;
import com.devusperior.demo.repositories.GameRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServices {
    @Autowired
    private GameRepositories gameRepositories;

    public List<GameDTO> findAll(){
        List<Game> listGame = gameRepositories.findAll();
        return listGame.stream().map(x -> new GameDTO(x)).toList();
    }
}
