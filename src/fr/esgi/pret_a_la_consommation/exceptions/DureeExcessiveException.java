package fr.esgi.pret_a_la_consommation.exceptions;

public class DureeExcessiveException extends RuntimeException{

    public DureeExcessiveException(String message){
        super("La date entrée est invalide" + message);
    }
}
