package com.devusperior.demo.controller;

import com.devusperior.demo.DTO.GameDTO;
import com.devusperior.demo.entities.Game;
import com.devusperior.demo.services.GameServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {
    @Autowired
    private GameServices gameServices;

    @GetMapping
    public List<GameDTO> findAll(){
        List<GameDTO> listGame = gameServices.findAll();
        return listGame;
    }
}
