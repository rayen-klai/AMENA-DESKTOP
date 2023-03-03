/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import interfaces.InterfaceCRUD;
import model.Annonce;
import utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nour Saidi
 */
public class AnnonceCRUD implements InterfaceCRUD<Annonce>{
     Statement ste;
    Connection conn = MyConnection.getInstance().getConn();
    
   // @Override
    
       public void ajouter(Annonce a) {
        try {
            String req = "INSERT INTO `annonces`( `type`, `ville_dep`,`ville_arr`,`date_dep`,`date_arr`,`prix`,`description`) VALUES ('"+a.getType()+"','"+a.getVille_dep()+"','"+a.getVille_arr()+"','"+a.getDate_dep()+"','"+a.getDate_arr()+"','"+a.getPrix()+"','"+a.getDescription()+"')";
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Annonce ajouté!!!");
        } catch (SQLException ex) {
            System.out.println("Annonce non ajouté");
                      }
 }
    
    //////////////////////
      //  @Override
    public void modifier(Annonce a) {
        try {
            
           String req = "UPDATE `annonces` SET `ville_dep` = '"+a.getVille_dep()+"',`ville_dep`='"+a.getVille_dep()+"',`ville_arr`='"+a.getVille_arr()+"',`date_dep`='"+a.getDate_dep()+"',`date_arr`='"+a.getDate_arr()+"',`prix`='"+a.getPrix()+"',`description`='"+a.getDescription()+"' WHERE annonces.id_annonce = " +a.getId_annonce();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Annonce updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    /////////////////////////////////
    //  @Override
    public void supprimer(int id_annonce) {
        try {
            String req = "DELETE FROM `annonces` WHERE id_annonce = " + id_annonce;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Annonce deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    ////////////////////////
     // @Override
    public List<Annonce> afficher() {
       List<Annonce> list = new ArrayList<>();
        try {
            String req = "Select * from annonces";
            Statement st = conn.createStatement();
           
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             Annonce a = new Annonce();
             a.setId_annonce(RS.getInt("id_annonce"));
             a.setVille_dep(RS.getString("ville_dep"));
             a.setVille_arr(RS.getString("ville_arr"));
             a.setDate_dep(RS.getString("date_dep"));
             a.setDate_arr(RS.getString("date_arr"));
             a.setPrix(RS.getInt("prix"));
             a.setDescription(RS.getString("description"));
           
             list.add(a);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
     public Annonce getByID(int id_annonce)
    {
        Annonce a = new Annonce();
        try {
        String req = "Select * from annonces where id_annonce = "+id_annonce;
        Statement st = conn.createStatement();
        
        ResultSet RS= st.executeQuery(req);
        while(RS.next()){
             a.setType (RS.getString(1));
             a.setVille_dep(RS.getString(2));
             a.setVille_arr(RS.getString(3));
             a.setDate_dep(RS.getString(4));
             a.setDate_arr(RS.getString(5));
             a.setPrix(RS.getInt(6));
             a.setDescription(RS.getString(7));
        }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return a ; 
        
    }
     
      public List<Annonce> filterByType(String type)
    {
        List<Annonce>list = new ArrayList<>();

        try {
        String req = "Select * from annonces where type = "+type;
        Statement st = conn.createStatement();
        
        ResultSet RS= st.executeQuery(req);
        while(RS.next()){
        Annonce a = new Annonce();
        a.setId_annonce(RS.getInt(1));
        a.setType(RS.getString(2));
        a.setVille_dep(RS.getString(3));
        a.setVille_arr(RS.getString(4));
        a.setDate_dep(RS.getString(5));
        a.setDate_arr(RS.getString(6));
        a.setPrix(RS.getInt(7));
        list.add(a);
        }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list ; 
         
    }
    
}
