package be.nassim.garage;

import be.nassim.garage.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static be.nassim.garage.DbParams.*;
import static be.nassim.garage.DbParams.DB_PWD;
import static be.nassim.garage.DbQueries.*;
import static be.nassim.garage.DbQueries.LISTE_CLIENT_QUERY;


public class Main {

    public static void main(String[] args) {

        Admin admin = new Admin();

        System.out.println("Bonjour bienvenue au menu principal que souhaitez-vous faire ? \n" +
                "1- Gerer utilisateurs \n" +
                "2- Gerer vehicules \n" +
                "3- Gerer reparations \n" +
                "4- Gerer clients \n");

        Scanner scanner = new Scanner(System.in);
        int reponse = scanner.nextInt();
        switch (reponse) {
            case 1:

                System.out.println("que voulez vous faire ?" +
                        "\n1- inserer un nouvel utilisateur" +
                        "\n2- modifier un utilisateur existant" +
                        "\n3- supprimer un utilisateur" +
                        "\n4- afficher la liste des utilisateurs");
                int rep1 = scanner.nextInt();
                scanner.nextLine();
                if (rep1 == 1) {
                    System.out.println("donner le prenom");
                    String prenom = scanner.next();
                    System.out.println("donner le nom");
                    String nom = scanner.next();
                    Utilisateur utilisateur = new Utilisateur(prenom, nom);
                    admin.ajouterUser(utilisateur);
                    System.out.println("nouvelle liste d'utilisateur");
                    admin.afficherListerUtilisateurs();
                } else if (rep1 == 2) {
                    System.out.println("donner le prenom de l'utilisateur a modifier ");
                    String prenom = scanner.nextLine();
                    System.out.println("donner le nom de l'utilisateur a modifier ");
                    String nom = scanner.nextLine();
                    Utilisateur utilisateurOld = new Utilisateur(prenom, nom);
                    System.out.println("donner son nouveau prenom ");
                    String newPrenom = scanner.nextLine();
                    System.out.println("donner son nouveau nom ");
                    String newNom = scanner.nextLine();
                    Utilisateur utilisateurNew = new Utilisateur(newPrenom, newNom);
                    admin.modifierUser(utilisateurOld, utilisateurNew);
                    System.out.println("nouvelle liste d'utilisateur");
                    admin.afficherListerUtilisateurs();
                } else if (rep1 == 3) {
                    System.out.println("donner le nom de l'utilisateur a supprimer ");
                    String nom = scanner.nextLine();
                    Utilisateur utilisateur = new Utilisateur();
                    utilisateur.setNom(nom);
                    admin.supprimerUser(utilisateur);
                    System.out.println("nouvelle liste d'utilisateur");
                    admin.afficherListerUtilisateurs();
                } else if (rep1 == 4) {

                    System.out.println("liste d'utilisateur");
                    admin.afficherListerUtilisateurs();
                }
                break;

            case 2:

                System.out.println("que voulez vous faire ?" +
                        "\n1- inserer un nouvel vehicule" +
                        "\n2- modifier un vehicule existant" +
                        "\n3- supprimer un vehicule" +
                        "\n4- afficher la liste des vehicules");
                int rep2 = scanner.nextInt();
                scanner.nextLine();
                if (rep2 == 1) {
                    System.out.println("donner le matricule");
                    String matricule = scanner.nextLine();
                    System.out.println("donner la marque");
                    String marque = scanner.nextLine();
                    System.out.println("donner le modele");
                    String modele = scanner.nextLine();
                    System.out.println("donner l'annee");
                    String annee = scanner.nextLine();
                    Vehicule vehicule = new Vehicule(matricule, marque, modele, annee);
                    admin.ajouterVehicule(vehicule);
                    System.out.println("nouvelle liste d'vehicule");
                    admin.afficherListeVehicules();
                } else if (rep2 == 2) {

                    System.out.println("donner le matricule a modifier ");
                    String matricule = scanner.nextLine();
                    System.out.println("donner la marque a modifier ");
                    String marque = scanner.nextLine();
                    System.out.println("donner la modele a modifier ");
                    String modele = scanner.nextLine();
                    System.out.println("donner l'annee a modifier ");
                    String annee = scanner.nextLine();
                    Vehicule vehiculeOld = new Vehicule(matricule, marque, modele, annee);
                    System.out.println("donner le nouveau matricule ");
                    String matriculeNew = scanner.nextLine();
                    System.out.println("donner nouvelle marque ");
                    String marqueNew = scanner.nextLine();
                    System.out.println("donner nouveau modele ");
                    String modeleNew = scanner.nextLine();
                    System.out.println("donner nouvelle annee ");
                    String anneeNew = scanner.nextLine();
                    Vehicule vehiculeNew = new Vehicule(matriculeNew, marqueNew, modeleNew, anneeNew);
                    admin.modifierVehicule(vehiculeOld, vehiculeNew);
                    System.out.println("nouvelle liste d'vehicule");
                    admin.afficherListeVehicules();
                } else if (rep2 == 3) {
                    System.out.println("donner le matricule du vehicule a supprimer ");
                    String matricule = scanner.nextLine();
                    Vehicule vehicule = new Vehicule();
                    vehicule.setImmatriculation(matricule);
                    admin.supprimerVehicule(vehicule);
                    System.out.println("nouvelle liste d'vehicule");
                    admin.afficherListeVehicules();
                } else if (rep2 == 4) {

                    System.out.println("liste d'vehicule");
                    admin.afficherListeVehicules();
                }
                break;
            case 3:

                System.out.println("que voulez vous faire ?" +
                        "\n1- inserer un nouvel reparation" +
                        "\n2- supprimer un reparation" +
                        "\n3- afficher la liste des reparations");
                int rep3 = scanner.nextInt();
                scanner.nextLine();
                if (rep3 == 1) {
                    System.out.println("donner le numero");
                    int numero = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("donner la panne");
                    String panne = scanner.nextLine();
                    System.out.println("donner la solution");
                    String solution = scanner.nextLine();
                    System.out.println("donner la prix");
                    double prix = scanner.nextDouble();
                    Reparation reparation = new Reparation(numero, panne, solution, prix);
                    admin.ajouterReparation(reparation);
                    System.out.println("nouvelle liste d'reparation");
                    admin.afficherListeReparations();
                } else if (rep3 == 2) {
                    System.out.println("donner le numero du reparation a supprimer ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();
                    Reparation reparation = new Reparation();
                    reparation.setNumero(numero);
                    admin.supprimerReparation(reparation);
                    System.out.println("nouvelle liste de reparation");
                    admin.afficherListeReparations();
                } else if (rep3 == 3) {

                    System.out.println("liste de reparations");
                    admin.afficherListeReparations();
                }
                break;
            case 4:

                System.out.println("que voulez vous faire ?" +
                        "\n1- inserer un nouveau client" +
                        "\n2- supprimer un client" +
                        "\n3- afficher la liste des clients");
                int rep4 = scanner.nextInt();
                scanner.nextLine();
                if (rep4 == 1) {
                    System.out.println("donner le numero client");
                    int numeroclient = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("donner le nom");
                    String nom = scanner.nextLine();
                    System.out.println("donner le telephone");
                    String telephone = scanner.nextLine();
                    System.out.println("donner la rue");
                    String rue = scanner.nextLine();
                    System.out.println("donner le numero");
                    String numero = scanner.nextLine();
                    System.out.println("donner le code postal");
                    String cp = scanner.nextLine();
                    System.out.println("donner la ville");
                    String ville = scanner.nextLine();
                    System.out.println("donner le pays");
                    String pays = scanner.nextLine();

                    Client client = new Client(numeroclient, nom, telephone, rue, numero, cp, ville, pays);
                    admin.ajouterClient(client);
                    System.out.println("nouvelle liste d'client");
                    admin.afficherListeClients();
                } else if (rep4 == 2) {
                    System.out.println("donner le numero du client a supprimer ");
                    int num_client = scanner.nextInt();
                    scanner.nextLine();
                    Client client = new Client();
                    client.setNum_client(num_client);
                    admin.supprimerClient(client);
                    System.out.println("nouvelle liste de client");
                    admin.afficherListeClients();
                } else if (rep4 == 3) {

                    System.out.println("liste de clients");
                    admin.afficherListeClients();
                }
                break;
            default:
                System.out.println("choix inconnu");
        }
    }
}