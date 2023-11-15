package com.devusperior.demo.services;

import com.devusperior.demo.DTO.GameListDTO;
import com.devusperior.demo.entities.GameList;
import com.devusperior.demo.repositories.GameListRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListServices {
    @Autowired
    private GameListRepositories gameListRepositories;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> list = gameListRepositories.findAll();
        return list.stream().map(x -> new GameListDTO(x)).toList();
    }
}
