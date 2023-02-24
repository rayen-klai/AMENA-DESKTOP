/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amena.gui.ajoutV2;

import amena.gui.LocationInterface.GestionLocationController;
import amena.gui.ajoutV1.FajoutController;
import amena.gui.dashboard.First3Controller;
import amena.model.Vehicule;
import amena.services.VehiculeCRUD;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author klair
 */
public class Fajout2Controller implements Initializable {

    @FXML
    private Button buttonback;
    private TextField tfmat;
    private TextField tfmar;
    private TextField tfchv;
    private TextField tfprx;
    private ColorPicker tfclr;
    private ImageView imgv;

    private String urlImg; 
    @FXML
    private AnchorPane paneA3;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public boolean verif_Num(String num)
    {
        int i=0; 
        while(i<num.length() && Character.isDigit(num.charAt(i)))
            i++ ;
        if(i<num.length())
            return false ; 
        return true ;
    }
    
    public boolean testMat(String mat)
    {
      String ch1 ="";
      String ch2 = "" ;
      String ch3 ="" ; 
      
      int i=0,ns=0 ;  
      
      if(mat.length()==0)
          return false ;
      
      for (i=0;i<mat.length();i++)
          if(mat.charAt(i)== ' ')
              ns++ ;

        if(ns!=2)
         return false ;
     
        i=0;
      while(mat.charAt(i)!= ' ')
        {
            ch1+=  mat.charAt(i) ; 
            i++;
        }
      
      i++; 
      while(mat.charAt(i)!= ' ')
        {
            
            ch2+=  mat.charAt(i) ; 
            i++;
        }
    i++;
    for(int k=i;k<mat.length();k++)
        {
            System.out.println(k);
            ch3+=  mat.charAt(k) ; 
        }
    
       if( (!verif_Num(ch1)) || (!verif_Num(ch3)) || (ch2=="tun"))
        return false ;
       return true ;

    }
    
    
    public boolean testMar(String mar)
    { 
        if (mar.length() == 0 )
            return false ; 
       return true ; 
   }
    
     public boolean testChv(String chv)
    { 
        if (chv.length() == 0 || !verif_Num(chv) )
            return false ;
        return true ; 
        
   }
    
    public boolean test_prx(String prx)
    {
        if(prx.length() == 0 || !verif_Num(prx) )
            return false ;
        return true ;
    }
    
    
    public boolean test(String mat,String mar,String chvx,String prx)
    {
        if (testMat(mat) && testMar(mar) && testChv(chvx) && test_prx(prx) )
            return true ;
        return false ;
                   
                
    }
    
    

       
            

    
@FXML
    private void ajoutpic(ActionEvent event) {
         FileChooser fileChooser = new FileChooser();
        File selectedfile = fileChooser.showOpenDialog(null);
        if (selectedfile != null) {
           urlImg = selectedfile.toURI().toString() ; 
            Image image = new Image(urlImg) ; 
            imgv.setImage(image);
        }
  

    }
@FXML
    private void ajouterBc(ActionEvent event) {
         if(test(tfmat.getText(),tfmar.getText(),tfchv.getText(),tfprx.getText()))
        {
    
     Vehicule v = new Vehicule("Voiture",tfmat.getText(),false,"0",Integer.parseInt(tfchv.getText()),tfmar.getText(),tfclr.getValue().toString(),Float.parseFloat(tfprx.getText()),urlImg) ;         
        VehiculeCRUD vc = new VehiculeCRUD() ;
        vc.ajouter(v);
         Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Ajout réussi !");
        alert.showAndWait();
   /* try
        {
            Parent sv ;
            sv = (AnchorPane)FXMLLoader.load(getClass().getResource("../ajoutV1/Fajout.fxml"));
          paneA2.getChildren().removeAll() ; 
          paneA2.getChildren().setAll(sv) ;                              
        } catch (IOException ex) {
             Logger.getLogger(Fajout2Controller.class.getName()).log(Level.SEVERE, null, ex);
         }        
        */
        }
        else 
        {
          Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("Vérifiez vos champs !");
        alert.showAndWait();
        }
        
        
    }
    
}
