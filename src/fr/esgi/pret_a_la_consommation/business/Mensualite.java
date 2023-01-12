package fr.esgi.pret_a_la_consommation.business;

import java.time.LocalDate;

public class Mensualite {
    private long id;
    private LocalDate datePrelevement;
    private double partInteretsRembourses;
    private double partCapitalRembourses;
    private static long compteur = 0L;

}
