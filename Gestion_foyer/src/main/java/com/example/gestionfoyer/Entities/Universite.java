package com.example.gestionfoyer.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     long idUniversite;
     String nomUniversite;
     String adresse;



    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idFoyer")
    @JsonIgnore
    Foyer foyer;

}
