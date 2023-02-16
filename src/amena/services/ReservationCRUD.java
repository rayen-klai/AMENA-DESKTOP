/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amena.services;

import amena.interfaces.InterfaceCRUD ;
import amena.model.Reservation;
import amena.utils.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author klair
 * @param <T>
 */
public class ReservationCRUD implements InterfaceCRUD<Reservation> {

    Statement ste;
    Connection conn = MyConnection.getInstance().getConn();
    public void ajouter(Reservation r) {
        try {
            String req = "INSERT INTO `reservation` (`idVeh`, `idTrans`, `date_deb`, `date_fin`, `somme`) VALUES (?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(req);
             
            ps.setInt(1, r.getIdVeh());
            ps.setInt(2, r.getIdTrans());
            ps.setDate(3, r.getDate_deb());
            ps.setDate(4, r.getDate_fin());
            ps.setFloat(5, r.getSomme());
             ps.executeUpdate();
            System.out.println("Reservation ajouté!!!");
        } catch (SQLException ex) {
            ex.printStackTrace();                    
        }   
 }

    public ReservationCRUD() {
    }
    
    public void modifier(int id,Reservation r) {   
        try {
            String req = "UPDATE `reservation` SET `idVeh` = '" + r.getIdVeh() + "', `Date_Deb` = '" + r.getDate_deb()+ "', `date_fin` = '" + r.getDate_fin() + "', `somme` = '" + r.getSomme()+ "' WHERE idRes = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Reservation updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `reservation` WHERE idRes = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Reservation deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    
    @Override
    public  List<Reservation> afficher() {
       List<Reservation>list = new ArrayList<>();
        try {
            String req = "Select * from reservation";
            Statement st = conn.createStatement();
           
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
            Reservation r = new Reservation();
             r.setIdRes(RS.getInt(1));
             r.setIdVeh(RS.getInt(2));
             r.setIdTrans(RS.getInt(3));
             r.setDate_deb(RS.getDate(4));
             r.setDate_fin(RS.getDate(5));
             r.setSomme(RS.getFloat(6));
             list.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
        
    @Override
    public Reservation getByID(int id)
    {
        Reservation r = new Reservation();
        try {
        String req = "Select * from reservation where idRes = "+id;
        Statement st = conn.createStatement();
        
        ResultSet RS= st.executeQuery(req);
        while(RS.next()){
             r.setIdRes(RS.getInt(1));
             r.setIdVeh(RS.getInt(2));
             r.setIdTrans(RS.getInt(3));
             r.setDate_deb(RS.getDate(4));
             r.setDate_fin(RS.getDate(5));
             r.setSomme(RS.getFloat(6));
        }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return r ; 
        
    }
    
    public List<Reservation> filterByDate_fin(Date d)
    {
        List<Reservation>list = new ArrayList<>();

        try {
        String req = "Select * from reservation where date_fin = '"+d+"'";
        Statement st = conn.createStatement();
        ResultSet RS= st.executeQuery(req);
        while(RS.next()){
        Reservation r = new Reservation();
        r.setIdRes(RS.getInt(1));
        r.setIdVeh(RS.getInt(2));
        r.setIdTrans(RS.getInt(3));
        r.setDate_deb(RS.getDate(4));
        r.setDate_fin(RS.getDate(5));
        r.setSomme(RS.getFloat(6));
        list.add(r);
        }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list ; 
         
    }

}
