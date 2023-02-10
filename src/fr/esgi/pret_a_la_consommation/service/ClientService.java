package fr.esgi.pret_a_la_consommation.service;

import fr.esgi.pret_a_la_consommation.business.Client;

public interface ClientService {

    public Client creerClient(String nom, String prenom);

    public Client recupererClient(long id);

    public String afficherClients();

}
