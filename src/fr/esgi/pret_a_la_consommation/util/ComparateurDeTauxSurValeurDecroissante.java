package fr.esgi.pret_a_la_consommation.util;

import fr.esgi.pret_a_la_consommation.business.Taux;

import java.util.Comparator;

public class ComparateurDeTauxSurValeurDecroissante implements Comparator<Taux> {
    /**
     *
     * @param taux1 the first object to be compared.
     * @param taux2 the second object to be compared.
     * @return comparaison de deux taux de manière décroissante
     * @author romaingojard
     */
    /**
     * @param taux1 the first object to be compared.
     * @param taux2 the second object to be compared.
     * @return
     */
    @Override
    public int compare(Taux taux1, Taux taux2) {
        return (Double.compare((taux2.getValeur()), taux1.getValeur()));
    }
}
