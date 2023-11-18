package com.devusperior.demo.services;

import com.devusperior.demo.DTO.GameListDTO;
import com.devusperior.demo.entities.GameList;
import com.devusperior.demo.projections.GameMinProjection;
import com.devusperior.demo.repositories.GameListRepositories;
import com.devusperior.demo.repositories.GameRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListServices {
    @Autowired
    private GameListRepositories gameListRepositories;

    @Autowired
    private GameRepositories gameRepositories;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> list = gameListRepositories.findAll();
        return list.stream().map(x -> new GameListDTO(x)).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepositories.searchByList(listId);
        GameMinProjection obj =  list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++){
            gameListRepositories.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
