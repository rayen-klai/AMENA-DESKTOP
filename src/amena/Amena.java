/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amena;

import amena.model.Reservation;
import amena.model.Vehicule;
import amena.services.ReservationCRUD;
import amena.services.VehiculeCRUD;
import java.sql.Date;


/**
 *
 * @author klair
 */
public class Amena {

    public static void main(String[] args) {
        
  /*      
        Vehicule v1 = new Vehicule("Voiture", "110 tun 1225", false,"0",0, "bmw","rouge",150);
        Vehicule v2 = new Vehicule("Moto", "55456", false,"0",0, "103","noir",75);
        Vehicule v3 = new Vehicule("Velo","", false,"0",0, "Btwin","vert",30);
        
        VehiculeCRUD vc = new VehiculeCRUD(); 
       
        vc.ajouter(v1) ;
        vc.ajouter(v2) ;
        vc.ajouter(v3) ;
        System.out.println(vc.afficher());
        
       Vehicule v4 = new Vehicule("Voiture", "110 tun 1225", true,"10000",0, "bmw","rouge",150);
        vc.modifier(7, v4);
        System.out.println(vc.afficher());
        
        vc.supprimer(10);
        vc.supprimer(11);
        vc.supprimer(12);
        vc.supprimer(13);
        vc.supprimer(9);

        
        System.out.println(vc.afficher());

        System.out.println(vc.getByID(14));
        
        System.out.println(vc.filterByEtat(0));
*/

        ReservationCRUD rc = new ReservationCRUD(); 
        
        
        Reservation r1 = new Reservation(6, 1,Date.valueOf("2023-1-1"),Date.valueOf("2023-1-10"),1000);
        Reservation r2 = new Reservation(7, 2,Date.valueOf("2023-2-1"),Date.valueOf("2023-1-10"),1500);
        Reservation r3 = new Reservation(8, 3,Date.valueOf("2023-3-1"),Date.valueOf("2023-3-10"),1000);
/*
        rc.ajouter(r1);
        rc.ajouter(r2);
        rc.ajouter(r3);
  */     
        System.out.println(rc.afficher());
      //  Reservation r4 = new Reservation(7, 2,Date.valueOf("2023-2-1"),Date.valueOf("2023-2-10"),1000);

      //  rc.modifier(11,r4);        
    //    System.out.println(rc.afficher());
    
       // rc.supprimer(12);
      //  System.out.println(rc.afficher());

        System.out.println(rc.getByID(11));
        
        System.out.println(rc.filterByDate_fin(Date.valueOf("2023-1-10")));




   }
    
}
