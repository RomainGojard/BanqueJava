package fr.esgi.pret_a_la_consommation.service;

import fr.esgi.pret_a_la_consommation.business.Client;
import fr.esgi.pret_a_la_consommation.business.Pret;
import fr.esgi.pret_a_la_consommation.business.Taux;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public interface PretService {

    Pret ajouterPret(Pret pret);

    Pret ajouterPret(long montantDemande, LocalDateTime dateSouscription, String observations, Client client, Taux taux);
}
