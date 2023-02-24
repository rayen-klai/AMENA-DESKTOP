/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*package services;

import interfaces.InterfaceCRUD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Annonce;
import utils.MyConnection;
import model.Reaction;*/

/**
 *
 * @author Nour Saidi
 */
/*public class reactionCRUD implements InterfaceCRUD<Reaction>{
     Statement ste;
    Connection conn = MyConnection.getInstance().getConn();
    
   // @Override
    
    public void ajouter(reaction r) {
        try {
       
            String req = "INSERT INTO `reactions`(`id_a`) SELECT (`id_annonce`) FROM `annonces` WHERE ('"+a.getP()==1+"')";
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("reaction ajouté!!!");
        } catch (SQLException ex) {
            System.out.println("reaction non ajouté!!!");
                      }
 }
    
    //////////////////////
      //  @Override
    public void modifier(int i,Annonce a) {
        try {
            
           String req = "UPDATE `reactions` SET `id_annonce` = '"+a.getId_annonce()+"' WHERE `reactions`.`id` = " + i;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("reaction updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    /////////////////////////////////
    //  @Override
    public void supprimer(int id_annonce) {
        try {
            String req = "DELETE FROM `reaction` WHERE id_annonce = " + id_annonce;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Annonce deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    ////////////////////////
     // @Override
    public List<Reaction> afficher() {
       List<Reaction> list = new ArrayList<>();
        try {
            String req = "Select * from reactions";
            Statement st = conn.createStatement();
           
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             Reaction r = new Reaction();
             r.setId(RS.getInt("id"));
           
           
             list.add(r);
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
    
}*/

