package be.nassim.garage.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static be.nassim.garage.DbParams.*;
import static be.nassim.garage.DbQueries.*;

public class Admin extends Utilisateur {

    private List<Utilisateur> utilisateurs;
    private List<Reparation> reparations;
    private List<Vehicule> vehicules;
    private List<Client> clients;
    private Connection connection;


    // ++++ GESTION UTILISATEURS ++++

    public void ajouterUser(Utilisateur utilisateur) {
        // connexion BD  (ne pas oublier d'ajouter le connector mysql
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
            System.out.println("connexion reussie");
        } catch (Exception e) {
            System.out.println("echec connexion");
        }

        // insertion
        try {
            PreparedStatement pstmtInsertUser = connection.prepareStatement(INSERT_USER_QUERY);
            pstmtInsertUser.setString(1, utilisateur.getPrenom());
            pstmtInsertUser.setString(2, utilisateur.getNom());
            pstmtInsertUser.executeUpdate();

            System.out.println("un utilisateur a ete ajouté");
        } catch (SQLException e) {
            System.out.println("impossible d'inserer l'utilisateur");
        }
    }

    public void modifierUser(Utilisateur utilisateurOld, Utilisateur utilisateurNew) {
        // connexion BD  (ne pas oublier d'ajouter le connector mysql
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
            System.out.println("connexion reussie");
        } catch (Exception e) {
            System.out.println("echec connexion");
        }

        try {
            PreparedStatement pstmtUpdateUser = connection.prepareStatement(UPDATE_USER_QUERY);
            pstmtUpdateUser.setString(1, utilisateurNew.getPrenom());
            pstmtUpdateUser.setString(2, utilisateurNew.getNom());
            pstmtUpdateUser.setString(3, utilisateurOld.getPrenom());
            pstmtUpdateUser.setString(4, utilisateurOld.getNom());

            pstmtUpdateUser.executeUpdate();
            System.out.println("un utilisateur modifié ");
        } catch (SQLException e) {
            System.out.println("impossible de modifier l'utilisateur");
        }
    }

    public void supprimerUser(Utilisateur utilisateur) {
        // connexion BD  (ne pas oublier d'ajouter le connector mysql
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
            System.out.println("connexion reussie");
        } catch (Exception e) {
            System.out.println("echec connexion");
        }

        try {
            PreparedStatement pstmtDeleteUser = connection.prepareStatement(DELETE_USER_QUERY);
            pstmtDeleteUser.setString(1, utilisateur.getNom());
            pstmtDeleteUser.execute();
            System.out.println("un utilisateur supprimé ");
        } catch (SQLException e) {
            System.out.println("impossible de supprimer l'utilisateur");
        }

    }


    public void afficherListerUtilisateurs() {
        // connexion BD  (ne pas oublier d'ajouter le connector mysql
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);

        } catch (Exception e) {
            System.out.println("echec connexion");
        }

        utilisateurs = new ArrayList<>();
        Statement statement = null;
        ResultSet resultat = null;

        try {
            statement = connection.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery(LISTE_USER_QUERY);

            // Récupération des données
            while (resultat.next()) {
                String prenom = resultat.getString("prenom");
                String nom = resultat.getString("nom");

                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setPrenom(prenom);
                utilisateur.setNom(nom);
                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            System.out.println("requete impossible");
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException ignore) {
                System.out.println("impossible de fermer ");
            }
        }
        System.out.println("Liste des utilisateurs :");
        for (Utilisateur g : utilisateurs) {
            System.out.println(g.getPrenom() +
                    " " + g.getNom()
            );
        }

    }


    // +++ GESTION VEHICULES +++

    public void ajouterVehicule(Vehicule vehicule) {

        // connexion BD  (ne pas oublier d'ajouter le connector mysql
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);

        } catch (Exception e) {
            System.out.println("echec connexion");
        }

        // insertion
        try {
            PreparedStatement pstmtInsertVehicule = connection.prepareStatement(INSERT_VEHICULE_QUERY);
            pstmtInsertVehicule.setString(1, vehicule.getImmatriculation());
            pstmtInsertVehicule.setString(2, vehicule.getMarque());
            pstmtInsertVehicule.setString(3, vehicule.getModele());
            pstmtInsertVehicule.setString(4, vehicule.getAnnee());
            pstmtInsertVehicule.executeUpdate();
            System.out.println("un vehicule ajouté ");
        } catch (SQLException e) {
            System.out.println("impossible d'ajouter un vehicule");
            ;
        }
    }


    public void modifierVehicule(Vehicule vehiculeOld, Vehicule vehiculeNew) {
        // connexion BD  (ne pas oublier d'ajouter le connector mysql
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);

        } catch (Exception e) {
            System.out.println("echec connexion");
        }

        // insertion

        try {
            PreparedStatement pstmtUpdateVehicule = connection.prepareStatement(UPDATE_VEHICULE_QUERY);
            pstmtUpdateVehicule.setString(1, vehiculeNew.getImmatriculation());
            pstmtUpdateVehicule.setString(2, vehiculeNew.getMarque());
            pstmtUpdateVehicule.setString(3, vehiculeNew.getModele());
            pstmtUpdateVehicule.setString(4, vehiculeNew.getAnnee());

            // le parametre d'echange
            pstmtUpdateVehicule.setString(5, vehiculeOld.getImmatriculation());
            pstmtUpdateVehicule.executeUpdate();
            System.out.println("un vehicule modifié ");
        } catch (SQLException e) {
            System.out.println("impossible de modifier un vehicule");
        }
    }


    public void supprimerVehicule(Vehicule vehicule) {
        // connexion BD  (ne pas oublier d'ajouter le connector mysql
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);

        } catch (Exception e) {
            System.out.println("echec connexion");
        }

        try {
            PreparedStatement pstmtDeleteUser = connection.prepareStatement(DELETE_VEHICULE_QUERY);
            pstmtDeleteUser.setString(1, vehicule.getImmatriculation());

            pstmtDeleteUser.execute();
            System.out.println("un vehicule supprimé ");
        } catch (SQLException e) {
            System.out.println("impossible de supprimer un vehicule");
        }
    }


    public List<Vehicule> listerVehicules() {
        // connexion BD  (ne pas oublier d'ajouter le connector mysql
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);

        } catch (Exception e) {
            System.out.println("echec connexion");
        }


        vehicules = new ArrayList<>();
        Statement statement = null;
        ResultSet resultat = null;

        try {
            statement = connection.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery(LISTE_VEHICULE_QUERY);

            // Récupération des données
            while (resultat.next()) {
                String immatriculation = resultat.getString("immatriculation");
                String marque = resultat.getString("marque");
                String modele = resultat.getString("modele");
                String annee = resultat.getString("annee");

                Vehicule vehicule = new Vehicule();
                vehicule.setImmatriculation(immatriculation);
                vehicule.setMarque(marque);
                vehicule.setModele(modele);
                vehicule.setAnnee(annee);
                vehicules.add(vehicule);
            }
        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException ignore) {
            }
        }
        return vehicules;
    }

    public void afficherListeVehicules() {
        listerVehicules();
        System.out.println("liste des vehicules");
        for (Vehicule v : vehicules) {
            System.out.println("immatriculation : "+v.getImmatriculation() +
                    "\nmarque : " + v.getMarque() +
                    "\nmodele : " + v.getModele() +
                    "\nannee : " + v.getAnnee()
            );
        }
    }

    //+++ GESTION REPARATION +++
    public void ajouterReparation(Reparation reparation) {
        // connexion BD  (ne pas oublier d'ajouter le connector mysql
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);

        } catch (Exception e) {
            System.out.println("echec connexion");
        }

        // insertion

        try {
            PreparedStatement pstmtInsertReparation = connection.prepareStatement(INSERT_REPARATION_QUERY);
            pstmtInsertReparation.setInt(1, reparation.getNumero());
            pstmtInsertReparation.setString(2, reparation.getPanne());
            pstmtInsertReparation.setString(3, reparation.getSolution());
            pstmtInsertReparation.setDouble(4, reparation.getPrix());

            pstmtInsertReparation.executeUpdate();
            System.out.println("une reparation ajoutée");
        } catch (SQLException e) {
            System.out.println("impossible d'ajouter une reparation");
        }
    }


    public void modifierReparation(Reparation reparationOld, Reparation reparationNew) {
        // connexion BD  (ne pas oublier d'ajouter le connector mysql
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);

        } catch (Exception e) {
            System.out.println("echec connexion");
        }

        // insertion

        try {
            PreparedStatement pstmtUpdateReparation = connection.prepareStatement(UPDATE_REPARATION_QUERY);
            pstmtUpdateReparation.setInt(1, reparationNew.getNumero());
            pstmtUpdateReparation.setString(2, reparationNew.getPanne());
            pstmtUpdateReparation.setString(3, reparationNew.getSolution());
            pstmtUpdateReparation.setDouble(4, reparationNew.getPrix());

            // le parametre d'echange
            pstmtUpdateReparation.setInt(5, reparationOld.getNumero());
            pstmtUpdateReparation.executeUpdate();
            System.out.println("une reparation modifiée");
        } catch (SQLException e) {
            System.out.println("impossible de modifier une reparation");
        }
    }


    public void supprimerReparation(Reparation reparation) {

        // connexion BD  (ne pas oublier d'ajouter le connector mysql
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);

        } catch (Exception e) {
            System.out.println("echec connexion");
        }

        // insertion
        try {
            PreparedStatement pstmtDeleteUser = connection.prepareStatement(DELETE_REPARATION_QUERY);
            pstmtDeleteUser.setInt(1, reparation.getNumero());

            pstmtDeleteUser.execute();
            System.out.println("une reparation supprmée");
        } catch (SQLException e) {
            System.out.println("impossible de supprimer une reparation");
        }
    }


    public List<Reparation> listerReparations() {
        // connexion BD  (ne pas oublier d'ajouter le connector mysql
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);

        } catch (Exception e) {
            System.out.println("echec connexion");
        }

        // insertion
        reparations = new ArrayList<>();
        Statement statement = null;
        ResultSet resultat = null;



        try {
            statement = connection.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery(LISTE_REPARATION_QUERY);

            // Récupération des données
            while (resultat.next()) {
                int numero = resultat.getInt("numero");
                Timestamp date = resultat.getTimestamp("date");
                String panne = resultat.getString("panne");
                String solution = resultat.getString("solution");
                double prix = resultat.getDouble("prix");

                Reparation reparation = new Reparation();
                reparation.setNumero(numero);
                reparation.setDate(date);
                reparation.setPanne(panne);
                reparation.setSolution(solution);
                reparation.setPrix(prix);
                reparations.add(reparation);
            }
        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException ignore) {
            }
        }
        return reparations;
    }

    public void afficherListeReparations() {
        listerReparations();
        System.out.println("liste des reparations");
        for (Reparation reparation : reparations) {
            System.out.println("numero "+reparation.getNumero() +
                    "\ndate : " + reparation.getDate() +
                    "\npanne : " + reparation.getPanne() +
                    "\nsolution : " + reparation.getSolution() +
                    "\nprix : " + reparation.getPrix()
            );
        }
    }


    // +++ GESTION CLIENTS +++

    public void ajouterClient(Client client) {
        // connexion BD  (ne pas oublier d'ajouter le connector mysql
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);

        } catch (Exception e) {
            System.out.println("echec connexion");
        }

        // insertion

        try {
            PreparedStatement pstmtInsertClient = connection.prepareStatement(INSERT_CLIENT_QUERY);
            pstmtInsertClient.setInt(1, client.getNum_client());
            pstmtInsertClient.setString(2, client.getNom());
            pstmtInsertClient.setString(3, client.getTelephone());
            pstmtInsertClient.setString(4, client.getRue());
            pstmtInsertClient.setString(5, client.getNumero());
            pstmtInsertClient.setString(6, client.getCode_postal());
            pstmtInsertClient.setString(7, client.getVille());
            pstmtInsertClient.setString(8, client.getPays());

            pstmtInsertClient.executeUpdate();
            System.out.println("une client ajoutée");
        } catch (SQLException e) {
            System.out.println("impossible d'ajouter un client");
        }
    }

    public void modifierClient(Client clientOld, Client clientNew) {
        // connexion BD  (ne pas oublier d'ajouter le connector mysql
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);

        } catch (Exception e) {
            System.out.println("echec connexion");
        }

        // insertion

        try {
            PreparedStatement pstmtUpdateClient = connection.prepareStatement(UPDATE_CLIENT_QUERY);
            pstmtUpdateClient.setInt(1, clientNew.getNum_client());
            pstmtUpdateClient.setString(2, clientNew.getNom());
            pstmtUpdateClient.setString(3, clientNew.getTelephone());
            pstmtUpdateClient.setString(4, clientNew.getRue());
            pstmtUpdateClient.setString(5, clientNew.getNumero());
            pstmtUpdateClient.setString(6, clientNew.getCode_postal());
            pstmtUpdateClient.setString(7, clientNew.getVille());
            pstmtUpdateClient.setString(8, clientNew.getPays());

            // le parametre d'echange
            pstmtUpdateClient.setInt(9, clientOld.getNum_client());
            pstmtUpdateClient.executeUpdate();
            System.out.println("une client modifié");
        } catch (SQLException e) {
            System.out.println("impossible de modifier un client");
        }
    }


    public void supprimerClient(Client client) {
        // connexion BD  (ne pas oublier d'ajouter le connector mysql
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);

        } catch (Exception e) {
            System.out.println("echec connexion");
        }

        // insertion

        try {
            PreparedStatement pstmtDeleteUser = connection.prepareStatement(DELETE_CLIENT_QUERY);
            pstmtDeleteUser.setInt(1, client.getNum_client());

            pstmtDeleteUser.execute();
            System.out.println("une client supprimé");
        } catch (SQLException e) {
            System.out.println("impossible de supprimer un client");
        }
    }


    public List<Client> listerClients() {
        // connexion BD  (ne pas oublier d'ajouter le connector mysql
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);

        } catch (Exception e) {
            System.out.println("echec connexion");
        }

        // insertion
        clients = new ArrayList<>();
        Statement statement = null;
        ResultSet resultat = null;



        try {
            statement = connection.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery(LISTE_CLIENT_QUERY);

            // Récupération des données
            while (resultat.next()) {

                int num_client = resultat.getInt("num_client");
                String nom = resultat.getString("nom");
                String telephone = resultat.getString("telephone");
                String rue = resultat.getString("rue");
                String numero = resultat.getString("numero");
                String code_postal = resultat.getString("code_postal");
                String ville = resultat.getString("ville");
                String pays = resultat.getString("pays");

                Client client = new Client();
                client.setNum_client(num_client);
                client.setNom(nom);
                client.setTelephone(telephone);
                client.setRue(rue);
                client.setNumero(numero);
                client.setCode_postal(code_postal);
                client.setVille(ville);
                client.setPays(pays);

                clients.add(client);
            }
        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException ignore) {
            }
        }
        return clients;
    }

    public void afficherListeClients() {
        listerClients();
        System.out.println("liste des clients");
        for (Client client : clients) {
            System.out.println("numero client "+client.getNum_client() +
                    "\nnom : " + client.getNom() +
                    "\ntelephone : " + client.getTelephone() +
                    "\nadresse : " + client.getRue() +
                    " " + client.getNumero() +
                    " " + client.getCode_postal() +
                    " " + client.getVille() +
                    " " + client.getPays()
            );
        }
    }

}

