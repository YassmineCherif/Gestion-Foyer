package com.example.gestionfoyer.services;

import com.example.gestionfoyer.Entities.Bloc;

import java.util.List;

public interface BlocService {
    Bloc addBloc(Bloc bloc);
    List<Bloc> getAllBlocs();

    Bloc getBlocById(long id);

    Bloc updateBloc( Bloc bloc);

    void deleteBloc(long id);
    Bloc affecterChambresABloc(List<Long> numChambre, long   idBloc) ;
    Bloc affecterBlocAFoyer(Long idBloc, Long idFoyer) ;
}
