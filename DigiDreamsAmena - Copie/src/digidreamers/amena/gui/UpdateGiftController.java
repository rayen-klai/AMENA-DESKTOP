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
public class UpdateGiftController implements Initializable {

    @FXML
    private Button btnRet;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tdDesc;
    @FXML
    private TextField tfValu;
    @FXML
    private TextField tfIdC;
    @FXML
    private Button btnModify;
    @FXML
    private AnchorPane pane11;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tfName.setText(DetailsGiftsController.g.getName());
        tdDesc.setText(DetailsGiftsController.g.getDescription());
        tfValu.setText(DetailsGiftsController.g.getValue());
        tfIdC.setText(Integer.toString(DetailsGiftsController.g.getIdC()));
    }    

    @FXML
    private void retournerverG(ActionEvent event) {
                   try {
            Parent sv;
            sv = (AnchorPane) FXMLLoader.load(getClass().getResource("DetailsGifts.fxml"));
            pane11.getChildren().removeAll();
            pane11.getChildren().setAll(sv);
        } catch (IOException ex) {
            Logger.getLogger(DetailsGiftsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void updateGift(ActionEvent event) {
          try {
            String name = tfName.getText();
            String description = tdDesc.getText();
            String value = tfValu.getText();
            int idC = Integer.parseInt(tfIdC.getText());
             Gifts g =new Gifts(DetailsGiftsController.g.getId(),name, description, value, idC);
             GiftsCRUD gc = new GiftsCRUD();
            
            gc.modifier(g);     
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
    
}
