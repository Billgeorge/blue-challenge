package com.blue.express.character_core.service;

import com.blue.express.character_core.constant.Response;
import com.blue.express.character_core.dto.Converter;
import com.blue.express.character_core.dto.HeroDTO;
import com.blue.express.character_core.repository.Hero;
import com.blue.express.character_core.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class HeroServiceImpl implements HeroService {

    @Autowired
    private HeroRepository heroRepository;

    @Override
    public Optional<HeroDTO> getRandonHero() {
        Random random = new Random();
        int id = random.nextInt(5) + 1;
        Optional<Hero> heroOpt = heroRepository.findById((long) id);
        return heroOpt.map(Converter::fromEntityToDTO);
    }

    @Override
    public Optional<HeroDTO> findHeroById(long id) {
        Optional<Hero> heroOpt = heroRepository.findById(id);
        return heroOpt.map(Converter::fromEntityToDTO);
    }

    @Transactional
    @Override
    public Response like(long id) {
        try{
            Optional<Hero> heroRes = heroRepository.findById(id);
            if(heroRes.isEmpty()){
                return Response.NOT_FOUND;
            }
            Hero hero = heroRes.get();
            hero.setLikes(hero.getLikes()+1);
            hero.setUpdateDateTime(LocalDateTime.now());
            heroRepository.save(hero);
            return Response.OK;
        }catch(Exception e){
            e.printStackTrace();
            return Response.INTERNAL_ERROR;
        }

    }
    @Transactional
    @Override
    public Response dislike(long id) {
        try{
            Optional<Hero> heroRes = heroRepository.findById(id);
            if(heroRes.isEmpty()){
                return Response.NOT_FOUND;
            }
            Hero hero = heroRes.get();
            hero.setDislikes(hero.getDislikes()+1);
            hero.setUpdateDateTime(LocalDateTime.now());
            heroRepository.save(hero);
            return Response.OK;
        }catch(Exception e){
            e.printStackTrace();
            return Response.INTERNAL_ERROR;
        }

    }

    @Override
    public List<HeroDTO> getHeroOrderByFame() {
        List<Hero> heroes = heroRepository.findTop10ByOrderByLikesDesc();
        return heroes.stream().map(Converter::fromEntityToDTO).toList();
    }

    @Override
    public List<HeroDTO> getHeroOrderByDislike() {
        List<Hero> heroes = heroRepository.findTop10ByOrderByDislikesDesc();
        return heroes.stream().map(Converter::fromEntityToDTO).toList();
    }

    @Override
    public List<HeroDTO> searchHeroByName(String name) {
        List<Hero> heroes = heroRepository.findByNameLike(name.toLowerCase());
        return heroes.stream().map(Converter::fromEntityToDTO).toList();
    }

    @Override
    public Optional<HeroDTO> getLatestUpdatedRecord() {
        return heroRepository.findTopByOrderByUpdateDateTimeDesc().map(Converter::fromEntityToDTO);
    }
}
