package fr.esgi.pret_a_la_consommation.service;

import fr.esgi.pret_a_la_consommation.business.Client;

public interface ClientService {

    // TODO: 09/02/2023 - Créer la classe ClientServiceImpl et créer les méthodes ci-dessous

    public Client creerClient(String nom, String prenom);

    public Client recupererClients(long id);





}
