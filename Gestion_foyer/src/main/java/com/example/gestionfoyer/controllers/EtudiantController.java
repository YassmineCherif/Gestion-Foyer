package com.example.gestionfoyer.controllers;

import com.example.gestionfoyer.Entities.*;
import com.example.gestionfoyer.services.EtudiantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {

    private  EtudiantService etudiantService;


    @GetMapping
    public List<Etudiant> getAllEtudiants() {

        return etudiantService.getAllEtudiants();
    }

    @GetMapping("/{id}")
    public Etudiant getEtudiantById(@PathVariable long id) {
        return etudiantService.getEtudiantById(id);
    }

    @PostMapping
    public List<Etudiant> saveEtudiant(@RequestBody List<Etudiant> etudiants) {
        return etudiantService.addEtudiant(etudiants);
    }


    @PutMapping
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {

        return etudiantService.updateEtudiant(etudiant);
    }



    @DeleteMapping("/{id}")
    public void deleteEtudiant(@PathVariable long id) {

        etudiantService.deleteEtudiant(id);
    }

}

