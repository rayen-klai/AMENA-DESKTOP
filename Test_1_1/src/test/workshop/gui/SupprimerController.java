package test.workshop.gui;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import test.workshop.model.Colis;
import test.workshop.model.DocumentExpedition;
import test.workshop.services.ColisCRUD;
import test.workshop.services.DocumentExpeditionCRUD;

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

    private ColisCRUD docDAO;

    @FXML
    private void initialize() {
        docDAO = new ColisCRUD();
        docListView.getItems().setAll(docDAO.afficher());
        docListView.setCellFactory(param -> new ListCell<Colis>() {
    @Override
    protected void updateItem(Colis item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setText(null);
        } else {
            setText("Nom expéditeur: " + item.getNomExpediteur() + 
                    "\nAdresse expéditeur: " + item.getAdresseExpediteur() +
                    "\nNom destinataire: " + item.getNomDestinataire() +
                    "\nAdresse destinataire: " + item.getAdresseDestinataire() +
                    "\nStatut: " + item.getStatut()+
                    "\nDate d'expedition: " + item.getDateExpedition()+
                    "\nPoids: " + item.getPoids() + "kg");
        }
    }
});
    }

    @FXML
    private void handleSupprimerBtn() {
        Colis selectedDoc = docListView.getSelectionModel().getSelectedItem();
        if (selectedDoc != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir supprimer cet utilisateur ?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                docDAO.supprimer(selectedDoc.getId());
                docListView.getItems().remove(selectedDoc);
            showAlert("Colis supprimé");}
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