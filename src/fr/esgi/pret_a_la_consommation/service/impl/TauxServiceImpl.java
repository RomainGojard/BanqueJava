package fr.esgi.pret_a_la_consommation.service.impl;

import fr.esgi.pret_a_la_consommation.business.Duree;
import fr.esgi.pret_a_la_consommation.business.Motif;
import fr.esgi.pret_a_la_consommation.business.Taux;
import fr.esgi.pret_a_la_consommation.service.TauxService;

import java.util.ArrayList;

public class TauxServiceImpl implements TauxService {

    ArrayList<Taux> listTaux = new ArrayList<>();


    @Override
    public Taux ajouterTaux(Taux taux) {
        listTaux.add(taux);
        return taux;
    }

    @Override
    public Taux ajouterTaux(double valeur, Duree duree, Motif motif) {
        Taux taux = new Taux(valeur, duree, motif);
        return ajouterTaux(taux);
    }

    @Override
    public ArrayList<Taux> recupererLesTaux() {
        return listTaux;
    }

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

    @Override
    public String afficherLesTaux() {
        String affiche= "";
        for (Taux taux: listTaux
             ) {
            affiche += taux.toString() + "\n";

        }
        return affiche;
    }
}
