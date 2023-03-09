/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.workshop.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import test.workshop.model.Colis;
import test.workshop.services.ColisCRUD;
import amena.utils.MyConnectionn;
import com.sun.org.apache.bcel.internal.classfile.ElementValue;
import digideramers.amena.models.Competition;
import static digidreamers.amena.gui.GestionGamificationController.c;
import digidreamers.amena.services.CompetitionCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ModifierController implements Initializable {

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
    @FXML
    private ListView<Colis> lvColis;
    private ColisCRUD ColisCRUD;
    private static  Colis  a ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ColisCRUD cc = new ColisCRUD();
        
        lvColis.getItems().addAll(cc.afficher3());

        lvColis.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Colis>() {
            public void changed(ObservableValue<? extends Colis> observable, Colis oldValue, Colis newValue) {
                a = lvColis.getSelectionModel().getSelectedItem();
                nomExField.setText(a.getNomExpediteur());

                adressExField.setText(a.getAdresseExpediteur());
                nomDesField.setText(a.getNomDestinataire());
                adressDesField.setText(a.getAdresseDestinataire());
                poidsField.setText(String.valueOf(a.getPoids()));

            }

        });

    }
    // Récupération de la connexion à la base de données
    private Connection conn = MyConnectionn.getInstance().getConn();
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

        if (!nomDestinataire.matches("[a-zA-Z ]+")) {
            // Si le nom contient autre chose que des lettres et des espaces, afficher un message d'erreur
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Le nom du destinataire ne doit contenir que des lettres et des espaces.");
            alert.showAndWait();
            return;
        }

        if (!nomExpediteur.matches("[a-zA-Z ]+")) {
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

    @FXML
    private void retournerPagePrecedente(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Accueil.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        // fermer la fenêtre actuelle
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }
}
