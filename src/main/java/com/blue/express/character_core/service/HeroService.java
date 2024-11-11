package com.blue.express.character_core.service;

import com.blue.express.character_core.constant.Response;
import com.blue.express.character_core.controller.UpdateHeroRequest;
import com.blue.express.character_core.dto.HeroDTO;

import java.util.List;
import java.util.Optional;

public interface HeroService {
    public Optional<HeroDTO> getRandonHero();
    public Optional<HeroDTO> findHeroById(long id);
    public Response like(long id);
    public Response dislike(long id);
    public List<HeroDTO> getHeroOrderByFame();
    public List<HeroDTO> getHeroOrderByDislike();
    public List<HeroDTO> searchHeroByName(String name);
    Optional<HeroDTO> getLatestUpdatedRecord();

}
