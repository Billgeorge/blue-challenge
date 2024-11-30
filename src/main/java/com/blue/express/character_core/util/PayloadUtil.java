package com.blue.express.character_core.util;

import com.blue.express.character_core.constant.Constant;
import com.blue.express.character_core.controller.payload.OrderByResponse;
import com.blue.express.character_core.dto.HeroDTO;
import com.blue.express.character_core.repository.Hero;

import java.util.List;

public class PayloadUtil {
    public static HeroDTO convertHeroToDTO(Hero hero){
        HeroDTO heroDTO = new HeroDTO();
        heroDTO.setDescription(hero.getDescription());
        heroDTO.setDislikes(hero.getDislikes());
        heroDTO.setLikes(hero.getLikes());
        heroDTO.setName(hero.getName());
        heroDTO.setDetail(hero.getId());
        heroDTO.setId(hero.getId());
        heroDTO.setImageUrl(hero.getImageUrl());
        return heroDTO;
    }
    public static OrderByResponse createSuccessResponse(List<HeroDTO> heroes){
        OrderByResponse res = new OrderByResponse();
        res.setStatus(Constant.SUCCESS_STATUS);
        res.setMessage(Constant.SUCCESS_STATUS);
        res.setHeroes(heroes);
        return res;
    }
    public static OrderByResponse createErrorResponse(String message){
        OrderByResponse res = new OrderByResponse();
        res.setStatus(Constant.ERROR_STATUS);
        res.setMessage(message);
        return res;
    }
}
