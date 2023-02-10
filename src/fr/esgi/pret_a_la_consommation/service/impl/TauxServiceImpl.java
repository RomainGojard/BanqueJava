package fr.esgi.pret_a_la_consommation.service.impl;

import fr.esgi.pret_a_la_consommation.business.Duree;
import fr.esgi.pret_a_la_consommation.business.Motif;
import fr.esgi.pret_a_la_consommation.business.Taux;
import fr.esgi.pret_a_la_consommation.service.TauxService;
import fr.esgi.pret_a_la_consommation.util.ComparateurDeTauxSurValeurDecroissante;

import java.util.ArrayList;
import java.util.Comparator;

public class TauxServiceImpl implements TauxService {

    ArrayList<Taux> listTaux = new ArrayList<>();

    /**
     * Ajoute un taux à la liste
     * @param taux objet Taux
     * @return taux ajouté
     */
    @Override
    public Taux ajouterTaux(Taux taux) {
        listTaux.add(taux);
        return taux;
    }

    /**
     * ajoute un taux à la liste selon les paramètres suivants
     * @param valeur double
     * @param duree objet Duree
     * @param motif objet Motif
     * @return
     */
    @Override
    public Taux ajouterTaux(double valeur, Duree duree, Motif motif) {
        Taux taux = new Taux(valeur, duree, motif);
        return ajouterTaux(taux);
    }

    /**
     *
     * @return liste des taux (ArrayList)
     */
    @Override
    public ArrayList<Taux> recupererLesTaux() {
        return listTaux;
    }

    /**
     * Récupère le taux en fonction de l'id
     * @param id long
     * @return taux - objet Taux
     */
    @Override
    public Taux recupererTaux(long id) {
        Taux tauxARetourner = null;
        for (Taux taux: listTaux
             ) {
            if (taux.getId() == id){
                tauxARetourner = taux;
                break;
            }
        }
        return tauxARetourner;
    }

    /**
     * affiche chacun des taux
     * @return objet Taux
     */
    @Override
    public String afficherLesTaux() {
        String affiche= "";
        for (Taux taux: listTaux
             ) {
            affiche += taux.toString() + "\n";

        }
        return affiche;
    }

    @Override
    public void trierTaux() {
        Comparator<Taux> comparator = new ComparateurDeTauxSurValeurDecroissante();
        listTaux.sort(comparator);
    }
}
