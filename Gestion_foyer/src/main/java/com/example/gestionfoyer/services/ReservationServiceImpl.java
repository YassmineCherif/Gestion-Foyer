package com.example.gestionfoyer.services;

import com.example.gestionfoyer.Entities.Etudiant;
import com.example.gestionfoyer.Entities.Reservation;
import com.example.gestionfoyer.Entities.Chambre;

import com.example.gestionfoyer.repositories.ChambreRepo;
import com.example.gestionfoyer.repositories.EtudiantRepo;
import com.example.gestionfoyer.repositories.ReservationRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
     ReservationRepo reservationRepository;

    EtudiantRepo etudiantRepository;
    ChambreRepo chambreRepository;

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(String id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {

            return reservationRepository.save(reservation);
        }

    @Override
    public void deleteReservation(String id) {

        reservationRepository.deleteById(id);
    }


    @Override
    public Reservation ajouterReservation2(long idChambre, long cinEtudiant) {
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant).orElseThrow(() -> new IllegalArgumentException("L'etudiant n'existe pas"));

        //il faut que l'etudiant ne dispose pas de res au cours de l'année courante
        Assert.isTrue(!reservationRepository.existsByEtudiants_CinAndAnneeUniversitaireBetween(cinEtudiant
                        , LocalDate.of(LocalDate.now().getYear(),1,1)
                        ,LocalDate.of(LocalDate.now().getYear(),12,31))
                ,"l'etudiant dispose deja d'une reservation");

        Chambre chambre = chambreRepository.findById(idChambre).orElseThrow(() -> new IllegalArgumentException("chambre n'existe pas"));

        String id=chambre.getNumeroChambre()+'-'+chambre.getBlocs().getNomBloc()+'-'+LocalDate.now().getYear();
        Reservation reservation =reservationRepository.findById(id)
                .orElse(
                        Reservation.builder()
                                .idReservation(id)
                                .anneeUniversitaire(LocalDate.now())
                                .etudiants(new HashSet<>())
                                .estValide(true)
                                .build());


        //si la reservation n'est pas valide , il va lancer une exception
        Assert.isTrue(reservation.isEstValide(),"la chambre est saturée");
        //si la reservation est valide , on va ajouter l'etudiant au set des Etudiants dans reservation
        reservation.getEtudiants().add(etudiant);

        //si la reservation est nouvelle
        if(!chambre.getReservations().contains(reservation))
        {
            //enregistrer la nouvelle reservation et l'affecter à l'ancienne reservation(bch twali l'objet reservation managed entity et les modifications d'après s'effectueront à travers transactional)
            //--->recuperer le retour de .save w nraj3ou f l'objet reservation eli nekhdem alih
            reservation=reservationRepository.save(reservation);
            //l'ajouter au set des reservations au niveau de la chambre
            chambre.getReservations().add(reservation);
        }
        //on va modifier l'attribut isValid selon le type de la chambre et size du set Etudiant
        switch (chambre.getTypeC())
        {
            case SIMPLE -> reservation.setEstValide(false);
            case DOUBLE -> {if (reservation.getEtudiants().size()==2) {reservation.setEstValide(false);}}
            case TRIPLE -> {if (reservation.getEtudiants().size()==3) {reservation.setEstValide(false);}}
        }
        return reservation;


    }


    @Override
    public Reservation annulerReservation(Long cinEtudiant) {
        // Trouver l'étudiant et sa réservation
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant).orElseThrow(() -> new IllegalArgumentException("L'etudiant n'existe pas"));

        // Supposition: chaque étudiant a au maximum une réservation valide
        Reservation reservation = etudiant.getReservations().stream()
                .filter(Reservation::isEstValide)
                .findFirst()
                .orElse(null);

        // Mettre à jour l'état de la réservation
        reservation.setEstValide(false);

        // Désaffecter l'étudiant
        reservation.getEtudiants().remove(etudiant);

        // Désaffecter la chambre associée et mettre à jour sa capacité
        Chambre chambreAssociee = chambreRepository.findByReservationsContains(reservation);
        if (chambreAssociee != null) {
            chambreAssociee.getReservations().remove(reservation);
            chambreRepository.save(chambreAssociee); // Sauvegarder les changements dans la chambre
        }

        // Sauvegarder les modifications
        return reservationRepository.save(reservation);
    }



}