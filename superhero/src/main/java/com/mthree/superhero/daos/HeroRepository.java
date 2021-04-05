package com.mthree.superhero.daos;

import com.mthree.superhero.models.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Integer> {
}
