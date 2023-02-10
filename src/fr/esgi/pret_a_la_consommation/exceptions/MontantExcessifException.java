package fr.esgi.pret_a_la_consommation.exceptions;

public class MontantExcessifException extends RuntimeException {

    // TODO: 09/02/2023 Exception levée lorsque le montant demandé par l'utilisateur pour créer un prêt est >= 20 000

    /**
     *
     * @param message
     * @author Y-Vector
     */
    public MontantExcessifException (String message) {
        super(message);
    }

}
