/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digidreamers.amena.gui;

import digideramers.amena.models.Gifts;
import digidreamers.amena.services.GiftsCRUD;
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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Ahlem
 */
public class AddGiftController implements Initializable {

    @FXML
    private AnchorPane pane3;
    @FXML
    private Button btnAjout;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfDescription;
    @FXML
    private TextField tfValue;
    @FXML
    private TextField tfidComp;
    @FXML
    private Button btnRetour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveGift(ActionEvent event) {
         try {
            String name = tfName.getText();
            String description = tfDescription.getText();
            String value = tfValue.getText();
            int idC = Integer.parseInt(tfidComp.getText());
             Gifts g =new Gifts(name, description, value, idC);
             GiftsCRUD gc = new GiftsCRUD();
            
            gc.ajouter(g);     
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailsGifts.fxml"));
            Parent root = loader.load();
            DetailsGiftsController dgc = loader.getController();
           /* dcc.setTitle(c.getTitle());
            dcc.setDate_deb(""+c.getDate_deb());
            dcc.setDate_fin(""+c.getDate_fin());
            dcc.setType(""+c.getType());
            dcc.setNbp(""+c.getNbp());*/
            
            tfName.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage()); ;
        }
        
    }

    @FXML
    private void retournerversGift(ActionEvent event) {
          try
        {
            Parent sv ;
            sv = (AnchorPane)FXMLLoader.load(getClass().getResource("DetailsGifts.fxml"));
          pane3.getChildren().removeAll() ; 
          pane3.getChildren().setAll(sv) ;                              
        } catch (IOException ex) {
             Logger.getLogger(GestionGamificationController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
}
