/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import java.util.List;
import test.workshop.services.ColisCRUD;
import test.workshop.model.Colis;
import test.workshop.model.DocumentExpedition;
import test.workshop.utils.MyConnection;
/**
 *
 * @author hp
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
            MyConnection conn = MyConnection.getInstance();
            Colis colis = new Colis(1,"e", "e", "e", "e", 10); 
            ColisCRUD a = new ColisCRUD();
            /* a.ajouter(colis);*/
          /*  a.modifier(colis);*/
          
            System.out.println( a.afficher());
            System.out.println(a.getByID(14));
            
            /* Trie Colis par critere souhaité*/
            List<Colis> colisTries = colis.trier("nomExpediteur");
            colisTries.forEach((c) -> {
                System.out.println(c.getNomExpediteur());
        });
            
        /* Trie Document d'expedition par critere souhaité*/
       DocumentExpedition document = new DocumentExpedition();     
       List<DocumentExpedition> DocumentTrie = document.trier("statut");
            colisTries.forEach((c) -> {
                System.out.println(document.getStatut());
        }); 
    }
    
}
