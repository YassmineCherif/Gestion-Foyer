package com.example.gestionfoyer.services;

import com.example.gestionfoyer.Entities.Bloc;
import com.example.gestionfoyer.Entities.Chambre;
import com.example.gestionfoyer.Entities.Foyer;
import com.example.gestionfoyer.repositories.BlocRepo;
import com.example.gestionfoyer.repositories.ChambreRepo;
import com.example.gestionfoyer.repositories.FoyerRepo;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class BlocServiceImpl implements BlocService {
    private BlocRepo blocRepository;
    ChambreRepo chambreRepository;
    private FoyerRepo foyerRepository;

    @Override
    public Bloc addBloc(Bloc bloc) {

        return blocRepository.save(bloc);
    }


    @Override
    public List<Bloc> getAllBlocs() {

        return blocRepository.findAll();
    }

    @Override
    public Bloc getBlocById(long id) {

        return blocRepository.findById(id).orElse(null);
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {

        return blocRepository.save(bloc);
    }

    @Override
    public void deleteBloc(long id) {

        blocRepository.deleteById(id);
    }
    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);

        if (bloc != null) {
            List<Chambre> chambres = chambreRepository.findAllById(numChambre);

            // bch yparcouri liste chambres w kol objet chambre bch yhot fih bloc (setBlocs)
            chambres.forEach(chambre -> chambre.setBlocs(bloc));
           // we should Save the updated chambres
            chambreRepository.saveAll(chambres);

            //taw bch nhotou liste mtaa chambres li zedna setBlocs f objet bloc

           // naamlou hashset bch ynahiti les chambres li yetaawdou w nsoboha f bloc
            bloc.setChambres(new HashSet<>(chambres));
            // Save the updated bloc
            blocRepository.save(bloc);
        }
        return bloc;
    }

    @Override
    public Bloc affecterBlocAFoyer(Long idBloc, Long idFoyer) {
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);

        if (bloc != null) {
            Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);

            if (foyer != null) {
                bloc.setFoyers(foyer);
                blocRepository.save(bloc);
            } else {
                // Handle the case where foyer is null, log an error, throw an exception, or handle it as appropriate for your application.
            }
        } else {
            // Handle the case where bloc is null, log an error, throw an exception, or handle it as appropriate for your application.
        }

        return bloc;
    }

}