/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amena.model;

/**
 *
 * @author klair
 */
public class Vehicule {
    private int id ; 
    private String type  ; 
    private String immat ;
    private boolean etat ;
    private int chevaux ; 
    private String marque ;
    private String kilometrage ;
    private String couleur ; 
    private float prix ; 

     public Vehicule()
     {}
    
    public Vehicule(int id,String type,String immat, boolean etat,String kilometrage, int chevaux, String marque, String couleur, float prix) {
        this.id = id ; 
        this.type = type ; 
        this.immat = immat;
        this.etat = etat;
        this.chevaux = chevaux;
        this.marque = marque;
        this.kilometrage = kilometrage;
        this.couleur = couleur;
        this.prix = prix;
    }
    public Vehicule(String type,String immat, boolean etat,String kilometrage,int chevaux, String marque, String couleur, float prix) {
        this.type = type ; 
        this.immat = immat;
        this.etat = etat;
        this.kilometrage = kilometrage;
        this.chevaux = chevaux;
        this.marque = marque;
        this.couleur = couleur;
        this.prix = prix;
    }

    public void setKilometrage(String kilometrage) {
        this.kilometrage = kilometrage;
    }

    public String getKilometrage() {
        return kilometrage;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public String getImmat() {
        return immat;
    }

    public boolean isEtat() {
        return etat;
    }

    public int getChevaux() {
        return chevaux;
    }

    public String getMarque() {
        return marque;
    }

    public String getCouleur() {
        return couleur;
    }

    public float getPrix() {
        return prix;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImmat(String immat) {
        this.immat = immat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public void setChevaux(int chevaux) {
        this.chevaux = chevaux;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Vehicule{" + "id=" + id + ", type=" + type + ", immat=" + immat + ", etat=" + etat + ", chevaux=" + chevaux + ", marque=" + marque + ", kilometrage=" + kilometrage + ", couleur=" + couleur + ", prix=" + prix  + "}\n";
    }
    
    
    
}
