package fr.esgi.pret_a_la_consommation.exceptions;

public class ChoixInexistantException extends RuntimeException {

    /**
     * Exception levée lorsque la réponse ne correspond à aucun menu
     * @param message message d'erreur
     * @author romaingojard
     */
    public ChoixInexistantException(String message){
        super(message);
    }

}
