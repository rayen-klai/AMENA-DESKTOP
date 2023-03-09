package test.workshop.gui;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AccueilController {

    @FXML
    private Button ajoutColisBtn;
    @FXML
    private Button supprimerColisBtn;
    @FXML
    private Button modifierColisBtn;
    @FXML
    private Button afficherColisBtn;
    @FXML
    private Button OnLiv;
    @FXML
    private Button OnPos;


    // Méthode appelée lorsque l'utilisateur clique sur le bouton "Ajouter un colis"
    @FXML
    void onAjoutColis(ActionEvent event) throws IOException {
        Accueil accueil = new Accueil();
        Parent AjParent = FXMLLoader.load(getClass().getResource("FXML.fxml"));
            Scene profilScene = new Scene(AjParent);

            // Get the stage information
            Stage window = (Stage) modifierColisBtn.getScene().getWindow();

            // Set the new scene
            window.setScene(profilScene);
            window.show();
    }

    // Méthode appelée lorsque l'utilisateur clique sur le bouton "Supprimer un colis"
    @FXML
    void onSupprimerColis(ActionEvent event) throws IOException {
        Accueil accueil = new Accueil();
        Parent SupParent = FXMLLoader.load(getClass().getResource("Supprimer.fxml"));
            Scene profilScene = new Scene(SupParent);

            // Get the stage information
            Stage window = (Stage) modifierColisBtn.getScene().getWindow();

            // Set the new scene
            window.setScene(profilScene);
            window.show();
    }

    // Méthode appelée lorsque l'utilisateur clique sur le bouton "Modifier un colis"
    @FXML
    void onModifierColis(ActionEvent event) throws IOException {
        Parent ModParent = FXMLLoader.load(getClass().getResource("Modifier.fxml"));
            Scene profilScene = new Scene(ModParent);

            // Get the stage information
            Stage window = (Stage) modifierColisBtn.getScene().getWindow();

            // Set the new scene
            window.setScene(profilScene);
            window.show();
    }

    // Méthode appelée lorsque l'utilisateur clique sur le bouton "Afficher les colis"
    @FXML
    void onAfficherColis(ActionEvent event) throws IOException {
        Accueil accueil = new Accueil();
           Parent AffParent = FXMLLoader.load(getClass().getResource("AfficherColis.fxml"));
            Scene profilScene = new Scene(AffParent);

            // Get the stage information
            Stage window = (Stage) afficherColisBtn.getScene().getWindow();

            // Set the new scene
            window.setScene(profilScene);
            window.show();
             
    }
    private void openFXML(String fxml, Object controller) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            loader.setController(controller);
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(fxml);
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onLiv(ActionEvent event) throws IOException {
          Accueil accueil = new Accueil();
           Parent AffParent = FXMLLoader.load(getClass().getResource("Confirmer.fxml"));
            Scene profilScene = new Scene(AffParent);

            // Get the stage information
            Stage window = (Stage) OnLiv.getScene().getWindow();

            // Set the new scene
            window.setScene(profilScene);
            window.show();
    }

    @FXML
    private void onPos(ActionEvent event) throws IOException {
                  Accueil accueil = new Accueil();
           Parent AffParent = FXMLLoader.load(getClass().getResource("Map.fxml"));
            Scene profilScene = new Scene(AffParent);

            // Get the stage information
            Stage window = (Stage) OnPos.getScene().getWindow();

            // Set the new scene
            window.setScene(profilScene);
            window.show();
    }
}