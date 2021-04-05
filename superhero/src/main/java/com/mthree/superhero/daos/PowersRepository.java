package com.mthree.superhero.daos;

import com.mthree.superhero.models.Superpower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PowersRepository extends JpaRepository<Superpower, Integer> {
}
