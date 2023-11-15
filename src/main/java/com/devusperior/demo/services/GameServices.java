package com.devusperior.demo.services;

import com.devusperior.demo.DTO.GameDTO;
import com.devusperior.demo.DTO.GameFullDTO;
import com.devusperior.demo.DTO.GameListDTO;
import com.devusperior.demo.entities.Game;
import com.devusperior.demo.projections.GameMinProjection;
import com.devusperior.demo.repositories.GameRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameServices {
    @Autowired
    private GameRepositories gameRepositories;


    @Transactional(readOnly = true)
    public GameFullDTO findById(Long id){
        Game gameId = gameRepositories.findById(id).get();
        return new GameFullDTO(gameId);
    }
    @Transactional(readOnly = true)
    public List<GameDTO> findAll(){
        List<Game> listGame = gameRepositories.findAll();
        return listGame.stream().map(x -> new GameDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public List<GameDTO> findByList(Long list){
        List<GameMinProjection> listGame = gameRepositories.searchByList(list);
        return listGame.stream().map(x -> new GameDTO(x)).toList();
    }
}
