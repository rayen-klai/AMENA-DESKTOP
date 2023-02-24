/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amena.gui.LocationInterface;

import amena.gui.dashboard.First3Controller;
import amena.model.Vehicule;
import amena.services.VehiculeCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author klair
 */


public class GestionLocationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private ListView<Vehicule> lv ; 

    
    
      public static Vehicule v ;
       
    @FXML
       private AnchorPane pane10 ; 
       
       @FXML
       private Label matLab; 
       @FXML
    private Label marLab;
    @FXML
    private Label coulLab;
    @FXML
    private Label prxLab;
    @FXML
    private Label kmlab;
    @FXML
    private Label chvLab;
    @FXML
    private Label KilLab;
    @FXML
    private Button buttonModifier;
    @FXML
    private ImageView imgv;
    @FXML
    private Label nbrvtr;
    @FXML
    private Label nbrv;
    @FXML
    private Label nbrcm;
    @FXML
    private Label nbrmto;
                        int nbv=0,nbc=0,nbm=0,nbvel=0 ; 

   
                        
    public void stats()
    {
                   List<Vehicule>list = new ArrayList<>();
                    VehiculeCRUD vc =new VehiculeCRUD() ; 
                   list=vc.afficher();
                    int nbv=0,nbc=0,nbm=0,nbvel=0 ; 

                   for (int i = 0; i < list.size(); i++) {
                 
                     if("Voiture".equals(list.get(i).getType()))
                        nbv++; 
                     if("Camion".equals(list.get(i).getType()))
                        nbc++; 
                     if("Moto".equals(list.get(i).getType()))
                        nbm++;
                     if("Velo".equals(list.get(i).getType()))
                        nbvel++; 
        }
              nbrvtr.setText(Integer.toString(nbv));
             nbrv.setText(Integer.toString(nbvel));
             nbrcm.setText(Integer.toString(nbc));
             nbrmto.setText(Integer.toString(nbm));

    }                        
                        @Override
    public void initialize(URL url, ResourceBundle rb) {
        VehiculeCRUD vc =new VehiculeCRUD() ; 
       lv.getItems().addAll(vc.afficher());
  stats();
            

//  lv.getItems().addAll(vc.afficher()); 
           lv.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Vehicule>()
                   {
           @Override
           public void changed(ObservableValue<? extends Vehicule> observable, Vehicule oldValue, Vehicule newValue) {
              v = lv.getSelectionModel().getSelectedItem() ; 
              matLab.setText(v.getImmat());
              kmlab.setText(v.getKilometrage());
              marLab.setText(v.getMarque());
              coulLab.setText(v.getCouleur());
              prxLab.setText(Float.toString(v.getPrix()));
             chvLab.setText(Integer.toString(v.getChevaux()));
imgv.setImage(new Image(v.getImg())) ; 
           
           
           }
                      
                   }); 

    }    
      @FXML 
    public void ajouterBC(ActionEvent event)
    {
        try
        {
            Parent sv ;
            sv = (AnchorPane)FXMLLoader.load(getClass().getResource("../ajoutV1/Fajout.fxml"));
          pane10.getChildren().removeAll() ; 
          pane10.getChildren().setAll(sv) ;                              
        } catch (IOException ex) {
             Logger.getLogger(GestionLocationController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
      @FXML 
    public void modifierButton(ActionEvent event)
    {
        try
        {
            Parent sv ;
            sv = (AnchorPane)FXMLLoader.load(getClass().getResource("../modifier/modifierV.fxml"));
          pane10.getChildren().removeAll() ; 
          pane10.getChildren().setAll(sv) ;                              
        } catch (IOException ex) {
             Logger.getLogger(GestionLocationController.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }

    

    @FXML
    private void btnsup2(ActionEvent event) {
     VehiculeCRUD vc = new VehiculeCRUD() ;
            
                vc.supprimer(v.getId());
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Suppression réussie !");
        alert.showAndWait();
            lv.getItems().clear();
            lv.getItems().addAll(vc.afficher());
stats();                   

    }
                      
    
}
