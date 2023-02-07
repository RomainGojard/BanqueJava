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

    private Client client;
    private Taux taux;

    /**
     * Constructeur Pret
     * @param id id du prêt
     * @param montantDemande Montant prêté
     * @param montantMensualite Montant de chaque mensualité
     * @param dateSouscription Date de la souscription du prêt
     * @param dateEffet Date d'effet du prêt => Date de première mensualité ou du montant viré ?
     * @param observations Observations
     * @param client Client auquel le prêt est associé
     * @param taux Taux auquel le prêt est associé
     * @author romaingojard
     */
    public Pret(long id, long montantDemande, long montantMensualite, LocalTime dateSouscription, LocalDate dateEffet, String observations, Client client, Taux taux) {
        this.id = ++compteur;
        this.montantDemande = montantDemande;
        this.montantMensualite = montantMensualite;
        this.dateSouscription = dateSouscription;
        this.dateEffet = dateEffet;
        this.observations = observations;
        this.client = client;
        this.taux = taux;
    }

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
}
