package fr.esgi.pret_a_la_consommation.business;

import java.util.Comparator;

public class Taux implements Comparator<Taux> {
    //attributs

    private final long id;
    private double valeur;
    private static long compteur = 0L;
    private Duree duree;
    private Motif motif;

    /**
     * Constructeur d'un taux
     *
     * @param valeur Valeur du taux du prêt
     * @param duree  Durée sur lequel le taux est associé
     * @param motif  Motif asssocié au taux
     * @author romaingojard
     */
    public Taux(double valeur, Duree duree, Motif motif) {
        this.id = ++compteur;
        this.valeur = valeur;
        this.duree = duree;
        this.motif = motif;
    }

    public long getId() {
        return id;
    }

    public double getValeur() {
        return valeur;
    }

    public Duree getDuree() {
        return duree;
    }

    public Motif getMotif() {
        return motif;
    }


    @Override
    public String toString() {
        return "id : " + id + ", " +
                " à " + valeur +
                "% sur " + duree.toString() +
                " " + motif.toString();
    }


    /**
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return
     */
    @Override
    public int compare(Taux o1, Taux o2) {

        return 0;
    }

    /*@Override
    public int compareTo(Carte autreCarte) {
        return ((Integer) getValeur()).compareTo(autreCarte.getValeur());*/
}
