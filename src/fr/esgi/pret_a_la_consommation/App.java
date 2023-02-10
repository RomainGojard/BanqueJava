package fr.esgi.pret_a_la_consommation;

import fr.esgi.pret_a_la_consommation.business.Client;
import fr.esgi.pret_a_la_consommation.business.Pret;
import fr.esgi.pret_a_la_consommation.business.Taux;
import fr.esgi.pret_a_la_consommation.service.impl.MensualiteServiceImpl;
import fr.esgi.pret_a_la_consommation.service.impl.PretServiceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private static final MensualiteServiceImpl mensualiteService = new MensualiteServiceImpl();
    private static final PretServiceImpl pretService = new PretServiceImpl();
    // private static final ClientServiceImpl clientService = new ClientServiceImpl();
    // private static final TauxServiceImpl tauxService = new TauxServiceImpl();

    private static Client client = null;
    private static Taux taux = null;
    private static LocalDate dateEffet = null;
    private static Pret pret = null;
    private static double montantPret = 0;

    private static int reponseInt = 0;
    private static String reponseString;
    private static LocalDate date1;
    private static LocalDate date2;

    private static int menuId = 0;

    private static Scanner scanner = new Scanner(System.in);


    // TODO: 09/02/2023 - instancier les différents services nécessaire

    /**
     * Boucle de l'application pour accéder au différent menu selon les actions de l'utilisateur
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
                            default ->
                                // TODO: 09/02/2023 lever une exception maison à faire
                                    throw new RuntimeException("Valeur pas attendue");

                        }

                    } catch (NumberFormatException exception) {
                        System.out.println(exception.getMessage());
                        reponseInt = -1;
                    }

                    break;

                case 1:
                    // TODO: 09/02/2023 appeler méthode afficher prêts trier par montant

                    //Récupération de la réponse
                    System.out.print("Veuillez saisir l'ID du prêt pour lequel vous voulez voir les informations ou entrez 0 pour faire retour : ");

                    try {
                        reponseInt = Integer.parseInt(scanner.nextLine());

                        // TODO: 09/02/2023 - appeler la méthode obtenirPret(id),si c'est null renvoyer aucun élément valide
                        // pret = obtenirPret(id);

                        if (reponseInt != 0 /* && pret != null */) {

                            menuId = 3;
                        } else {
                            menuId = 0;
                        }
                    } catch (NumberFormatException exception) {
                        System.out.println(exception.getMessage());
                        reponseInt = -1;
                    }
                    break;

                case 2:
                    // TODO: 09/02/2023 appeler méthode afficher prêts trier par taux

                    //Récupération de la réponse
                    System.out.print("Veuillez saisir l'ID du prêt pour lequel vous voulez voir les informations ou entrez 0 pour faire retour : ");

                    try {
                        reponseInt = Integer.parseInt(scanner.nextLine());

                        // TODO: 09/02/2023 - appeler la méthode obtenirPret(id),si c'est null renvoyer aucun élément valide
                        // pret = obtenirPret(id);

                        if (reponseInt != 0 /* && pret != null */) {

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
                    System.out.print("Veuillez entrer une première date (jj/MM/aaaa) : ");

                    try {
                        date1 = LocalDate.parse(scanner.nextLine());

                        System.out.print("Veuillez entrer une deuxième date (jj/MM/aaaa) : ");

                        try {
                            date2 = LocalDate.parse(scanner.nextLine());
                            //retour au menu principal
                            menuId = 0;
                        } catch (DateTimeParseException exception) {
                            System.out.println(exception.getMessage());
                        }

                    } catch (DateTimeParseException exception) {
                        System.out.println(exception.getMessage());
                    }


                    // TODO: 09/02/2023 appeler méthode afficher les prêts entre deux dates (date1, date2)
                    break;

                case 4:
                    // TODO: 09/02/2023 appeler méthode afficher les clients

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

                    // TODO: 09/02/2023 appeler la méthode afficherInformationsPret pour un prêt donné depuis pretServiceImpl qui retournera un string de toutes les infos (voir pdf prof)
                    // System.out.println(pretServiceImpl.afficherInformationsPret(pret));
                    reponseString = scanner.nextLine();
                    menuId = 0;
                    break;


                case 6:
                    //Récupération de la réponse
                    System.out.print("Veuillez entrer le montant de votre prêt : ");

                    try {
                        montantPret = Double.parseDouble(scanner.nextLine());
                        menuId = 7;
                    } catch (NumberFormatException exception) {
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

                    System.out.println("Veuillez entrer la date d'effet de votre prêt (jj/MM/aaaa) : ");

                    try {
                        dateEffet = LocalDate.parse(scanner.nextLine());
                        if (dateEffet.isBefore(LocalDate.now())) {
                            System.out.println("La date doit être postérieur à aujourd'hui");
                        } else {

                            // TODO: 09/02/2023 appeler la méthode créer pret, créer mensualités d'un prêt depuis les impl
                            //pret= pretServiceImplCreerPret
                            //creer mensualites
                            menuId = 5; // page détail d'un prêt

                        }
                    } catch (DateTimeParseException exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;

            }
        }


    }

    // TODO: 09/02/2023 - boucle infinie (while true) avec les choix possibles par l'utilisateurs 


    public static void initialiserLesPrets() {
        // TODO: 09/02/2023 récupérer les prets, ajouter des prêts bateaux... 
    }

    public static void initialiserLesMensualites() {
        // TODO: 09/02/2023 récupérer les mensualités, ajouter des mensualités bateau
    }

    public static void initialiserLesClients() {
        // TODO: 09/02/2023 récupérer les clients, ajouter des clients bateaux
    }

    public static void initialiserApp() {
        System.out.println("Bienvenue sur l'application de simulation de prêts à la consommation ! \n");

        // Bien respecter l'order ;)
        initialiserLesClients();
        initialiserLesPrets();
        initialiserLesMensualites();
    }


}
