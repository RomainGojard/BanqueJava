package fr.esgi.pret_a_la_consommation.business;

public class Duree {
    //attributs

    private long id;
    private int dureeEnMois;
    private static long compteur = 0L;

    public Duree(int dureeEnMois) {
        this.id = ++compteur;
        this.dureeEnMois = dureeEnMois;
    }

    /**
     * @return id du prêt : long
     */
    public long getId() {
        return id;
    } // id du prêt

    /**
     * @return (en mois) : int
     */
    public int getDureeEnMois() {
        return dureeEnMois;
    }

    @Override
    public String toString() {
        return dureeEnMois + " mois";
    }
}

