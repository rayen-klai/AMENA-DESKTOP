/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amena;

import java.sql.Date;
import java.sql.SQLException;
import model.Annonce;
import model.Evaluation;
import services.AnnonceCRUD;
import utils.MyConnection;
import model.Reaction;
import services.EvaluationCRUD;
import services.ReactionCRUD;
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
       // Date date = new java.sql.Date(new java.util.Date().getTime());
        // MyConnection conn = MyConnection.getInstance();
        //Annonce a1 = new Annonce("Tunis", "manouba");
        //Annonce a2 = new Annonce("sousse", "Gammaret");
       //Annonce a5 = new Annonce("mehdia","sfax");
        // Annonce a6 = new Annonce(22,"test", "test");
        //  System.out.println(a1.toString());
        //   System.out.println(a2.toString());
        
        //AnnonceCRUD ann = new AnnonceCRUD();
      
       //ann.ajouter(a5);
       //ann.modifier(a6);
       //ann.supprimer(16);
       // System.out.println(ann.afficher()); 
       //System.out.println(ann.getByID(12));
        //System.out.println(ann.filterByType("client"));
        
         
       //ReactionCRUD rea = new ReactionCRUD();
      // Reaction a3 = new Reaction(10, 20,30);
      // rea.ajouter(a3);
      // rea.supprimer(3);
      //System.out.println(rea.afficher());
      EvaluationCRUD ev = new EvaluationCRUD ();
      Evaluation e = new Evaluation (2,3);
      //ev.ajouterE(5,e);
      ev.calculerScoreTransporteur(5);
    }

}
