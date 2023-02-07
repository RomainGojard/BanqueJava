package fr.esgi.pret_a_la_consommation.business;

public class Duree {
    //attributs

    private long id;
    private int dureeEnMois;
    private static long compteur = 0L;

    public Duree(long id)
    {
        this.id = ++compteur;
    }

    /**
     *
     * @return id du prêt : long
     */
    public long getId() { return id; } // id du prêt

    /**
     *
     * @return (en mois) : int
     */
    public int getDureeEnMois() { return dureeEnMois; }

}
