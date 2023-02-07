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

    //getter
    public long getId() {
        return id;
    }
    public long getMontantDemande() {
        return montantDemande;
    }
    public long getMontantMensualite() {
        return montantMensualite;
    }
    public LocalTime getDateSouscription() {
        return dateSouscription;
    }
    public LocalDate getDateEffet() {
        return dateEffet;
    }
    public String getObservations() {
        return observations;
    }
    public static long getCompteur() {
        return compteur;
    }

    //setter
    public void setId(long id) {
        this.id = id;
    }
    public void setMontantDemande(long montantDemande) {
        this.montantDemande = montantDemande;
    }
    public void setMontantMensualite(long montantMensualite) {
        this.montantMensualite = montantMensualite;
    }
    public void setDateSouscription(LocalTime dateSouscription) {
        this.dateSouscription = dateSouscription;
    }
    public void setDateEffet(LocalDate dateEffet) {
        this.dateEffet = dateEffet;
    }
    public void setObservations(String observations) {
        this.observations = observations;
    }
    public static void setCompteur(long compteur) {
        Pret.compteur = compteur;
    }
}
