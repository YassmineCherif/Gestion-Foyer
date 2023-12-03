package com.example.gestionfoyer.services;

import com.example.gestionfoyer.Entities.Foyer;

import java.util.List;

public interface FoyerService {

        List<Foyer> getAllFoyers();
    public Foyer addFoyer(Foyer foyer) ;


    Foyer getFoyerById(long id);

    Foyer updateFoyer( Foyer foyer);

    void deleteFoyer(long id);

     Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, long idUniversite) ;
}
