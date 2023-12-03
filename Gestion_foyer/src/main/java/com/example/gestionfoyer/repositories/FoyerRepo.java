package com.example.gestionfoyer.repositories;

import com.example.gestionfoyer.Entities.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoyerRepo extends JpaRepository<Foyer, Long> {
}
