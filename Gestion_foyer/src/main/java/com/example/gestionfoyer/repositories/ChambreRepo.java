package com.example.gestionfoyer.repositories;

import com.example.gestionfoyer.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChambreRepo extends JpaRepository<Chambre, Long> {

    @Query("SELECT c FROM Chambre c WHERE c.blocs.idBloc = :idBloc AND c.typeC = :typeC")
    List<Chambre> getChambresParBlocEtType(Long idBloc, TypeChambre typeC);

    //Solution 2
    List<Chambre> findByBlocsIdBlocAndTypeC(Long idBloc, TypeChambre typeC);

    Chambre findByReservationsContains(Reservation reservation);


    List<Chambre> findByBlocsFoyersUniversiteNomUniversite (String nomUniversite);



    //findByBlocFoyerUniversiteNomUniversite
}
