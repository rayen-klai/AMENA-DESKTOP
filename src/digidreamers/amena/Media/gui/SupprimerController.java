/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.Annonce;
import services.AnnonceCRUD;

/**
 * FXML Controller class
 *
 * @author Nour Saidi
 */
public class SupprimerController implements Initializable {

    /**
     * Initializes the controller class.
     */
      @FXML
    private ListView<Annonce> docListView;


    private AnnonceCRUD AN;
    @FXML
    private Button sup;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        AN = new AnnonceCRUD();
        docListView.getItems().setAll(AN.afficher());
    }  
   
    @FXML
    private void suppBtn(ActionEvent event) {
         Annonce selectedDoc = docListView.getSelectionModel().getSelectedItem();
        if (selectedDoc != null) {
            AN.supprimer(selectedDoc.getId_annonce());
            docListView.getItems().remove(selectedDoc);
            showAlert("Annonce supprimé");
        } else {
            showAlert("Veuillez sélectionner une Annonce à supprimer");
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
