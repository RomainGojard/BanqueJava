package fr.esgi.pret_a_la_consommation.business;

import java.util.Comparator;

public class Taux implements Comparator<Taux> {
    //attributs

    private long id;
    private double valeur;
    private static long compteur = 0L;

    /**
     * Constructeur d'un taux
     * @param valeur Valeur du taux du prêt
     * @author romaingojard
     */
    public Taux(double valeur) {
        this.id = ++compteur;
        this.valeur = valeur;
    }

    public long getId() {
        return id;
    }

    public double getValeur() {
        return valeur;
    }

    /**
     *
     * @return to string
     * @author romaingojard
     */
    @Override
    public String toString() {
        return "Taux{" +
                "valeur=" + valeur +
                '}';
    }

    @Override
    public int compare(Taux o1, Taux o2) {
        return 0;
    }
}
