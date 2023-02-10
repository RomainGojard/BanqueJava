package fr.esgi.pret_a_la_consommation;

import fr.esgi.pret_a_la_consommation.business.*;
import fr.esgi.pret_a_la_consommation.exceptions.ChoixInexistantException;
import fr.esgi.pret_a_la_consommation.service.impl.ClientServiceImpl;
import fr.esgi.pret_a_la_consommation.service.impl.MensualiteServiceImpl;
import fr.esgi.pret_a_la_consommation.service.impl.PretServiceImpl;
import fr.esgi.pret_a_la_consommation.service.impl.TauxServiceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private static final ClientServiceImpl clientService = new ClientServiceImpl();
    private static final MensualiteServiceImpl mensualiteService = new MensualiteServiceImpl();
    private static final PretServiceImpl pretService = new PretServiceImpl();
    private static final TauxServiceImpl tauxService = new TauxServiceImpl();

    private static Client client = null;
    private static Taux taux = null;
    private static LocalDate dateEffet = null;
    private static Pret pret = null;
    private static long montantPret = 0;

    private static int reponseInt = 0;
    private static String reponseString;
    private static LocalDate date1;
    private static LocalDate date2;

    private static int menuId = 0;

    private static Scanner scanner = new Scanner(System.in);

    /**
     * Boucle de l'application pour accéder aux différents menus selon les actions de l'utilisateur
     *
     * @param args
     * @author romaingojard
     */
    public static void main(String[] args) {

        initialiserApp();

        while (true) {

            /*
             * menuId = 0 : Menu d'entrée
             * menuId = 1 : Menu pour voir les pret triés par montant et sélectionner un prêt qu'on voit
             * menuId = 2 : Menu pour voir les pret triés par taux et sélectionner un prêt qu'on voit
             * menuId = 3 : Menu pour voir les pret entre deux dates et sélectionner un prêt qu'on voit
             * menuid = 4 : Menu de sélection du client
             * menuid = 5 : Menu pour voir les détails d'un prêt
             * menuId = 6 : Menu pour entrer le montant de son prêt
             * menuId = 7 : Menu de sélection de son taux
             * menuId = 8 : Menu de sélection de la date d'effet du prêt
             */

            switch (menuId) {
                case 0:
                    // Menu 0
                    System.out.println("0. Quitter");
                    System.out.println("1. Voir tous les prêts triés par montant (du plus élevé au plus petit)");
                    System.out.println("2. Voir tous les prêts triés par taux (du plus élevé au plus petit)");
                    System.out.println("3. Voir la liste des prêts qui débutent entre deux dates données");
                    System.out.println("4. Ajouter un prêt");
                    System.out.print("Faîtes votre choix : ");
                    //

                    //Récupération de la réponse

                    try {
                        reponseInt = Integer.parseInt(scanner.nextLine());
                        System.out.println(reponseInt);

                        switch (reponseInt) {
                            case 1, 2, 3, 4 -> menuId = reponseInt;
                            case 0 -> System.exit(-1);
                            default -> throw new ChoixInexistantException("Valeur inattendue");

                        }

                    } catch (NumberFormatException exception) {
                        System.out.println(exception.getMessage());
                        reponseInt = -1;
                    }

                    break;

                case 1:
                    pretService.trierPrets("montant");
                    System.out.println(pretService.afficherChaquePret());

                    //Récupération de la réponse
                    System.out.print("Veuillez saisir l'ID du prêt pour lequel vous voulez voir les informations ou entrez 0 pour faire retour : ");

                    try {
                        reponseInt = Integer.parseInt(scanner.nextLine());

                        pret = pretService.recupererPret(reponseInt);

                        if (reponseInt != 0 && pret != null) {

                            menuId = 5;
                        } else {
                            menuId = 0;
                        }
                    } catch (NumberFormatException exception) {
                        System.out.println(exception.getMessage());
                        reponseInt = -1;
                    }
                    break;

                case 2:
                    pretService.trierPrets("taux");
                    System.out.println(pretService.afficherChaquePret());

                    //Récupération de la réponse
                    System.out.print("Veuillez saisir l'ID du prêt pour lequel vous voulez voir les informations ou entrez 0 pour faire retour : ");

                    try {
                        reponseInt = Integer.parseInt(scanner.nextLine());

                        pret = pretService.recupererPret(reponseInt);

                        if (reponseInt != 0 && pret != null) {

                            menuId = 3;
                        } else {
                            menuId = 0;
                        }
                    } catch (NumberFormatException exception) {
                        System.out.println(exception.getMessage());
                        reponseInt = -1;
                    }
                    break;


                case 3:
                    //Récupération de la réponse
                    System.out.print("Veuillez entrer une première date (aaaa-MM-jj) : ");

                    try {
                        date1 = LocalDate.parse(scanner.nextLine());

                        System.out.print("Veuillez entrer une deuxième date (aaaa-MM-jj) : ");

                        try {
                            date2 = LocalDate.parse(scanner.nextLine());

                            pretService.recupererPrets();
                            // TODO: 09/02/2023 appeler méthode afficher les prêts entre deux dates (date1, date2)

                            //retour au menu principal
                            menuId = 0;
                        } catch (DateTimeParseException exception) {
                            System.out.println(exception.getMessage());
                        }

                    } catch (DateTimeParseException exception) {
                        System.out.println(exception.getMessage());
                    }


                    break;

                case 4:
                    // TODO: 09/02/2023 appeler méthode afficher les clients
                    System.out.println(clientService.afficherClients());

                    //Récupération de la réponse
                    System.out.print("Veuillez saisir l'ID du client pour lequel vous voulez créer un prêt ou entrer 0 si vous voulez faire retour : ");

                    try {
                        reponseInt = Integer.parseInt(scanner.nextLine());

                        if (reponseInt == 0) {
                            menuId = 0;
                        } else {
                            // TODO: 09/02/2023 appeler la méthode obtenirClient(id)
                            //client = clientServiceImpl.obtenirClient(reponseInt);
                            if (client != null) {
                                menuId = 6;
                            } else {
                                System.out.println("Aucun client pour cet id");
                            }
                        }
                    } catch (NumberFormatException exception) {
                        System.out.println(exception.getMessage());
                        reponseInt = -1;
                    }

                    break;

                case 5:

                    System.out.println( pretService.afficherInformationsPret(pret));
                    System.out.println(mensualiteService.afficherMensualitesDuPret(pret));

                    reponseString = scanner.nextLine();
                    menuId = 0;
                    break;


                case 6:
                    //Récupération de la réponse
                    System.out.print("Veuillez entrer le montant de votre prêt : ");

                    try {
                        montantPret = Long.parseLong(scanner.nextLine());
                        menuId = 7;
                        if (montantPret >= 20000) {
                            throw new MontantExcessifException("Le montant ne doit pas dépasser 20000") ;
                        }
                    } catch (NumberFormatException | MontantExcessifException exception) {
                        System.out.println(exception.getMessage());
                        reponseInt = -1;
                    }

                    break;


                case 7:
                    // TODO: 09/02/2023  appeler la méthodes depuis tauxServiceImpl pour afficher tous les taux disponibles
                    System.out.println(/* tauxServiceImpl.afficherTousLesTaux */);

                    //Récupération de la réponse
                    System.out.print("Veuillez saisir l'ID du taux pour lequel vous voulez créer un prêt ou entrer 0 si vous voulez faire retour : ");

                    try {
                        reponseInt = Integer.parseInt(scanner.nextLine());
                        if (reponseInt == 0) {
                            menuId = 0;
                        } else {
                            // TODO: 09/02/2023 appeler la méthode depuis tauxServiceImpl pour récupérer le taux selon son ID
                            //taux = tauxServiceImpl.obtenirTaux(reponseInt);
                            if (taux != null) {
                                menuId = 8;
                            } else {
                                System.out.println("Aucun taux pour cet id");
                            }
                        }


                    } catch (NumberFormatException exception) {
                        System.out.println(exception.getMessage());
                        reponseInt = -1;
                    }
                    break;

                case 8:

                    System.out.print("Veuillez entrer la date d'effet de votre prêt (aaaa-MM-jj) : ");

                    try {
                        dateEffet = LocalDate.parse(scanner.nextLine());
                        if (dateEffet.isBefore(LocalDate.now())) {
                            System.out.println("La date doit être postérieur à aujourd'hui");
                        } else {

                            // TODO: 09/02/2023 appeler la méthode créer pret, créer mensualités d'un prêt depuis les impl
                            pret = pretService.ajouterPret(montantPret, dateEffet ,"" , client, taux);
                            mensualiteService.creerMensualitesDuPret(pret);
                            menuId = 5; // page détail d'un prêt

                        }
                    } catch (DateTimeParseException exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;

            }
        }


    }

    /**
     * Initialisation de 4 taux arbitraires
     */
    public static void initialiserLesTaux() {
        Motif motifVoiture = new Motif("Voiture", "Uniquement pour des voitures d'une valeur de moins de 20 000€ à l'Argus");
        Motif motifMoto = new Motif("Moto", "Uniquement pour des motos d'une valeur de moins de 10 000€ à l'Argus");

        Duree duree1an = new Duree(12);
        Duree duree2an = new Duree(24);

        tauxService.ajouterTaux(5, duree2an, motifVoiture);
        tauxService.ajouterTaux(1, duree1an, motifVoiture);
        tauxService.ajouterTaux(10, duree2an, motifMoto);
        tauxService.ajouterTaux(5, duree1an, motifMoto);
    }

    /**
     * Initialisation de 4 prêts arbitraires
     */
    public static void initialiserLesPrets() {
        // TODO: 09/02/2023 récupérer les prets, ajouter des prêts bateaux... 
    }

    public static void initialiserLesMensualites() {
        mensualiteService.creerMensualitesDuPret(pretService.recupererPret(1));
        mensualiteService.creerMensualitesDuPret(pretService.recupererPret(2));
        mensualiteService.creerMensualitesDuPret(pretService.recupererPret(3));
        mensualiteService.creerMensualitesDuPret(pretService.recupererPret(4));
    }

    public static void initialiserLesClients() {
        // TODO: 09/02/2023 récupérer les clients, ajouter des clients bateaux
    }

    public static void initialiserApp() {
        System.out.println("Bienvenue sur l'application de simulation de prêts à la consommation ! \n");

        // Bien respecter l'ordre ;)
        initialiserLesTaux();
        initialiserLesClients();
        initialiserLesPrets();
        initialiserLesMensualites();
    }


}
