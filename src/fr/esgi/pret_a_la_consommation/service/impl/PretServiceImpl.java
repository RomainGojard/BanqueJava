package fr.esgi.pret_a_la_consommation.service.impl;

import fr.esgi.pret_a_la_consommation.business.Client;
import fr.esgi.pret_a_la_consommation.business.Pret;
import fr.esgi.pret_a_la_consommation.business.Taux;
import fr.esgi.pret_a_la_consommation.service.PretService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PretServiceImpl implements PretService {
    private static ArrayList<Pret> prets = new ArrayList<>();

    @Override
    public Pret ajouterPret(Pret pret) {
        prets.add(pret);
        return pret;
    }

    @Override
    public Pret ajouterPret(long montantDemande, LocalDateTime dateSouscription, String observations, Client client, Taux taux) {

        double interetAnnuel = (taux.getValeur()/100);
        double interetMensuel = interetAnnuel / 12;

        double montantMensualite = (montantDemande * interetMensuel) / (1 - Math.pow((1 + interetMensuel), -taux.getDuree().getDureeEnMois()));

        LocalDate dateEffet = null;

        Pret pret = new Pret(montantDemande, montantMensualite, dateSouscription, dateEffet, observations, client, taux );
        return ajouterPret(pret);
    }



}
