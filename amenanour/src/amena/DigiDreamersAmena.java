/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digidreamers.amena;

import digidreamers.amena.Models.Message;
import digidreamers.amena.Models.Role;
import digidreamers.amena.Models.User;
import digidreamers.amena.Services.ChatService;
import digidreamers.amena.Services.RoleService;
import digidreamers.amena.Services.UserService;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author aymen
 */
public class DigiDreamersAmena {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {

        /*
        
        Message cmm1 =new Message(5,24,"dimanche!! parfait",date);
        Message cmm2 =new Message(25,24,"a quelle heuresvous arivez",date);
        Message cmm4 =new Message(22,24,"bonjourr",date);
        
       Role role=new Role(20,"admin");
         Role a=new Role(1,"client");
          Role b=new Role(2,"transporteur");
           Role c=new Role(3,"transporteu_s");
          
        
        User user1=new User("12", "tn", "mohamed", "hamadii",date , true, "mdp", "a@a",  a);
         User user2=new User("12", "fn", "lhedii", "pren",date , true, "mdp", "a@a",  b);
          User user3=new User("12", "dm", "zouaoui", "pren",date , true, "mdp", "a@a",  c);
         
        //System.out.println(user1.toString());
        
       /////////////////////////////////
             
              RoleService role =new RoleService();
            role.ajouter(a);
            role.ajouter(b);
            role.ajouter(c);
            /////////////////////////////////
           
            UserService userService=new UserService();
             userService.ajouter(user1);
               userService.ajouter(user2);
                userService.ajouter(user3);
             
            ////////////////////
            
         
            ChatService chatService =new ChatService();
         
            chatService.ajouter(cmm1);
            chatService.ajouter(cmm2);
            chatService.ajouter(cmm4);
            
            
          
            
             
            // System.out.println(userService.getUserByName("nohhm"));
             //System.out.println(userService.getUserByID(235));
             
             //userService.UpdateUser(user,52);
       // }catch (SQLException e) {
            //System.out.println("Personne non ajouté");
        }
            // TODO code application logic here

         
         
         
         */
        RoleService roleService = new RoleService();
        // création des 3 rôles
        Role roleAdmin = new Role(50, "admin");
        Role roleClient = new Role(51, "client");
        Role roleTransporteur = new Role(53, "transporteur");
        /*roleService.ajouter(roleAdmin);
    roleService.ajouter(roleClient);
    roleService.ajouter(roleTransporteur);*/
        Date date = new java.sql.Date(new java.util.Date().getTime());
        // création des 4 utilisateurs

        UserService userService = new UserService();
        
         User user1=new User("12", "tn", "mohamed", "hamadii",date , true, "mdp", "a@a",  roleAdmin);
         User user2=new User("12", "fn", "lhedii", "pren",date , true, "mdp", "a@a",  roleClient);
         User user3=new User("12", "dm", "zouaoui", "pren",date , true, "mdp", "a@a",  roleTransporteur);
       /*
    userService.ajouter(user1);
    userService.ajouter(user2);
    userService.ajouter(user3);
         */
 System.out.println("0");
        // affichage de tous les utilisateurs
        System.out.println(userService.afficher());
         System.out.println("1");

        // affichage de l'utilisateur ayant l'id 25
        System.out.println(userService.getByID(257));
       

        // suppression de l'utilisateur ayant l'id 14
         System.out.println("3");
        userService.supprimer(258);
         System.out.println("4");
         System.out.println(userService.afficher());
         System.out.println("5");
        System.out.println(userService.getUserByName("mohamed")); 
         
        
        

    }

}
