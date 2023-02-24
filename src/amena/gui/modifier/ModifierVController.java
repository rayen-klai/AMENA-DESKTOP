/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amena.gui.modifier;

import amena.gui.LocationInterface.GestionLocationController;
import static amena.gui.LocationInterface.GestionLocationController.v;
import amena.model.Vehicule;
import amena.services.VehiculeCRUD;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author klair
 */
public class ModifierVController implements Initializable {

    @FXML
    private TextField kmf;


    @FXML
    private TextField matf;
    @FXML
    private TextField marf;
    @FXML
    private TextField chvf;
    @FXML
    private TextField prxf;
    @FXML
    private ColorPicker clf;
    @FXML
    private Button picf;
    @FXML
    private ImageView imgv;
private String urlImg; 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       matf.setText(GestionLocationController.v.getImmat());
       marf.setText(GestionLocationController.v.getMarque());
       chvf.setText(Integer.toString(GestionLocationController.v.getChevaux()));
       prxf.setText(Float.toString(GestionLocationController.v.getPrix()));
      kmf.setText(GestionLocationController.v.getKilometrage());
      urlImg = GestionLocationController.v.getImg();
      imgv.setImage(new Image(urlImg)) ; 

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
    public boolean verif_Num2(String num)
    {
        int i=0; 
       for(i=0;i<num.length();i++)
           if(Character.isAlphabetic(num.charAt(i)))
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
        if(prx.length() == 0 || !verif_Num2(prx) )
            return false ;
        return true ;
    }
    
    
    public boolean test(String mat,String mar,String chvx,String prx,String km)
    {

       
        if (testMat(mat) && testMar(mar) && testChv(chvx) && test_prx(prx) && test_prx(kmf.getText()) )
            return true ;
        return false ;
                   
                
    }
    
    


    @FXML
    private void btnmod(ActionEvent event) {
         if(test(matf.getText(),marf.getText(),chvf.getText(),prxf.getText(),kmf.getText()))
        {
    
     Vehicule v = new Vehicule(GestionLocationController.v.getId(),GestionLocationController.v.getType(),matf.getText(),false,kmf.getText(),Integer.parseInt(chvf.getText()),marf.getText(),clf.getValue().toString(),Float.parseFloat(prxf.getText()),urlImg) ;         
        VehiculeCRUD vc = new VehiculeCRUD() ;
        vc.modifier(v);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Midification réussi !");
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
          Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("Vérifiez vos champs !");
        alert.showAndWait();
        }
        
        
    }
    @FXML
    private void btnpic(ActionEvent event) {
            FileChooser fileChooser = new FileChooser();
        File selectedfile = fileChooser.showOpenDialog(null);
        if (selectedfile != null) {
            System.out.println("dsdsds");
            urlImg = selectedfile.toURI().toString() ; 
            Image image = new Image(urlImg) ; 
            imgv.setImage(image);
        }
    }
    }
    

