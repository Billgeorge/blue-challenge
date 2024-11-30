package com.blue.express.character_core.service;


import com.blue.express.character_core.constant.Response;
import com.blue.express.character_core.repository.Hero;
import com.blue.express.character_core.repository.HeroRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.util.Optional;

class HeroServiceImplTest {

    private HeroRepository heroRepository;
    private HeroServiceImpl heroService;

    @BeforeEach
    void setup(){
        heroRepository= Mockito.mock(HeroRepository.class);
        heroService = new HeroServiceImpl(heroRepository);
    }

    @Test
    @DisplayName("Character does not exist")
    void likeNotFound() {
        Mockito.when(heroRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
        Response response = heroService.like(1);
        Assertions.assertSame(response, Response.NOT_FOUND);
    }

    @Test
    @DisplayName("Exception")
    void likeException() {
        Mockito.when(heroRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(new Hero()));
        Mockito.when(heroRepository.save(Mockito.any())).thenThrow(new RuntimeException());
        Response response = heroService.like(1);
        Assertions.assertSame(response, Response.INTERNAL_ERROR);
    }

    @Test
    @DisplayName("success like")
    void like() {
        Mockito.when(heroRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(new Hero()));
        Response response = heroService.like(1);
        Assertions.assertSame(response, Response.OK);
    }

    @Test
    @DisplayName("Character does not exist")
    void disLikeNotFound() {
        Mockito.when(heroRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
        Response response = heroService.dislike(1);
        Assertions.assertSame(response, Response.NOT_FOUND);
    }

    @Test
    @DisplayName("Exception")
    void disLikeException() {
        Mockito.when(heroRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(new Hero()));
        Mockito.when(heroRepository.save(Mockito.any())).thenThrow(new RuntimeException());
        Response response = heroService.dislike(1);
        Assertions.assertSame(response, Response.INTERNAL_ERROR);
    }

    @Test
    @DisplayName("success disLike")
    void disLike() {
        Mockito.when(heroRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(new Hero()));
        Response response = heroService.dislike(1);
        Assertions.assertSame(response, Response.OK);
    }
}