package fr.esgi.pret_a_la_consommation.business;

import java.util.Comparator;

public class Client implements Comparator<Client> {
    /**
     * Classe qui définit les clients de notre banque
     */

    private long id;
    private String nom;
    private String prenom;
    private static long compteur = 0L;

    /**
     * Constructeur d'un client
     *
     * @param nom
     * @param prenom
     * @author romaingojard
     */
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

    public long getId() {
        return id;
    }

    /**
     * Comparateur sur le nom des clients
     *
     * @param client1 the first object to be compared.
     * @param client2 the second object to be compared.
     * @return
     */
    @Override
    public int compare(Client client1, Client client2) {
        return client1.getNom().compareTo(client2.getNom());
    }

    @Override
    public String toString() {
        return id +
                ". " + nom +
                " " + prenom + '\n';
    }
}
