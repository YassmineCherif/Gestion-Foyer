package com.example.gestionfoyer.services;

import com.example.gestionfoyer.Entities.*;
import com.example.gestionfoyer.repositories.ChambreRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChambreServiceImpl implements ChambreService {

    private ChambreRepo chambreRepository;

    @Override
    public Chambre addChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> getAllChambres() {

        return chambreRepository.findAll();
    }

    @Override
    public Chambre getChambreById(long id) {

        return chambreRepository.findById(id).orElse(null);
    }



    @Override
    public Chambre updateChambre(Chambre chambre) {
            return chambreRepository.save(chambre);
       }

    @Override
    public void deleteChambre(long id) {

        chambreRepository.deleteById(id);
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(Long idBloc, TypeChambre typeC) {
        return chambreRepository.getChambresParBlocEtType(idBloc, typeC);  //Solution 1
    }

@Override
    public List<Chambre> getChambresParNomUniversite( String nomUniversite){
    return chambreRepository.findByBlocsFoyersUniversiteNomUniversite(nomUniversite);


    }

}

