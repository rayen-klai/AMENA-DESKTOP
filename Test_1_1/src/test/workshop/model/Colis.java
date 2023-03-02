/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.workshop.model;

/**
 *
 * @author hp
 */
import java.sql.Connection;
import java.time.LocalDate;
import static java.time.temporal.TemporalQueries.localDate;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import test.workshop.utils.MyConnection;


public class Colis {
  private int id;
  private String nomExpediteur;
  private String adresseExpediteur;
  private String nomDestinataire;
  private String adresseDestinataire;
  private float poids;
  private String statut;
  private Date dateExpedition;
  
  
  public Colis() {
      
    }
  public Colis(int id, String nomExpediteur, String adresseExpediteur, String nomDestinataire, String adresseDestinataire, float poids) {
    this.id = id;
    this.nomExpediteur = nomExpediteur;
    this.adresseExpediteur = adresseExpediteur;
    this.nomDestinataire = nomDestinataire;
    this.adresseDestinataire = adresseDestinataire;
    this.poids = poids;
    this.statut = "en attente";
    this.dateExpedition = Date.valueOf(LocalDate.now());
    /*java.sql.Date sqlDate = java.sql.Date.valueOf(dateExpedition);*/

  }
    public Colis(String nomExpediteur, String adresseExpediteur, String nomDestinataire, String adresseDestinataire, float poids) {
    this.nomExpediteur = nomExpediteur;
    this.adresseExpediteur = adresseExpediteur;
    this.nomDestinataire = nomDestinataire;
    this.adresseDestinataire = adresseDestinataire;
    this.poids = poids;
    this.statut = "en attente";
    this.dateExpedition = Date.valueOf(LocalDate.now());}

public Colis(int id,String nomExpediteur, String adresseExpediteur, String nomDestinataire, String adresseDestinataire, float poids,String statut,LocalDate dateExpedition) {
this.id = id;
this.nomExpediteur = nomExpediteur;
this.adresseExpediteur = adresseExpediteur;
this.nomDestinataire = nomDestinataire;
this.adresseDestinataire = adresseDestinataire;
this.poids =poids;
this.statut = "en attente";
this.dateExpedition = Date.valueOf(dateExpedition);
}
 /*        LES SETTERS ET LES GETTERS             */
    
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getNomExpediteur() {
    return nomExpediteur;
  }
  
  public void setNomExpediteur(String nomExpediteur) {
    this.nomExpediteur = nomExpediteur;
  }
  
  public String getAdresseExpediteur() {
    return adresseExpediteur;
  }
  
  public void setAdresseExpediteur(String adresseExpediteur) {
    this.adresseExpediteur = adresseExpediteur;
  }
  
  public String getNomDestinataire() {
    return nomDestinataire;
  }
  
  public void setNomDestinataire(String nomDestinataire) {
    this.nomDestinataire = nomDestinataire;
  }
  
  public String getAdresseDestinataire() {
    return adresseDestinataire;
  }
  
  public void setAdresseDestinataire(String adresseDestinataire) {
    this.adresseDestinataire = adresseDestinataire;
  }
  
  public float getPoids() {
    return poids;
  }
  
  public void setPoids(float poids) {
    this.poids = poids;
  }
  
  public String getStatut() {
    return statut;
  }
  
  public void setStatut(String statut) {
    this.statut = statut;
  }
  
  public Date getDateExpedition() {
    return dateExpedition;
  }
  public void setDateExpedition(Date dateExpedition) {
    this.dateExpedition = dateExpedition;
  }
  
@Override
public String toString() {
        return "Colis{" + "id=" + id + ", Nom Expediteur=" + nomExpediteur + ", Adresse Expediteur=" + adresseExpediteur + ", nomDestinataire="+nomDestinataire+", adresseDestinataire="+adresseDestinataire+", poids="+poids+", statut="+statut+", dateExpedition"+dateExpedition+"}/n";
    }

/*             Trie Colis par critere souhaité                  */

public List<Colis> trier(String critere) {
    Statement ste;
    Connection conn = MyConnection.getInstance().getConn();

    List<Colis> colisTrie = new ArrayList<>();
    try {
        String requeteSQL = "SELECT * FROM colis ORDER BY " + critere;
        PreparedStatement stmt = conn.prepareStatement(requeteSQL);
        ResultSet result = stmt.executeQuery();
        while (result.next()) {
            Colis c = new Colis();
            c.setId(result.getInt("id_Colis"));
            c.setNomExpediteur(result.getString("nomExpediteur"));
            c.setAdresseExpediteur(result.getString("adresseExpediteur"));
            c.setNomDestinataire(result.getString("nomDestinataire"));
            c.setAdresseDestinataire(result.getString("adresseDestinataire"));
            c.setPoids(result.getFloat("poids"));
            c.setStatut(result.getString("statut"));
            c.setDateExpedition(result.getDate("dateExpedition"));
            colisTrie.add(c);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return colisTrie;
}
}


