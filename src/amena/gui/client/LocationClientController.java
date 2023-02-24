/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amena.gui.client;

import amena.gui.LocationInterface.GestionLocationController;
import amena.model.Vehicule;
import amena.services.VehiculeCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author klair
 */
public class LocationClientController implements Initializable {

    @FXML
    private ListView<Vehicule> lv;
    @FXML
    private ImageView imgv;
    @FXML
    private Label matLab;
    @FXML
    private Label marLab;
    @FXML
    private Label KilLab;
    @FXML
    private Label coulLab;
    @FXML
    private Label chvLab;
    @FXML
    private Label kmlab;
    @FXML
    private Label prxLab;
    @FXML
    private Button buttonReserver;

    public static Vehicule v ;
    @FXML
    private AnchorPane pane1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  VehiculeCRUD vc =new VehiculeCRUD() ; 
       lv.getItems().addAll(vc.afficher());
           
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
                      
                   });     }    

    @FXML
    private void ReserverButton(ActionEvent event) {
        
         try
        {
            Parent sv ;
            sv = (AnchorPane)FXMLLoader.load(getClass().getResource("reserver.fxml"));
          pane1.getChildren().removeAll() ; 
          pane1.getChildren().setAll(sv) ;                              
        } catch (IOException ex) {
             Logger.getLogger(GestionLocationController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
}
