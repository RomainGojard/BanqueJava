package fr.esgi.pret_a_la_consommation.util;

import fr.esgi.pret_a_la_consommation.business.Pret;
import fr.esgi.pret_a_la_consommation.business.Taux;

import java.util.Comparator;

public class ComparateurDePretParTaux implements Comparator<Pret> {

    /**
     * Comparateur de 2 prêts selon leur taux. On fait appel à notre autre comparateur sur les taux.
     *
     * @param pret1 the first object to be compared.
     * @param pret2 the second object to be compared.
     * @return Le pret avec le taux le plus élevé
     */
    @Override
    public int compare(Pret pret1, Pret pret2) {
        Comparator<Taux> comparator = new ComparateurDeTauxSurValeurDecroissante();
        return comparator.compare(pret2.getTaux(), pret1.getTaux());
    }
}
