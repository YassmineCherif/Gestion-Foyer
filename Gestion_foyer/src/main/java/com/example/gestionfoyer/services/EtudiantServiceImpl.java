package com.example.gestionfoyer.services;

import com.example.gestionfoyer.Entities.Etudiant;
import com.example.gestionfoyer.repositories.EtudiantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantServiceImpl implements EtudiantService {
    @Autowired
    private EtudiantRepo etudiantRepository;

    @Override
    public List<Etudiant> getAllEtudiants() {

        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant getEtudiantById(long id) {

        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public List<Etudiant> addEtudiant(List<Etudiant> etudiants)
    {
        return etudiantRepository.saveAll(etudiants);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {

            return etudiantRepository.save(etudiant);
        }


    @Override
    public void deleteEtudiant(long id) {

        etudiantRepository.deleteById(id);
    }


}
