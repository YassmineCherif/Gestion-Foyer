package com.example.gestionfoyer.services;

import com.example.gestionfoyer.Entities.Chambre;
import com.example.gestionfoyer.Entities.TypeChambre;

import java.util.List;

public interface ChambreService {
    Chambre addChambre(Chambre chambre);
    List<Chambre> getAllChambres();

    Chambre getChambreById(long id);


    Chambre updateChambre(Chambre chambre);

    void deleteChambre(long id);
    List<Chambre> getChambresParBlocEtType (Long idBloc, TypeChambre typeC) ;

    public List<Chambre> getChambresParNomUniversite( String nomUniversite);
}
