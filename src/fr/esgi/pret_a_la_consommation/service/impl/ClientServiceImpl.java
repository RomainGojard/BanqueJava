package fr.esgi.pret_a_la_consommation.service.impl;

import fr.esgi.pret_a_la_consommation.business.Client;
import fr.esgi.pret_a_la_consommation.service.ClientService;

import java.util.ArrayList;

public class ClientServiceImpl implements ClientService {
    private static ArrayList<Client> clients = new ArrayList<>();

    /**
     * Création d'un client
     * @param nom du client à ajouter (String)
     * @param prenom du client à ajouter (String)
     * @return nouveau client
     */
    @Override
    public Client creerClient(String nom, String prenom){
        Client newClient = new Client(nom, prenom);
        clients.add(newClient);
        return newClient ;
    }

    /**
     * Récupération de la liste des clients
     * @return tous les clients de la liste
     */
    @Override
    public Client recupererClients() {
        for (Client client : clients) {
            return client;
        }
        return null;
    }

    /**
     * Récupération du client en fonction de son id
     *
     * @param id du client : long int
     * @return le client, ou une exception si pas de client correspondant à l'id fourni
     */
    @Override
    public Client recupererClient(long id){
        for (Client client : clients) {
            if (client.getId() == id) {
                return client;
            }
        }
        throw new IllegalArgumentException("L'id fourni ne correspond à aucun client");
    }
}
