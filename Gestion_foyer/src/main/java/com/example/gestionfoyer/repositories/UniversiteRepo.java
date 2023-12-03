package com.example.gestionfoyer.repositories;

import com.example.gestionfoyer.Entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface UniversiteRepo  extends JpaRepository<Universite, Long> {
    @Query(value = "SELECT u FROM Universite u WHERE u.nomUniversite = :nomUniversite")
    Universite findByNomUniversite(String nomUniversite);

    @Query(value = "SELECT u FROM Foyer f , Universite u WHERE u.idUniversite = :idUniversite AND f.idFoyer = u.foyer.idFoyer")
    Universite findFoyerByIdUniversite(Long idUniversite);



}
