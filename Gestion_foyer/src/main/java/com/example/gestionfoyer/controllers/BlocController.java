package com.example.gestionfoyer.controllers;

import com.example.gestionfoyer.Entities.Bloc;
import com.example.gestionfoyer.services.BlocService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bloc")
public class BlocController {
    private BlocService blocService;

    @PostMapping("/add")
    public Bloc addBloc(@RequestBody Bloc bloc) {

        return blocService.addBloc(bloc);
    }


    @GetMapping
    public List<Bloc> getAllBlocs() {
        return blocService.getAllBlocs();
    }

    @GetMapping("/{id}")
    public Bloc getBlocById(@PathVariable long id) {
        return blocService.getBlocById(id);
         }




    @PutMapping
    public Bloc updateBloc(@RequestBody Bloc bloc) {

        return blocService.updateBloc(bloc);
    }


    @DeleteMapping("/{id}")
    public void deleteBloc(@PathVariable long id) {

        blocService.deleteBloc(id);
    }


    @PostMapping("/{idBloc}")
    public Bloc affecterChambresABloc(@RequestBody List<Long> numChambre, @PathVariable long idBloc) {
        return blocService.affecterChambresABloc(numChambre, idBloc);
    }

    @PutMapping("/{idBloc}/{idFoyer}")
    public Bloc affecterBlocAFoyer(@PathVariable Long idBloc, @PathVariable Long idFoyer) {
        return blocService.affecterBlocAFoyer(idBloc, idFoyer);
    }

}
