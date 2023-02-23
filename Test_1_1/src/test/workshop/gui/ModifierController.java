/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.workshop.gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
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
import test.workshop.utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ModifierController implements Initializable {

    @FXML
    private TextField idfield;
    @FXML
    private TextField nomExField;
    @FXML
    private TextField adressExField;
    @FXML
    private TextField nomDesField;
    @FXML
    private TextField adressDesField;
    @FXML
    private TextField poidsField;
    @FXML
    private Button btnMod;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

    }    
 // Récupération de la connexion à la base de données
   private Connection conn = MyConnection.getInstance().getConn();
 // Méthode appelée lors du clic sur le bouton de modification
    @FXML
   /* private void ModifierColis(ActionEvent event) {
        try {
            // Création d'un objet Colis à partir des données saisies dans les champs de texte
            Colis colis = new Colis();
            colis.setId(Integer.parseInt(idfield.getText()));
            colis.setNomExpediteur(nomExField.getText());
            colis.setAdresseExpediteur(adressExField.getText());
            colis.setNomDestinataire(nomDesField.getText());
            colis.setAdresseDestinataire(adressDesField.getText());
            colis.setPoids(Float.parseFloat(poidsField.getText()));

            // Appel de la méthode "modifier" du CRUD
            ColisCRUD c = new ColisCRUD();
            c.modifier(colis);
            // Affichage d'un message de succès
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Modification de colis");
            alert.setHeaderText(null);
            alert.setContentText("Le colis a été modifié avec succès !");
            alert.showAndWait();

            // Fermeture de la fenêtre
            Stage stage = (Stage) btnMod.getScene().getWindow();
            stage.close();

         }catch (NumberFormatException e) {
            // Affichage d'un message d'erreur en cas de saisie invalide pour le poids
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("Le poids doit être un nombre !");
            alert.showAndWait();
        }       */
    
   private void ModifierColis(ActionEvent event) {
    String idText = idfield.getText();
    String nomExpediteur = nomExField.getText();
    String adresseExpediteur = adressExField.getText();
    String nomDestinataire = nomDesField.getText();
    String adresseDestinataire = adressDesField.getText();
    String poidsText = poidsField.getText();

    // Vérification de saisie
    if (idText.isEmpty() || nomExpediteur.isEmpty() || adresseExpediteur.isEmpty() || nomDestinataire.isEmpty() || adresseDestinataire.isEmpty() || poidsText.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir tous les champs.");
        alert.showAndWait();
        return;
    }
    if (!idText.matches("\\d+")) {
        // Affichage d'un message d'erreur si le champ n'est pas du bon format
        Alert alert = new Alert(AlertType.ERROR, "L'identifiant doit être un nombre entier.");
        alert.showAndWait();
        return;
    }
    if (!poidsText.matches("\\d+(\\.\\d+)?")) {
        // Affichage d'un message d'erreur si le champ n'est pas du bon format
        Alert alert = new Alert(AlertType.ERROR, "Le poids doit être un nombre décimal.");
        alert.showAndWait();
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

    int idColis = Integer.parseInt(idText);
    float poidsColis = Float.parseFloat(poidsText);

    // Création d'un nouvel objet Colis avec les données récupérées
    Colis c = new Colis(idColis, nomExpediteur, adresseExpediteur, nomDestinataire, adresseDestinataire, poidsColis);
    ColisCRUD colisCRUD = new ColisCRUD();
    Colis colis = colisCRUD.getByID(idColis); 
    if (colis == null) {
        // Si le colis n'existe pas, afficher un message d'erreur
        Alert alert = new Alert(AlertType.ERROR, "Le colis avec l'identifiant " + idText + " n'existe pas.");
        alert.showAndWait();
        return;
    }
    // Modification du colis dans la base de données
    ColisCRUD col = new ColisCRUD();
    col.modifier(c);

    // Affichage du message de succès
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Succès");
    alert.setHeaderText(null);
    alert.setContentText("Colis modifié avec succès !");
    alert.showAndWait();
            Stage stage = (Stage) btnMod.getScene().getWindow();
            stage.close();
        
    }
}


    


    

