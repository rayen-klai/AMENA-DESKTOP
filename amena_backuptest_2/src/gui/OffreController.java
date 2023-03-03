/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Image;
import java.net.URL;
import java.time.Duration;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.Annonce;
import org.controlsfx.control.Notifications;
import services.AnnonceCRUD;


/**
 * FXML Controller class
 *
 * @author Nour Saidi
 */
public class OffreController implements Initializable {

    @FXML
    private Button btnAcc;
      @FXML
private ScrollPane scrollPane;
            @FXML
private VBox vbox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int id = 10;
//Integer.parseInt(txtId.getText());
    AnnonceCRUD AC = new AnnonceCRUD();
    Annonce annonce = AC.getByID(id);
    if (annonce != null) {
       // Create a new AnchorPane to display the announcement details
         AnchorPane annoncePane = new AnchorPane();
            annoncePane.setPrefSize(600, 200); // taille de chaque annoncePane

            Label labelType = new Label("Type : " + annonce.getType());
            AnchorPane.setTopAnchor(labelType, 10.0);
            AnchorPane.setLeftAnchor(labelType, 10.0);

            Label labelVilleDep = new Label("Ville de départ : " + annonce.getVille_dep());
            AnchorPane.setTopAnchor(labelVilleDep, 30.0);
            AnchorPane.setLeftAnchor(labelVilleDep, 10.0);

            Label labelVilleArr = new Label("Ville d'arrivée : " + annonce.getVille_arr());
            AnchorPane.setTopAnchor(labelVilleArr, 50.0);
            AnchorPane.setLeftAnchor(labelVilleArr, 10.0);
            
            Label labelDateDep = new Label("Date de depart : " + annonce.getDate_dep());
            AnchorPane.setTopAnchor(labelDateDep, 70.0);
            AnchorPane.setLeftAnchor(labelDateDep, 10.0);
            
            Label labelDateArr = new Label("Date d'arrivée : " + annonce.getDate_arr());
            AnchorPane.setTopAnchor(labelDateArr, 90.0);
            AnchorPane.setLeftAnchor(labelDateArr, 10.0);
            
            Label labelPrix = new Label("Prix : " + annonce.getPrix());
            AnchorPane.setTopAnchor(labelPrix, 110.0);
            AnchorPane.setLeftAnchor(labelPrix, 10.0);

       annoncePane.getChildren().addAll(labelType, labelVilleDep, labelVilleArr,labelDateArr,labelDateDep,labelPrix);

        // Add the AnchorPane to the VBox
        vbox.getChildren().clear(); // Clear any previously displayed announcements
        vbox.getChildren().add(annoncePane);// Display the announcement details
        // ...
    } else {
         Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("Cette Annonce n'existe pas!");
        alert.showAndWait();
    }
        // TODO
    }    

    @FXML
    private void btnNotificationOnAction(ActionEvent event) {
        // Image image=new Image("amanalogo.png");

        Notifications notifications=Notifications.create();
       // notifications.graphic(new ImageView(image));
        notifications.text("hey im nour");
        notifications.title("Success Message");
       // notifications.hideAfter(Duration.seconds(4));
    
        notifications.show();
    }
    
}
