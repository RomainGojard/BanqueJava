package fr.esgi.pret_a_la_consommation.service.impl;

import fr.esgi.pret_a_la_consommation.business.Mensualite;
import fr.esgi.pret_a_la_consommation.business.Pret;
import fr.esgi.pret_a_la_consommation.service.MensualiteService;

import java.time.LocalDate;
import java.util.ArrayList;


public class MensualiteServiceImpl implements MensualiteService {
    private static ArrayList<Mensualite> mensualites = new ArrayList<>();

    @Override
    public Mensualite ajouterMensualite(Mensualite mensualite) {
        mensualites.add(mensualite);
        return mensualite;
    }

    // TODO: 08/02/2023 - Créer la méthode qui crée toutes les mensualités d'un prêt

    /**
     * Méthode qui crée toutes les mensualités du prêt avec leur date et part de capital / intérêt
     * @param pret Le prêt auquel est associée la mensualité
     * @return La liste des mensualités pour ce prêt
     */
    @Override
    public ArrayList<Mensualite> creerMensualitesDuPret(Pret pret) {
        // Liste qui contiendra toutes les mensualités de ce prêt, qui sera retournée dans le return
        ArrayList<Mensualite> mensualitesDuPret = new ArrayList<>();

        // Nombre de mensualités pour le taux du prêt
        int nbMensualites = pret.getTaux().getDuree().getDureeEnMois();

        // captial du prêt demandé
        long capital = pret.getMontantDemande();

        // taux annuel et mensuel du prêt
        double interetAnnuel = pret.getTaux().getValeur();
        double interetMensuel = interetAnnuel / 12;

        // montant de la mensualité définit lors de la création du prêt
        double montantMensualite = pret.getMontantMensualite();

        // variables de boucle qui serviront pour créer les mensualités et les ajouter dans les listes
        double partCapital = 0;
        double partInteret ;
        LocalDate datePrelevement = pret.getDateEffet();
        Mensualite mensualite;

        // on créé une mensualité par nombre de mois
        for (int i = 0; i < nbMensualites ; i++) {

            // calcul de la part d'interêt pour la mensualité courante
            partInteret = (capital - partCapital) * interetMensuel;

            // calcul de la part cpaital pour la mensualité courante
            partCapital += montantMensualite - partInteret ;

            // incrémentation de la date sur le mois (ou l'année si le dernier mois de l'année)
            if (datePrelevement.getMonth().getValue() == 12){
                datePrelevement = LocalDate.of(datePrelevement.getYear() + 1 ,1, datePrelevement.getDayOfMonth());
            }else {
                datePrelevement = LocalDate.of(datePrelevement.getYear(), datePrelevement.getMonth().getValue() + 1, datePrelevement.getDayOfMonth());
            }

            // création de la mensualité
            mensualite = new Mensualite(datePrelevement, partInteret, partCapital, pret);

            // ajout de la mensualités dans les listes
            mensualites.add(mensualite);
            mensualitesDuPret.add(mensualite);

        }

        return mensualitesDuPret;
    }
}
