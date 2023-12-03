package com.example.gestionfoyer.services;

import com.example.gestionfoyer.Entities.Universite;

import java.util.List;

public interface UniversiteService {
    List<Universite> getAllUniversites();
    Universite getUniversiteById(long id);
    Universite addUniversite(Universite universite);
    Universite updateUniversite(Universite universite);
    void deleteUniversite(long id);
    Universite affecterFoyerAUniversite (long idFoyer, String  nomUniversite) ;
    public Universite desaffecterFoyerAUniversite(long idUniversite);
}
