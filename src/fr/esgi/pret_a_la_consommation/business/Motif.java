package fr.esgi.pret_a_la_consommation.business;

public class Motif {

    //attributs
    private long id;
    private String nom;
    private String description;
    private static long compteur = 0L;

    //getters
    public long getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    public String getDescription() {
        return description;
    }
    public static long getCompteur() {
        return compteur;
    }

    //setters
    public void setId(long id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public static void setCompteur(long compteur) {
        Motif.compteur = compteur;
    }

    public Motif() {
        id = ++compteur;
    }
}
