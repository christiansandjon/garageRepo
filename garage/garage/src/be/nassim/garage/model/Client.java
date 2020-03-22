package be.nassim.garage.model;

public class Client {

    private int num_client;
    private String nom;
    private String telephone;
    private String rue;
    private String numero;
    private String code_postal;
    private String ville;
    private String pays;

    public Client() {
    }

    public Client(int num_client, String nom, String telephone, String rue, String numero, String code_postal, String ville, String pays) {
        this.num_client = num_client;
        this.nom = nom;
        this.telephone = telephone;
        this.rue = rue;
        this.numero = numero;
        this.code_postal = code_postal;
        this.ville = ville;
        this.pays = pays;
    }


    public int getNum_client() {
        return num_client;
    }

    public void setNum_client(int num_client) {
        this.num_client = num_client;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
}
