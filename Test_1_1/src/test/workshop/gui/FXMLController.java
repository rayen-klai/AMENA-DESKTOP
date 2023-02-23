/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.workshop.gui;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import test.workshop.model.Colis;
import test.workshop.services.ColisCRUD;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class FXMLController implements Initializable {

    @FXML
    private TextField nomExpediteurField;
    @FXML
    private TextField adresseExpediteurField;
    @FXML
    private TextField nomDestinataireField;
    @FXML
    private TextField adresseDestinataireField;
    @FXML
    private TextField poidsField;
    @FXML
    private Button quitterBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
private void ajouterColis(ActionEvent event) {
    String nomExpediteur = nomExpediteurField.getText();
    String adresseExpediteur = adresseExpediteurField.getText();
    String nomDestinataire = nomDestinataireField.getText();
    String adresseDestinataire = adresseDestinataireField.getText();
    String poidsText = poidsField.getText();

    // Vérification de saisie
    if (nomExpediteur.isEmpty() || adresseExpediteur.isEmpty() || nomDestinataire.isEmpty() || adresseDestinataire.isEmpty() || poidsText.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir tous les champs.");
        alert.showAndWait();
        return;
    }
    if (!poidsText.matches("\\d+(\\.\\d+)?")) {
        // Affichage d'un message d'erreur si le champ n'est pas du bon format
        Alert alert2 = new Alert(AlertType.ERROR, "Le poids doit être un nombre décimal.");
        alert2.showAndWait();
        return;
    }
    
    if(!nomDestinataire.matches("[a-zA-Z ]+")) {
    // Si le nom contient autre chose que des lettres et des espaces, afficher un message d'erreur
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Erreur");
    alert.setHeaderText(null);
    alert.setContentText("Le nom du destinataire ne doit contenir que des lettres et des espaces.");
    alert.showAndWait();
    return;
    }    
    
    if(!nomExpediteur.matches("[a-zA-Z ]+")) {
    // Si le nom contient autre chose que des lettres et des espaces, afficher un message d'erreur
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Erreur");
    alert.setHeaderText(null);
    alert.setContentText("Le nom de l'expéditeur ne doit contenir que des lettres et des espaces.");
    alert.showAndWait();
    return;
}

    float poidsColis = Float.parseFloat(poidsText);
    String statut = "En attente de traitement";
    LocalDate dateExpedition = LocalDate.now();

    // Création d'un nouvel objet Colis avec les données récupérées
    Colis c = new Colis(nomExpediteur, adresseExpediteur, nomDestinataire, adresseDestinataire, poidsColis);

    // Ajout du nouveau colis à la base de données
    ColisCRUD col = new ColisCRUD();
    col.ajouter(c);

    // Affichage du message de succès
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Succès");
    alert.setHeaderText(null);
    alert.setContentText("Colis ajouté avec succès !");
    alert.showAndWait();

    // Réinitialisation des champs
    nomExpediteurField.setText("");
    adresseExpediteurField.setText("");
    nomDestinataireField.setText("");
    adresseDestinataireField.setText("");
    poidsField.setText("");
}



     @FXML
    private void handleQuitterBtn(ActionEvent event) {
        Stage stage = (Stage) quitterBtn.getScene().getWindow();
        stage.close();
    }
}