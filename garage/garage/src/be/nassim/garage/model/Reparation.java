package be.nassim.garage.model;

import java.sql.Timestamp;

public class Reparation {
    private int id;
    private int numero ;
    private Timestamp date;
    private String panne;
    private String solution;
    private double prix;

    public Reparation() {
    }

    public Reparation(int numero, String panne, String solution, double prix) {
        this.numero = numero;
        this.panne = panne;
        this.solution = solution;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getPanne() {
        return panne;
    }

    public void setPanne(String panne) {
        this.panne = panne;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
