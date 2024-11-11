package com.blue.express.character_core.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HeroRepository extends CrudRepository<Hero,Long> {

    public List<Hero> findTop10ByOrderByLikesDesc();
    public List<Hero> findTop10ByOrderByDislikesDesc();

    @Query("select u from Hero u where lower(u.name) like %:name%")
    public List<Hero> findByNameLike(@Param("name") String name);

    Optional<Hero> findTopByOrderByUpdateDateTimeDesc();

}
