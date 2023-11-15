package com.devusperior.demo.controller;

import com.devusperior.demo.DTO.GameDTO;
import com.devusperior.demo.DTO.GameListDTO;
import com.devusperior.demo.services.GameListServices;
import com.devusperior.demo.services.GameServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/list")
public class GameListController {
    @Autowired
    private GameListServices gameListServices;

    @Autowired
    private GameServices gameServices;

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> list = gameListServices.findAll();
        return list;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameDTO> findAllbyList(@PathVariable Long listId){
        List<GameDTO> listDto = gameServices.findByList(listId);
        return listDto;
    }
}
