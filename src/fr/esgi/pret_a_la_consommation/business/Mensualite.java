package fr.esgi.pret_a_la_consommation.business;

import java.time.LocalDate;
import java.util.Comparator;

public class Mensualite implements Comparator<Mensualite> {
    /** Classe qui caractérise une mensualité d'un prêt

     *
     */

    private long id;
    private LocalDate datePrelevement;
    private double partInteretsRembourses;
    private double partCapitalRembourses;
    private static long compteur = 0L;

    public Mensualite(LocalDate datePrelevement, double partInteretsRembourses, double partCapitalRembourses) {
        this.id = ++compteur;
        this.datePrelevement = datePrelevement;
        this.partInteretsRembourses = partInteretsRembourses;
        this.partCapitalRembourses = partCapitalRembourses;
    }

    public long getId() {
        return id;
    }

    public LocalDate getDatePrelevement() {
        return datePrelevement;
    }

    public double getPartInteretsRembourses() {
        return partInteretsRembourses;
    }

    public double getPartCapitalRembourses() {
        return partCapitalRembourses;
    }

    @Override
    public String toString() {
        return  datePrelevement + "\t" + partCapitalRembourses + "\t" + partInteretsRembourses ;
    }

    @Override
    public int compare(Mensualite mensualite1, Mensualite mensualite2) {
        return mensualite1.getDatePrelevement().compareTo(mensualite2.getDatePrelevement());
    }
}
