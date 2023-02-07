package fr.esgi.pret_a_la_consommation.business;

import java.time.LocalDate;
import java.util.Comparator;


public class Mensualite implements Comparator<Mensualite> {
    /**
     * Classe qui caractérise une mensualité d'un prêt
     */

    private long id;
    private LocalDate datePrelevement;
    private double partInteretsRembourses;
    private double partCapitalRembourses;
    private static long compteur = 0L;

    /**
     * Constructeur d'une mensualité
     *
     * @param datePrelevement        Date du prélèvement
     * @param partInteretsRembourses part d'intérêt remboursés
     * @param partCapitalRembourses  part de capital remboursés
     * @author romaingojard
     */
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

    /**
     * toString date prélèvement
     *
     * @return toString
     * @author romaingojard
     */
    @Override
    public String toString() {
        return datePrelevement + "\t" + partCapitalRembourses + "\t" + partInteretsRembourses;
    }

    /**
     * Comparateur de 2 mensualités sur leur date de prélèvement
     *
     * @param mensualite1 the first object to be compared.
     * @param mensualite2 the second object to be compared.
     * @return comparaison
     * @author romaingojard
     */
    @Override
    public int compare(Mensualite mensualite1, Mensualite mensualite2) {
        return mensualite1.getDatePrelevement().compareTo(mensualite2.getDatePrelevement());
    }
}
