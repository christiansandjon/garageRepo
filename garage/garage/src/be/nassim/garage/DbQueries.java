package be.nassim.garage;

public class DbQueries {

    public static final String INSERT_USER_QUERY = "insert into utilisateur (prenom, nom) values (?,?)";
    public static final String UPDATE_USER_QUERY = "update utilisateur set prenom = ?, nom = ? where prenom = ? and nom = ?";
    public static final String DELETE_USER_QUERY = "delete from utilisateur where nom = ?";
    public static final String LISTE_USER_QUERY = "select prenom , nom FROM utilisateur";

    public static final String INSERT_VEHICULE_QUERY = "insert into vehicule (immatriculation, marque, modele, annee) VALUES (?,?,?,?)";
    public static final String DELETE_VEHICULE_QUERY = "delete from Vehicule where immatriculation = ?";
    public static final String UPDATE_VEHICULE_QUERY = "update Vehicule set immatriculation = ?, marque = ?, modele = ?, annee = ? where immatriculation = ?";
    public static final String LISTE_VEHICULE_QUERY = "select immatriculation ,marque, modele, annee FROM vehicule";

    public static final String INSERT_REPARATION_QUERY = "insert into reparation (numero, date, panne, solution, prix) VALUES (?,CURRENT_TIMESTAMP,?,?,?)";
    public static final String DELETE_REPARATION_QUERY = "delete from reparation where numero = ?";
    public static final String UPDATE_REPARATION_QUERY = "update reparation set numero = ?, panne = ?, solution = ?, prix = ? where numero = ?";
    public static final String LISTE_REPARATION_QUERY = "select numero ,date, panne, solution, prix from reparation";

    public static final String INSERT_CLIENT_QUERY = "insert into client (num_client, nom, telephone, rue, numero, code_postal, ville, pays) VALUES (?,?,?,?,?,?,?,?)";
    public static final String DELETE_CLIENT_QUERY = "delete from Client where num_client = ?";
    public static final String UPDATE_CLIENT_QUERY = "update client set num_client = ?, nom = ?, telephone = ?, rue = ?, numero = ?, code_postal = ?, ville = ? , pays = ?  where num_client = ?";
    public static final String LISTE_CLIENT_QUERY = "select num_client, nom, telephone, rue, numero, code_postal, ville, pays FROM client";


}
