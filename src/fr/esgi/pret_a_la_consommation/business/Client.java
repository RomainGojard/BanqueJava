package fr.esgi.pret_a_la_consommation.business;

import java.util.Comparator;

public class Client implements Comparator<Client> {
    /**
     * Classe qui définit les clients de notre banque
     * @author romaingojard
     */

    private long id;
    private String nom;
    private String prenom;
    private static long compteur = 0L;

    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.id = ++compteur;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    @Override
    public int compare(Client client1, Client client2) {
        return client1.getNom().compareTo(client2.getNom());
    }
}
