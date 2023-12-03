package com.example.gestionfoyer.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;
@Getter
@Setter
@Entity
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     long idEtudiant;
     String nomEt;
     String prenomEt;
     long cin;
     String ecole;
     Date dateNaissance;

    @ManyToMany(mappedBy="etudiants")
    @JsonIgnore
     Set<Reservation> reservations ;
}
