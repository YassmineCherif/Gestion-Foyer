package com.example.gestionfoyer.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Bloc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idBloc;

    String nomBloc;
    Long capaciteBloc;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idFoyer")
    @JsonIgnore
    Foyer foyers;

    @OneToMany(mappedBy = "blocs", fetch = FetchType.EAGER)
    @JsonIgnore
    Set<Chambre> chambres;

}

