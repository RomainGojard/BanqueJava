package fr.esgi.pret_a_la_consommation.exceptions;

public class ChoixInexistantException extends RuntimeException {

    public ChoixInexistantException(String message){
        super("La réponse ne correspond à aucun choix disponible" + message);
    }

}
