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
       
            String req = "INSERT INTO `annonces`(`ville_dep`, `ville_arr`, `date_dep`, `date_arr`, `prix`, `description`) VALUES ('"+a.getVille_dep()+"','"+a.getVille_arr()+"','"+a.getDate_dep()+"','"+a.getDate_arr()+"','"+a.getPrix()+"','"+a.getDescription()+"')";
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Annonce ajouté!!!");
        } catch (SQLException ex) {
            System.out.println("Annonce non ajouté!!!");
                      }
 }
    
    //////////////////////
      //  @Override
    public void modifier(int i,Annonce a) {
        try {
            
           String req = "UPDATE `annonces` SET `ville_dep` = '"+a.getVille_dep()+"',`ville_dep`='"+a.getVille_dep()+"',`ville_arr`='"+a.getVille_arr()+"',`date_dep`='"+a.getDate_dep()+"',`date_arr`='"+a.getDate_arr()+"',`prix`='"+a.getPrix()+"',`description`='"+a.getDescription()+"' WHERE `annonces`.`id_annonce` = " + i;
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
            String req = "DELETE FROM `personne` WHERE id_annonce = " + id_annonce;
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
             a.setVille_dep(RS.getString("ville_dep"));
             a.setVille_arr(RS.getString("ville_arr"));
             a.setDate_dep(RS.getDate("date_dep"));
             a.setDate_arr(RS.getDate("date_arr"));
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
             a.setVille_dep(RS.getString(1));
             a.setVille_arr(RS.getString(2));
             a.setDate_dep(RS.getDate(3));
             a.setDate_arr(RS.getDate(4));
             a.setPrix(RS.getInt(5));
             a.setDescription(RS.getString(6));
        }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return a ; 
        
    }
    
}
