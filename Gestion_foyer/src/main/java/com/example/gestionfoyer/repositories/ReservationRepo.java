package com.example.gestionfoyer.repositories;

import com.example.gestionfoyer.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, String> {
    boolean existsByEtudiants_CinAndAnneeUniversitaireBetween(long cin, LocalDate anneeUniversitaire, LocalDate anneeUniversitaire2);



}

