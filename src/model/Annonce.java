/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;




/**
 *
 * @author Nour Saidi
 */
import java.sql.Date;
public class Annonce {
    private int id_annonce,prix;
    private String ville_dep,ville_arr,description;
    private Date date_dep,date_arr;

    //constructeur par defaut
    public Annonce() {
    }
    
    //constructur parametre 

    public Annonce(int prix, String ville_dep, String ville_arr, String description, Date date_dep, Date date_arr) {
        this.prix = prix;
        this.ville_dep = ville_dep;
        this.ville_arr = ville_arr;
        this.description = description;
        this.date_dep = date_dep;
        this.date_arr = date_arr;
        
    }

    public Annonce(int id_annonce, String ville_dep, String ville_arr, Date date_dep, Date date_arr, int prix, String description) {
        this.id_annonce = id_annonce;
        this.ville_dep = ville_dep;
        this.ville_arr = ville_arr;
        this.date_dep = date_dep;
        this.date_arr = date_arr;
        this.prix = prix;
        this.description = description;
    }

    public Annonce(String ville_dep, String ville_arr) {
        this.ville_dep = ville_dep;
        this.ville_arr = ville_arr;
    }

    public Annonce(int prix, String ville_dep, String ville_arr, String description) {
        this.prix = prix;
        this.ville_dep = ville_dep;
        this.ville_arr = ville_arr;
        this.description = description;
    }



    public int getId_annonce() {
        return id_annonce;
    }

    public void setId_annonce(int id_annonce) {
        this.id_annonce = id_annonce;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getVille_dep() {
        return ville_dep;
    }

    public void setVille_dep(String ville_dep) {
        this.ville_dep = ville_dep;
    }

    public String getVille_arr() {
        return ville_arr;
    }

    public void setVille_arr(String ville_arr) {
        this.ville_arr = ville_arr;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_dep() {
        return date_dep;
    }

    public void setDate_dep(Date date_dep) {
        this.date_dep = date_dep;
    }

    public Date getDate_arr() {
        return date_arr;
    }

    public void setDate_arr(Date date_arr) {
        this.date_arr = date_arr;
    }

    
    
    @Override
    public String toString() {
        return "Annonce{" + "id_annonce=" + id_annonce + ", ville_dep=" + ville_dep + ", ville_arr=" + ville_arr + "date_dep=" + date_dep + ", date_arr=" + date_arr + ", prix=" + prix +", description=" + description + '}';
    }
    
    
}
