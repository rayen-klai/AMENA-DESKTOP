/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.workshop.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import test.workshop.model.Colis;


import test.workshop.services.ColisCRUD;




/**
 * FXML Controller class
 *
 * @author hp
 */
public class SupprimerController {

  @FXML
    private ListView<Colis> docListView;

    @FXML
    private Button btnSupp;

    private ColisCRUD col;

    @FXML
    private void initialize() {
        col = new ColisCRUD();
        docListView.getItems().setAll(col.afficher2());
    }

    @FXML
    private void handleSupprimerBtn() {
        Colis selectedDoc = docListView.getSelectionModel().getSelectedItem();
        if (selectedDoc != null) {
            col.supprimer(selectedDoc.getId());
            docListView.getItems().remove(selectedDoc);
            showAlert("Colis supprimé");
        } else {
            showAlert("Veuillez sélectionner un colis à supprimer");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
}


