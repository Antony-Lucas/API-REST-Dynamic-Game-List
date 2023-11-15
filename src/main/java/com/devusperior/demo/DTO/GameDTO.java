package com.devusperior.demo.DTO;

import com.devusperior.demo.entities.Game;
import com.devusperior.demo.projections.GameMinProjection;
import jakarta.persistence.Column;

public class GameDTO {
    Long id;
    private String title;
    private int year;
    private String imgUrl;
    private String shortDescription;

    public GameDTO(){

    }

    public GameDTO(Game entity) {
        super();
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.year = entity.getYear();
        this.imgUrl = entity.getImgUrl();
        this.shortDescription = entity.getShortDescription();
    }

    public GameDTO(GameMinProjection entity) {
        super();
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.year = entity.getYear();
        this.imgUrl = entity.getImgUrl();
        this.shortDescription = entity.getShortDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
