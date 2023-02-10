package fr.esgi.pret_a_la_consommation.service;

import fr.esgi.pret_a_la_consommation.business.Duree;
import fr.esgi.pret_a_la_consommation.business.Motif;
import fr.esgi.pret_a_la_consommation.business.Taux;

import java.util.ArrayList;

public interface TauxService {

    Taux ajouterTaux( Taux taux );

    /**
     *
     * @param valeur
     * @param duree
     * @param motif
     * @return
     */
    Taux ajouterTaux(double valeur, Duree duree, Motif motif );

    ArrayList<Taux> recupererLesTaux();

    Taux recupererTaux(long id);

    String afficherLesTaux();

    void trierTaux();
}
