package com.blue.express.character_core.controller.payload;


import com.blue.express.character_core.dto.HeroDTO;

import java.util.List;

public class OrderByResponse {
    private String status;
    private String message;
    private List<HeroDTO> heroes;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<HeroDTO> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<HeroDTO> heroes) {
        this.heroes = heroes;
    }
}
