/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digidreamers.amena.gui;

import digideramers.amena.models.Competition;
import digidreamers.amena.services.CompetitionCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Ahlem
 */
public class UpdateCompetitionController implements Initializable {

    @FXML
    private TextField tfTitle;
    @FXML
    private TextField tfDate_deb;
    @FXML
    private TextField tfDate_fin;
    @FXML
    private TextField tfType;
    @FXML
    private TextField tfNbp;
    @FXML
    private Button btnModifier;
    @FXML
    private AnchorPane pane2;
    @FXML
    private Button btnRe;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tfTitle.setText(GestionGamificationController.c.getTitle());
        tfDate_deb.setText(GestionGamificationController.c.getDate_deb().toString());
        tfDate_fin.setText(GestionGamificationController.c.getDate_fin().toString());
        tfType.setText(Integer.toString(GestionGamificationController.c.getType()));
        tfNbp.setText(Integer.toString(GestionGamificationController.c.getNbp()));
    }

    @FXML
    private void updateCompetition(ActionEvent event) {
        try {
            String title = tfTitle.getText();
            Date date_deb = Date.valueOf(tfDate_deb.getText());
            Date date_fin = Date.valueOf(tfDate_fin.getText());
            int type = Integer.parseInt(tfType.getText());
            int nbp = Integer.parseInt(tfNbp.getText());
            Competition c = new Competition(GestionGamificationController.c.getId(),title, date_deb, date_fin, type, nbp);        
            CompetitionCRUD cr = new CompetitionCRUD();
            cr.modifier(c);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("GestionGamification.fxml"));
            Parent root = loader.load();
            GestionGamificationController dcc = loader.getController();
            /* dcc.setTitle(c.getTitle());
            dcc.setDate_deb(""+c.getDate_deb());
            dcc.setDate_fin(""+c.getDate_fin());
            dcc.setType(""+c.getType());
            dcc.setNbp(""+c.getNbp());*/

            tfTitle.getScene().setRoot(root);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());;

        }
    }

    @FXML
    private void retournerver(ActionEvent event) {
        try {
            Parent sv;
            sv = (AnchorPane) FXMLLoader.load(getClass().getResource("GestionGamification.fxml"));
            pane2.getChildren().removeAll();
            pane2.getChildren().setAll(sv);
        } catch (IOException ex) {
            Logger.getLogger(GestionGamificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
