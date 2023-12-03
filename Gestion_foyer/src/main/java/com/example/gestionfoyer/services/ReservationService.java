package com.example.gestionfoyer.services;

import com.example.gestionfoyer.Entities.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> getAllReservations();

    Reservation getReservationById(String id);

    Reservation saveReservation(Reservation reservation);

    Reservation updateReservation(Reservation reservation);

    void deleteReservation(String id);

    public Reservation ajouterReservation2(long idChambre, long cinEtudiant) ;

    Reservation annulerReservation (Long cinEtudiant) ;

}
