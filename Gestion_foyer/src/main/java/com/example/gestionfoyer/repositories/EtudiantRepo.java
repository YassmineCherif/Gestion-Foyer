package com.example.gestionfoyer.repositories;

import com.example.gestionfoyer.Entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;




@Repository
public interface EtudiantRepo extends JpaRepository<Etudiant, Long> {
    Optional<Etudiant> findByCin(long cinEtudiant);
}
