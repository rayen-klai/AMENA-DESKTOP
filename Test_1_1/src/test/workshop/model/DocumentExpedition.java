/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.workshop.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import test.workshop.utils.MyConnection;

/**
 *
 * @author hp
 */
public class DocumentExpedition {
    private int id;
    private Date dateSignature;
    private int id_colis;
    private String statut;
    
    public DocumentExpedition(int id, Date dateSignature, int id_colis, String statut) {
        this.id = id;
        this.dateSignature = Date.valueOf(LocalDate.now());
        this.id_colis = id_colis;
        this.statut = statut;
    }
    
    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateSignature() {
        return dateSignature;
    }

    public void setDateSignature(Date dateSignature) {
        this.dateSignature = dateSignature;
    }

    public int getId_colis() {
        return id_colis;
    }

    public void setId_colis(int id_colis) {
        this.id_colis = id_colis;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

public DocumentExpedition ( ){
}

@Override
public String toString() {
        return "Document d'expedition{" + "id=" + id + ", DateSignature=" +dateSignature+ ", Status=" +statut+ "Id_Colis="+id_colis+"}/n";
    }
/*                 Trie Document  par critere souhaité            */

public List<DocumentExpedition> trier(String critere) {
   Statement ste;
Connection conn = MyConnection.getInstance().getConn();
    List<DocumentExpedition> documentsTrie = new ArrayList<>();
    try {
        String requeteSQL = "SELECT * FROM document_expedition ORDER BY " + critere;
        PreparedStatement stmt = conn.prepareStatement(requeteSQL);
        ResultSet result = stmt.executeQuery();
        while (result.next()) {
            DocumentExpedition d = new DocumentExpedition();
            d.setId(result.getInt("id"));
            d.setDateSignature(result.getDate("dateSignature"));
            d.setId_colis(result.getInt("id_colis"));
            d.setStatut(result.getString("statut"));
            documentsTrie.add(d);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return documentsTrie;
}
}

