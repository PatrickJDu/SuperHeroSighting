package com.mthree.superhero.daos;

import com.mthree.superhero.models.Sighting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SightingRepository extends JpaRepository<Sighting, Integer> {
}
