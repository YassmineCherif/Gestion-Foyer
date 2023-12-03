package com.example.gestionfoyer.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder

public class Reservation  {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
     String idReservation;

    @Temporal(TemporalType.DATE)
    LocalDate anneeUniversitaire;

     boolean estValide;

     @JsonIgnore
    @ManyToMany
    Set<Etudiant> etudiants;
}
