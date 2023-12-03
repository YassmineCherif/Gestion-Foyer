package com.example.gestionfoyer.services;

import com.example.gestionfoyer.Entities.Foyer;
import com.example.gestionfoyer.Entities.Universite;
import com.example.gestionfoyer.repositories.FoyerRepo;
import com.example.gestionfoyer.repositories.UniversiteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversiteServiceImpl implements UniversiteService {
     private UniversiteRepo universiteRepository;
     private FoyerRepo foyerRepository;

    @Override
    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite getUniversiteById(long id) {
        return universiteRepository.findById(id).orElse(null);
    }

    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite updateUniversite(Universite universite) {

            return universiteRepository.save(universite);
           }

    @Override
    public void deleteUniversite(long id) {
        universiteRepository.deleteById(id);
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);
        Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);

            universite.setFoyer(foyer);
            return universiteRepository.save(universite);
    }



    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);

        if (universite != null) {
            Foyer foyer = universite.getFoyer();

            if (foyer != null) {
                // Set the universite field in Foyer to null
                foyer.setUniversite(null);
                // Save the updated Foyer
                foyerRepository.save(foyer);

                // Set the foyer field in Universite to null
                universite.setFoyer(null);
                // Save the updated Universite
                universiteRepository.save(universite);

                return universite;
            }
        }

        return null;
    }






    }



