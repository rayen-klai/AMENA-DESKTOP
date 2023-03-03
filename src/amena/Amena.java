/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amena;
import java.sql.Date;
import java.sql.SQLException;
import model.Annonce;
import services.AnnonceCRUD;
import utils.MyConnection;

/**
 *
 * @author Nour Saidi
 */
public class Amena {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Date date=new java.sql.Date(new java.util.Date().getTime());
       // MyConnection conn = MyConnection.getInstance();
        //Annonce a1 = new Annonce("Tunis", "manouba");
        //Annonce a2 = new Annonce("sousse", "Gammaret");
         Annonce a1 = new Annonce(12, "Gammaret","kmmmm;m","ll;l;l;l,",date,date);
      // / Annonce a2 = new Annonce("sousse", "Gammaret");
      //  System.out.println(a1.toString());
//        System.out.println(a2.toString());
        AnnonceCRUD ann = new AnnonceCRUD();
        
        ann.modifier(4,a1);
        System.out.println( ann.afficher());
    }
    
}
