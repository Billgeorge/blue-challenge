package com.blue.express.character_core.controller;

import com.blue.express.character_core.constant.Response;
import com.blue.express.character_core.dto.HeroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.blue.express.character_core.service.HeroService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
@RequestMapping("character")
public class HeroController {

    @Autowired
    private HeroService heroService;

    @GetMapping("/random")
    public ResponseEntity<HeroDTO> getHero() {
        Optional<HeroDTO> hero = heroService.getRandonHero();
        return hero.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<HeroDTO>> searchHeroByName(@RequestParam String name){
        List<HeroDTO> hero = heroService.searchHeroByName(name);
        if(hero.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(hero);
    }

    @GetMapping("/last")
    public ResponseEntity<HeroDTO> getLatestUpdate(){
        Optional<HeroDTO> hero = heroService.getLatestUpdatedRecord();
        return hero.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HeroDTO> findyHeroBydId(@PathVariable long id) {
        Optional<HeroDTO> hero = heroService.findHeroById(id);
        return hero.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all/like")
    public ResponseEntity<List<HeroDTO>> heroesByLikes() {
        List<HeroDTO> hero = heroService.getHeroOrderByFame();
        if(hero.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(hero);
    }

    @GetMapping("/all/dislike")
    public ResponseEntity<List<HeroDTO>> heroesByDisikes() {
        List<HeroDTO> hero = heroService.getHeroOrderByDislike();
        if(hero.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(hero);
    }

    @PatchMapping("/{id}/like")
    public ResponseEntity updateLikes(@PathVariable long id){
         Response response = heroService.like(id);
        return switch (response) {
            case OK -> ResponseEntity.ok().build();
            case NOT_FOUND -> ResponseEntity.notFound().build();
            default -> ResponseEntity.internalServerError().build();
        };
    }

    @PatchMapping("/{id}/dislike")
    public ResponseEntity updateDisLikes(@PathVariable long id){
        Response response = heroService.dislike(id);
        return switch (response) {
            case OK -> ResponseEntity.ok().build();
            case NOT_FOUND -> ResponseEntity.notFound().build();
            default -> ResponseEntity.internalServerError().build();
        };
    }

}
