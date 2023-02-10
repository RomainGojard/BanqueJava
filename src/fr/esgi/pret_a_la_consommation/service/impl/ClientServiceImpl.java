package fr.esgi.pret_a_la_consommation.service.impl;

import fr.esgi.pret_a_la_consommation.business.Client;
import fr.esgi.pret_a_la_consommation.business.Mensualite;
import fr.esgi.pret_a_la_consommation.business.Pret;
import fr.esgi.pret_a_la_consommation.service.ClientService;

import java.time.LocalDate;
import java.util.ArrayList;

public class ClientServiceImpl {
    private static ArrayList<Client> clients = new ArrayList<>();

    @Override
    public Client creerClient(String nom, String prenom){
        Client newClient = new Client(nom, prenom);
        clients.add(newClient);
        return newClient ;
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
