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
import model.Reaction;
//import services.reactionCRUD;

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
        Date date = new java.sql.Date(new java.util.Date().getTime());
        // MyConnection conn = MyConnection.getInstance();
        //Annonce a1 = new Annonce("Tunis", "manouba");
        //Annonce a2 = new Annonce("sousse", "Gammaret");
       // Annonce a5 = new Annonce("mehdia","sfax");
         Annonce a5 = new Annonce(10,"souggsse", "Gammaret");
        //  System.out.println(a1.toString());
        //   System.out.println(a2.toString());
        
        AnnonceCRUD ann = new AnnonceCRUD();
      
        //ann.ajouter(a2);
        //ann.modifier(a5);
        ann.supprimer(16);
       // System.out.println(ann.afficher()); 
        //System.out.println(ann.getByID(12));
        //System.out.println(ann.filterByType("type"));
        
        // Reaction r1 = new Reaction();
         //reactionCRUD rea = new reactionCRUD();
    }

}
