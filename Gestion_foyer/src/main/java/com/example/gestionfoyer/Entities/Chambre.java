package com.example.gestionfoyer.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   long idChambre;

     long numeroChambre;

    @Enumerated(EnumType.STRING)
     TypeChambre typeC;

    @OneToMany(cascade = CascadeType.ALL)
    Set<Reservation> reservations;
    @ManyToOne
    @JsonIgnore
     Bloc blocs;

}
