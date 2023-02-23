/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amena;

import amena.models.Competition;
import amena.models.Gifts;
import amena.services.CompetitionCRUD;
import amena.services.GiftsCRUD;
import java.sql.Date;

/**
 *
 * @author Ahlem
 */
public class DigiDreamsAmena {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // MyConnection mc = MyConnection.getInstance();
    
       
        GiftsCRUD gc = new GiftsCRUD();
        
        Gifts g1 = new Gifts("ahlem","desc1","v1", 1) ; 
        Gifts g2 = new Gifts("mhamdi","desc2","v2", 1) ; 
        
       gc.ajouter(g1);
        gc.ajouter(g2);
    
        System.out.println(gc.afficher());
        
        
        Gifts g3 = new Gifts("test","desc1","v1", 2) ; 
        gc.ajouter(g3);

    //    gc.modifier(g3);
    //    System.out.println(gc.afficher());

    //    gc.supprimer(8);
        
    //    System.out.println(gc.afficher());

    //    System.out.println(gc.getByID(7));

         // System.out.println(gc.filterByComp(1));
          
          
          
        
     //   CompetitionCRUD cr = new CompetitionCRUD(); 
       
    //    Competition c1= new Competition("titre1",Date.valueOf("2023-01-2"),Date.valueOf("2023-01-02"),1, 100) ; 
    //    Competition c2= new Competition("titre2",Date.valueOf("2023-04-29"),Date.valueOf("2023-05-07"),1, 200) ; 

    //    cr.ajouter(c1);
    //    cr.ajouter(c2);
        
       // System.out.println(cr.afficher());
        
        //Competition c3= new Competition(2,"titre3",Date.valueOf("2023-05-8"),Date.valueOf("2023-05-10"),3, 250) ; 

      //  cr.modifier(c3);
        
      //  System.out.println(cr.afficher());

      //  cr.supprimer(1);
      //  System.out.println(cr.afficher());
      
   //     System.out.println(cr.getByID(2));
      
        //System.out.println(cr.filterByType(1));
    } 
    
}
