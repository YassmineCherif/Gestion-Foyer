package com.example.gestionfoyer.controllers;

import com.example.gestionfoyer.Entities.Universite;
import com.example.gestionfoyer.services.UniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/universite")
public class UniversiteController {

    private UniversiteService universiteService;

    @GetMapping
    public List<Universite> getAllUniversites() {
        return universiteService.getAllUniversites();
    }

    @GetMapping("/{id}")
    public Universite getUniversiteById(@PathVariable long id) {
        return universiteService.getUniversiteById(id);
    }

    @PostMapping
    public Universite saveUniversite(@RequestBody Universite universite) {
        return universiteService.addUniversite(universite);
    }


    @PutMapping
    public Universite updateEtudiant(@RequestBody Universite universite) {
        return universiteService.updateUniversite(universite);
    }


    @DeleteMapping("/{id}")
    public void deleteUniversite(@PathVariable long id) {
        universiteService.deleteUniversite(id);
    }

    @PostMapping("/affecter-foyer")
    public Universite affecterFoyerAUniversite(@RequestParam long idFoyer, @RequestParam String nomUniversite) {
        return universiteService.affecterFoyerAUniversite(idFoyer, nomUniversite);
    }

    @PutMapping("/{idUniversite}")
    public Universite desaffecterFoyerAUniversite(@PathVariable long idUniversite) {
        return universiteService.desaffecterFoyerAUniversite(idUniversite);
    }
}
