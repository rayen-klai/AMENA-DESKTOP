/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.Evaluation;
import org.controlsfx.control.Rating;
import services.EvaluationCRUD;
//onRatingChanged="#onRatingChanged" rating="0"
/**
 * FXML Controller class
 *
 * @author Nour Saidi
 */
public class ClientController implements Initializable {

    /**
     * Initializes the controller class.
     */
      @FXML
private VBox vbox;
  @FXML
private Rating rating;
  @FXML
    private Button saveButton;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       Rating rating = new Rating();
        rating.setPartialRating(true);

       // VBox vbox = new VBox(rating);
       // Scene scene = new Scene(vbox);

        
   
    }  
     @FXML
    private void handleSaveButtonAction(ActionEvent event) {
        double note = rating.getRating();
                // Enregistrer l'évaluation dans la table d'évaluation des clients
                EvaluationCRUD EV = new EvaluationCRUD();
                Evaluation E = new Evaluation ();
                E.setIdClient(1); 
                E.setIdTransporteur(1); 
         EV.ajouterE(note,E);
        // Mettre à jour le score du transporteur dans la table utilisateur
        //calculerScoreTransporteur(idTransporteur);
        // Enregistrer l'évaluation dans la base de données
        // ...
}

    
}
