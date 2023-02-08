package fr.esgi.pret_a_la_consommation.service.impl;

import fr.esgi.pret_a_la_consommation.business.Mensualite;
import fr.esgi.pret_a_la_consommation.business.Pret;
import fr.esgi.pret_a_la_consommation.service.MensualiteService;

import java.util.ArrayList;

public class MensualiteServiceImpl implements MensualiteService {
    private static ArrayList<Mensualite> mensualites = new ArrayList<>();

    @Override
    public Mensualite ajouterMensualite(Mensualite mensualite) {
        mensualites.add(mensualite);
        return mensualite;
    }

    // TODO: 08/02/2023 - Créer la méthode qui crée toutes les mensualités d'un prêt
    
    @Override
    public ArrayList<Mensualite> ajouterMensualite(Pret pret) {
        // Liste qui contiendra toutes les mensualités de ce prêt, qui sera retournée dans le return
        ArrayList<Mensualite> mensualitesDuPret = new ArrayList<Mensualite>();

        // Nombre de mensualités pour le taux du prêt
        int nbMensualites = pret.getTaux().getDuree().getDureeEnMois();

        // captial du prêt demandé
        long capital = pret.getMontantDemande();

        // tauc annuel et mensuel du prêt
        double interetAnnuel = pret.getTaux().getValeur();
        double interetMensuel = interetAnnuel / nbMensualites;

        // montant de la mensualité définit lors de la création du prêt
        double mensualite = pret.getMontantMensualite();
        double partCapital = 0;
        double partInteret ;

        for (int i = 0; i < nbMensualites ; i++) {
            partInteret = (capital - partCapital) * interetMensuel;
            partCapital += mensualite - partInteret ;

            // TODO: 08/02/2023 : créer la mensualité, l'ajouter à la liste des mensualités et à la liste des mensualités du prêt
        }

        return mensualitesDuPret;
    }
}
