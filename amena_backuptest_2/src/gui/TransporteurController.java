/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Annonce;
import model.Reaction;
import services.AnnonceCRUD;
import services.ReactionCRUD;

/**
 * FXML Controller class
 *
 * @author Nour Saidi
 */
public class TransporteurController implements Initializable {

    /**
     * Initializes the controller class.
     */
      @FXML
private VBox vbox;
  @FXML
private ScrollPane scrollPane;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ReactionCRUD RC = new ReactionCRUD();
         Reaction R =new Reaction();
        List<Reaction> list = RC.afficher();

        for (Reaction reaction : list) {
            AnchorPane annoncePane = new AnchorPane();
            annoncePane.setPrefSize(600, 80); // taille de chaque annoncePane

            Label labelPrix = new Label("id : " + reaction.getId());
            AnchorPane.setTopAnchor(labelPrix, 10.0);
            AnchorPane.setLeftAnchor(labelPrix, 10.0);

            Label labelVilleDep = new Label("id_annonce : " + reaction.getId_a());
            AnchorPane.setTopAnchor(labelVilleDep, 30.0);
            AnchorPane.setLeftAnchor(labelVilleDep, 10.0);

            Label labelVilleArr = new Label("id_user : " + reaction.getId_u());
            AnchorPane.setTopAnchor(labelVilleArr, 50.0);
            AnchorPane.setLeftAnchor(labelVilleArr, 10.0);
            
            Label labelType = new Label("id_colis : " + reaction.getId_c());
            AnchorPane.setTopAnchor(labelType, 70.0);
            AnchorPane.setLeftAnchor(labelType, 10.0);
            
            Button btnInteresse = new Button("Plus de détails..");
            
            
            // Définition de l'EventHandler pour le clic sur le bouton
         btnInteresse.setOnAction (event -> {
          
                try {
                    // Ouvrir l'interface d'ajout
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Offre.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(TransporteurController.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                }
         );
            AnchorPane.setTopAnchor(btnInteresse, 10.0);
            AnchorPane.setRightAnchor(btnInteresse, 10.0);
            annoncePane.getChildren().addAll(labelPrix, labelVilleDep, labelVilleArr,btnInteresse,labelType);

            vbox.getChildren().add(annoncePane);
        }
        scrollPane.setContent(vbox);
     

    }    
    
}
