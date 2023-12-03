package com.example.gestionfoyer.controllers;

import com.example.gestionfoyer.Entities.Foyer;
import com.example.gestionfoyer.services.FoyerService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foyer")
public class FoyerController {

    private  FoyerService foyerService;

    @GetMapping
    public List<Foyer> getAllFoyers() {
        return foyerService.getAllFoyers();
    }

    @GetMapping("/{id}")
    public Foyer getFoyerById(@PathVariable long id) {
        return foyerService.getFoyerById(id);
    }

    @PostMapping
    public Foyer saveFoyer(@RequestBody Foyer foyer) {
       return foyerService.addFoyer(foyer);
    }

    @PutMapping
    public Foyer updateFoyer( @RequestBody Foyer foyer) {

        return foyerService.updateFoyer(foyer);
    }


    @DeleteMapping("/{id}")
    public void deleteFoyer(@PathVariable long id) {

        foyerService.deleteFoyer(id);
    }


    @PostMapping("/{idUniversite}")
    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer, @PathVariable Long idUniversite) {
        return foyerService.ajouterFoyerEtAffecterAUniversite(foyer, idUniversite);
    }
}
