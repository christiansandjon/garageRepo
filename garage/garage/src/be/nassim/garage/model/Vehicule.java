package be.nassim.garage.model;

public class Vehicule {

    private int id;
    private String immatriculation;
    private String marque;
    private String modele;
    private String annee;


    public Vehicule() {
    }

    public Vehicule(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public Vehicule(String immatriculation, String marque, String modele, String annee) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }
}