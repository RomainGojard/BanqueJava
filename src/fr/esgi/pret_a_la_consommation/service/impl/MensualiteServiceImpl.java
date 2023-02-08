package fr.esgi.pret_a_la_consommation.service.impl;

import fr.esgi.pret_a_la_consommation.business.Mensualite;
import fr.esgi.pret_a_la_consommation.business.Pret;
import fr.esgi.pret_a_la_consommation.service.MensualiteService;

import java.util.ArrayList;

public class MensualiteServiceImpl implements MensualiteService {
    private static ArrayList<Mensualite> mensualites = new ArrayList<>();

    @Override
    public Mensualite ajouterMensualite(Mensualite mensualite) {
        mensualites.add(mensualite);
        return mensualite;
    }

    // TODO: 08/02/2023 - Créer la méthode qui crée toutes les mensualités d'un prêt 
    
    @Override
    public Mensualite ajouterMensualite(Pret pret) {
        int nbMensualite = pret.getTaux().getDuree().getDureeEnMois();

        Mensualite mensualite = null;
        
        return mensualite;
    }
}
