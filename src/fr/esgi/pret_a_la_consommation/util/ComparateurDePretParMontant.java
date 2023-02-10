package fr.esgi.pret_a_la_consommation.util;

import fr.esgi.pret_a_la_consommation.business.Pret;

import java.util.Comparator;

public class ComparateurDePretParMontant implements Comparator<Pret> {
    /**
     * @param pret1 the first object to be compared.
     * @param pret2 the second object to be compared.
     * @return comparaison de deux montants de prets de manière décroissante
     * @author alexisbarreyre
     */
    @Override
    public int compare(Pret pret1, Pret pret2) {
        return (Long.compare((pret2.getMontantDemande()), pret1.getMontantDemande()));
    }
}
