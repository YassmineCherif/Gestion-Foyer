package com.example.gestionfoyer.services;

import com.example.gestionfoyer.Entities.Etudiant;

import java.util.List;

public interface EtudiantService {
    List<Etudiant> getAllEtudiants();


    Etudiant getEtudiantById(long id);

    List<Etudiant> addEtudiant(List<Etudiant> etudiants);


    Etudiant updateEtudiant(Etudiant etudiant);

    void deleteEtudiant(long id);
}
