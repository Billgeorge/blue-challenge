package com.blue.express.character_core.dto;

import com.blue.express.character_core.repository.Hero;

public class Converter {

    public static HeroDTO fromEntityToDTO(Hero hero){
        HeroDTO heroDTO = new HeroDTO();
        heroDTO.setId(hero.getId());
        heroDTO.setName(hero.getName());
        heroDTO.setDescription(hero.getDescription());
        heroDTO.setLikes(hero.getLikes());
        heroDTO.setDislikes(hero.getDislikes());
        heroDTO.setImageUrl(hero.getImageUrl());
        heroDTO.setUpdateDateTime(hero.getUpdateDateTime());
        return heroDTO;
    }
}
