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

        
      User mm = new User("cin", "adress", "nom", "prenom", date, date, true, "mot_pass", "emasqqsdqil", "role", "token", "image", "num","sqdqsd");

   //User mm = new User("nom", "prenom", date, "123123", "aymen.donga@gmail.com", "role");
         UserService userService = new UserService();
    //   userService.ajouter(mm);
//User aa = userService.getByID(100);
//mm.setAdress("ghaziiii");*/

User a=userService.getByID(146);
        System.out.println(a);
a.setImage("aaaaaaaaaaaaaaaaaaa6");



System.out.println(a);
        System.out.println("amenadddain(56454)é");
userService.modifier(a);
        System.out.println("dddd)");

//userService.modifier(mm);

    }

}
