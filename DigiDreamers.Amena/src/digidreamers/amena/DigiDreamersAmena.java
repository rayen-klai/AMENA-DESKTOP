/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amena;

import amena.gui.ProfilController;
import amena.model.Message;
import amena.model.Role;
import amena.model.User;
import amena.services.ChatService;
import amena.services.RoleService;
import amena.services.UserService;
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

        //RoleService roleService = new RoleService();
        // création des 3 rôles
        //Role a = new Role(50, "admin");
        //Role b = new Role(51, "client");
        // Role roleTransporteur = new Role(53, "transporteur");
        /*  
        
        roleService.ajouter(roleAdmin);
        roleService.ajouter(roleClient);
        roleService.ajouter(roleTransporteur);
        
        roleService.supprimer(59);
        
        roleService.supprimer(5);
        System.out.println(roleService.afficher());
         */
        Date date = new java.sql.Date(new java.util.Date().getTime());
        // création des 3 utilisateurs

        UserService userService = new UserService();

        //User user1 = new User("nom", "prenom", date, "123123", "aymen.donga@gmail.com", "role");
        //User mm = new User("nom", "prenom", date, "mot_pass", "emailjnhu", "role");
        //  userService.ajouter(user1);
        // User user3 = new User(105, "976749044", "adress", "nome", "prenom", date, true, "mot_pass", "email", "role", "token");
        //User aa =new User(105, "tsssssss");
        // userService.modifier(aa);
        User aa = new User(1, "adress", "nom", date, "mot_pass", "email", "role");
        aa.setNom("new_nom");
        userService.modifier(aa);

        System.out.println(userService.getByID(105));

        //System.out.println(userService.getUserByEmai("aymen@esprit.tn"));
        //userService.modifier(user3);
        //User user3 = new User("12", "dm", "zouaoui", "pren", date, true, "mdp", "a@gj@azadabb", roleTransporteur);
        //userService.ajouter(user1);
        //  System.out.println(userService.afficher2("aymenzouaoui@esprit.tn")); 
        // System.out.println(userService.getUserByEmai("aymenzouaoui@esprit.tn"));
        //userService.ajouter(user2);
        //userService.ajouter(user3);
/*
        System.out.println("0");
        // affichage de tous les utilisateurs
        System.out.println(userService.afficher());
        System.out.println("1");

        // affichage de l'utilisateur ayant l'id 25
        
        System.out.println("3");
        System.out.println(userService.getByID(257));

        // suppression de l'utilisateur ayant l'id 14
        System.out.println("4 ");
        userService.supprimer(258);
        
        
        //modifer user 
        System.out.println("user modifier");
        User user4 = new User(256, "aaaaaaa", "dmdsds", "zouaoui", "presddsn", date, true, "mdfsp", "a@a", roleTransporteur);
        userService.modifier(user4);
        
        System.out.println("aficher");
        System.out.println("afficher tous les users");
        System.out.println(userService.afficher());
        System.out.println("5");
        System.out.println(userService.getUserByName("mohamed"));
        
         */
    }

}
