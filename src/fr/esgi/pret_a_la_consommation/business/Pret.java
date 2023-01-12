package fr.esgi.pret_a_la_consommation.business;

import java.time.LocalDate;
import java.time.LocalTime;

public class Pret {
    //attributs

    private long id;
    private long montantDemande;
    private long montantMensualite;
    private LocalTime dateSouscription;
    private LocalDate dateEffet;
    private String observations;
    private static long compteur = 0L;

}
