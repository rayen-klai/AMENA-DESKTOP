/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amena.services;

import amena.interfaces.InterfaceCRUD ;
import amena.model.Vehicule;
import amena.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author klair
 * @param <T>
 */
public class VehiculeCRUD implements InterfaceCRUD<Vehicule> {

    Statement ste;
    Connection conn = MyConnection.getInstance().getConn();
    public void ajouter(Vehicule v) {
        try {
            String req = "INSERT INTO `vehicule` (`type`, `immat`, `etat`, `kilometrage`, `chevaux`, `marque`, `couleur`, `prix`,`img`) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(req);
          
            ps.setString(1, v.getType());
            ps.setString(2, v.getImmat());
            ps.setBoolean(3, v.isEtat());
            ps.setString(4, v.getKilometrage());
            ps.setInt(5, v.getChevaux());
            ps.setString(6, v.getMarque());
            ps.setString(7, v.getCouleur());
            ps.setFloat(8, v.getPrix());
            ps.setString(9, v.getImg());

         
             ps.executeUpdate();
            System.out.println("Vehicule ajouté!!!");
        } catch (SQLException ex) {
            ex.printStackTrace();                    
        }   
 }

    public VehiculeCRUD() {
    }
    
    public void modifier(Vehicule v) {
        int inetat ; 
        if (v.isEtat())
            inetat=1 ;
        else
            inetat=0; 
        try {
            String req = "UPDATE `vehicule` SET `type` = '" + v.getType() + "', `immat` = '" + v.getImmat()+ "', `etat` = '" + inetat + "', `kilometrage` = '" + v.getKilometrage()+ "', `chevaux` = '" + v.getChevaux()+ "', `marque` = '" + v.getMarque()+ "', `couleur` = '" + v.getCouleur()+ "', `prix` = '" + v.getPrix()+"', `img` = '" + v.getImg()+ "' WHERE idV = " + v.getId();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("vehicule updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `vehicule` WHERE idV = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("vehicule deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    
    @Override
    public  List<Vehicule> afficher() {
       List<Vehicule>list = new ArrayList<>();
        try {
            String req = "Select * from vehicule";
            Statement st = conn.createStatement();
           
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
            Vehicule v = new Vehicule();
             v.setId(RS.getInt(1));
             v.setType(RS.getString(2));
             v.setImmat(RS.getString(3));
             v.setEtat(RS.getBoolean(4));
             v.setKilometrage(RS.getString(5));
             v.setChevaux(RS.getInt(6));
             v.setMarque(RS.getString(7));
             v.setCouleur(RS.getString(8));
             v.setPrix(RS.getFloat(9));
             v.setImg(RS.getString(10));
             list.add(v);
           
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
        
    @Override
    public Vehicule getByID(int id)
    {
        Vehicule v = new Vehicule();
        try {
        String req = "Select * from vehicule where idV = "+id;
        Statement st = conn.createStatement();
        
        ResultSet RS= st.executeQuery(req);
        while(RS.next()){
        v.setId(RS.getInt(1));
        v.setType(RS.getString(2));
        v.setImmat(RS.getString(3));
        v.setEtat(RS.getBoolean(4));
        v.setKilometrage(RS.getString(5));
        v.setChevaux(RS.getInt(6));
        v.setMarque(RS.getString(7));
        v.setCouleur(RS.getString(8));
        v.setPrix(RS.getFloat(9));
        }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return v ; 
        
    }
    
    public List<Vehicule> filterByEtat(int e)
    {
        List<Vehicule>list = new ArrayList<>();

        try {
        String req = "Select * from vehicule where etat = "+e;
        Statement st = conn.createStatement();
        
        ResultSet RS= st.executeQuery(req);
        while(RS.next()){
        Vehicule v = new Vehicule();
        v.setId(RS.getInt(1));
        v.setType(RS.getString(2));
        v.setImmat(RS.getString(3));
        v.setEtat(RS.getBoolean(4));
        v.setKilometrage(RS.getString(5));
        v.setChevaux(RS.getInt(6));
        v.setMarque(RS.getString(7));
        v.setCouleur(RS.getString(8));
        v.setPrix(RS.getFloat(9));
        list.add(v);
        }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list ; 
         
    }
    

}
