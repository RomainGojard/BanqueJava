package fr.esgi.pret_a_la_consommation.service;

import fr.esgi.pret_a_la_consommation.business.Mensualite;
import fr.esgi.pret_a_la_consommation.business.Pret;

import java.util.ArrayList;

public interface MensualiteService {

    Mensualite ajouterMensualite (Mensualite mensualite);

    ArrayList<Mensualite> creerMensualitesDuPret(Pret pret);

    String afficherMensualitesDuPret(Pret pret);

}
