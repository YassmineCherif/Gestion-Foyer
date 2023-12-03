package com.example.gestionfoyer.services;

import com.example.gestionfoyer.Entities.Foyer;
import com.example.gestionfoyer.Entities.Universite;
import com.example.gestionfoyer.repositories.FoyerRepo;
import com.example.gestionfoyer.repositories.UniversiteRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoyerServiceImpl implements FoyerService {
    @Autowired
     FoyerRepo foyerRepository;
    @Autowired
    UniversiteRepo universiteRepository;


    @Override
    public List<Foyer> getAllFoyers() {

        return foyerRepository.findAll();
    }

    @Override
    public Foyer getFoyerById(long id) {

        return foyerRepository.findById(id).orElse(null);
    }

    @Override
    public Foyer addFoyer(Foyer foyer) {

        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer updateFoyer( Foyer foyer) {

            return foyerRepository.save(foyer);
        }


    @Override
    public void deleteFoyer(long id) {
        foyerRepository.deleteById(id);
    }

        @Override
        public Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, long idUniversite) {
            Universite universite = universiteRepository.findById(idUniversite).orElseThrow(() -> new EntityNotFoundException("Universite not found "));

            //Assign universite to foyer
            foyer.setUniversite(universite);

            //parcourir les blocs w nhotoulhom foyers
            if (foyer.getBlocs() != null) {
                foyer.getBlocs().forEach(bloc -> bloc.setFoyers(foyer));
            }

            // Save
             foyerRepository.save(foyer);
            return foyer;
        }



}

