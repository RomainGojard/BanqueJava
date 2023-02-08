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

        // TODO: 08/02/2023 - définir le montant de chaque mensualité selon le taux en paramètre, définir la date d'effet (1er jour du prochain mois) et lancer al création de mensualité

        long montantMensualite = 0 ;
        LocalDate dateEfet = null;

        Pret pret = new Pret(montantDemande, montantMensualite, dateSouscription, dateEfet, observations, client, taux );
        prets.add(pret);



        return pret;

    }
}
