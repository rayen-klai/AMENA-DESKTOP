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
import com.sun.org.apache.bcel.internal.generic.AALOAD;
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

        
        // création des 3 utilisateurs

        Date date = new java.sql.Date(new java.util.Date().getTime());

        
     // User mm = new User("cin", "adress", "nom", "bbbbbprenom", date, date, true, "mot_pass", "emasqqsdqil", "role", "token", "image", "num","sqdqsd");

  // User mmb = new User("cin","nom", "prenom", date, date, true, "123123", "aymen.donga@gmail.com", "role","token", "image", "num","sqdqsd");
         UserService userService = new UserService();
    //userService.ajouter(mm);
//User aa = userService.getByID(100);
//mm.setAdress("ghaziiii");*/

User a=userService.getByID(159);
        System.out.println(a);
        
        
a.setAdress("arinaavvvvvvv");
a.setEmail("aymen@gmail.com");


System.out.println(a);
        System.out.println("amenadddain(56dddd454)é");
userService.modifierPassword(a);
        System.out.println("dddd)");

//userService.modifier(a);

    }

}
