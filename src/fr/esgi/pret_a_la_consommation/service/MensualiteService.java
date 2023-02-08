package fr.esgi.pret_a_la_consommation.service;

import fr.esgi.pret_a_la_consommation.business.Mensualite;
import fr.esgi.pret_a_la_consommation.business.Pret;

public interface MensualiteService {

    Mensualite ajouterMensualite (Mensualite mensualite);

    Mensualite ajouterMensualite (Pret pret);
}
