package fr.esgi.pret_a_la_consommation.service.impl;

import fr.esgi.pret_a_la_consommation.business.Client;
import fr.esgi.pret_a_la_consommation.business.Pret;
import fr.esgi.pret_a_la_consommation.business.Taux;
import fr.esgi.pret_a_la_consommation.exceptions.MontantExcessifException;
import fr.esgi.pret_a_la_consommation.service.PretService;
import fr.esgi.pret_a_la_consommation.util.ComparateurDePretParMontant;
import fr.esgi.pret_a_la_consommation.util.ComparateurDePretParTaux;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PretServiceImpl implements PretService {
    private static ArrayList<Pret> prets = new ArrayList<>();


    /**
     * @param pret
     * @return
     * @throws MontantExcessifException
     * @author Y-Vector
     */
    /**
     * Ajout d'un prêt
     *
     * @param pret à ajouter
     * @return pret ajouté
     * @throws MontantExcessifException
     */
    @Override
    public Pret ajouterPret(Pret pret) throws MontantExcessifException {

        if (pret.getMontantMensualite() >= 20000) {
            throw new MontantExcessifException("Le prêt ne doit pas excéder 20000 euros.");
        }
        prets.add(pret);
        return pret;
    }

    /**
     * Ajout d'un prêt défini par les paramètres suivants :
     *
     * @param montantDemande long
     * @param dateEffet      LocalDate
     * @param observations   String
     * @param client         objet Client
     * @param taux           objet Taux
     * @return ajouterPret(pret)
     */
    @Override
    public Pret ajouterPret(long montantDemande, LocalDate dateEffet, String observations, Client client, Taux taux) {

        double interetAnnuel = (taux.getValeur() / 100);
        double interetMensuel = interetAnnuel / 12;
        LocalDateTime dateSouscription = LocalDateTime.now();

        double montantMensualite = (montantDemande * interetMensuel) / (1 - Math.pow((1 + interetMensuel), -taux.getDuree().getDureeEnMois()));

        Pret pret = new Pret(montantDemande, montantMensualite, dateSouscription, dateEffet, observations, client, taux);
        return ajouterPret(pret);
    }

    /**
     * Récupère le prêt en fonction de l'id
     *
     * @param id long
     * @return pret trouvé ou null
     */
    @Override
    public Pret recupererPret(long id) {
        Pret pretARenvoyer = null;

        for (Pret pret : prets
        ) {
            if (pret.getId() == id) {
                pretARenvoyer = pret;
            }
        }

        return pretARenvoyer;
    }

    /**
     * @return prets sous forme d'ArrayList
     */
    @Override
    public ArrayList<Pret> recupererPrets() {
        return prets;
    }

    /**
     * trie les prets selon le montant et par taux
     *
     * @param critere String
     * @return
     */
    @Override
    public void trierPrets(String critere) {
        Comparator<Pret> comparator = null;
        if (critere.equals("montant")) {
            comparator = new ComparateurDePretParMontant();
        } else if (critere.equals("taux")) {
            comparator = new ComparateurDePretParTaux();
        }
        prets.sort(comparator);
    }

    /**
     * @param pret
     * @return informations du pret en String
     */
    @Override
    public String afficherInformationsPret(Pret pret) {
        return "id : " + pret.getId() + ", client : " + pret.getClient().getPrenom() + " " + pret.getClient().getNom() + ", montant emprunté : " + pret.getMontantDemande() + ", mensualité : " + pret.getMontantMensualite() + ", taux : " + pret.getTaux().getValeur();
    }

    /**
     * @return liste avec chacun des prets en String
     */
    @Override
    public String afficherChaquePret() {
        String affiche = "";
        for (Pret pret : prets) {
            affiche += afficherInformationsPret(pret) + "\n";
        }
        return affiche;
    }
}
