package fr.esgi.pret_a_la_consommation.service;

import fr.esgi.pret_a_la_consommation.business.Client;
import fr.esgi.pret_a_la_consommation.business.Pret;
import fr.esgi.pret_a_la_consommation.business.Taux;

import java.time.LocalDate;
import java.util.ArrayList;

public interface PretService {

    Pret ajouterPret(Pret pret);

    Pret ajouterPret(long montantDemande, LocalDate dateEffet, String observations, Client client, Taux taux);

    // TODO: 09/02/2023 - Méthode recupererPrets , recupererPretsTrierSur(String) --> utiliser un comparateur dans la classe util pour ça  , afficherPret

    Pret recupererPret(long id);

    ArrayList<Pret> recupererPrets();
    void trierPrets(String critere);

    String afficherInformationsPret(Pret pret);

    String afficherChaquePret();



}

