/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Annonce;
import services.AnnonceCRUD;

/**
 * FXML Controller class
 *
 * @author Nour Saidi
 */
public class AjoutDController implements Initializable {

    @FXML
    private Button tfValide;
    @FXML
    private TextField tfPrix;
    @FXML
    private TextField tfDate_D;
    @FXML
    private TextField tfDate_A;
    @FXML
    private TextArea tfDesc;
    @FXML
    private ChoiceBox<String> cbVilleDep;
     @FXML
    private ChoiceBox<String> cbVilleArr;
    @FXML
    private ChoiceBox<String> cbType;
    
   
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    ObservableList<String> villes = FXCollections.observableArrayList(
        "TUNIS",
        "ARIANA",
        "MENZAH"   
    );
    cbVilleDep.setItems(villes);
    cbVilleArr.setItems(villes);
    ObservableList<String> types = FXCollections.observableArrayList(
        "Demande",
        "Offre"
           
    );
    cbType.setItems(types);
        
       
    }    

    @FXML
    private void btnValider(ActionEvent event) {
         if (tfPrix.getText().isEmpty() || cbVilleDep.getValue() == null || cbVilleArr.getValue() == null || cbType.getValue() == null 
            || tfDate_D.getText().isEmpty() || tfDate_A.getText().isEmpty() || tfDesc.getText().isEmpty()) 
         {
         Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir tous les champs!");
        alert.showAndWait();
        
    } else {
        Annonce A =new Annonce();
        A.setPrix(Integer.parseInt(tfPrix.getText()));
        A.setVille_dep(cbVilleDep.getValue());
        A.setVille_arr(cbVilleArr.getValue());
        A.setDate_dep(tfDate_D.getText());
        A.setDate_arr(tfDate_A.getText());
        A.setDescription(tfDesc.getText());
        A.setType(cbType.getValue());
        
        AnnonceCRUD AJ = new AnnonceCRUD();
        AJ.ajouter(A);
    }
    }
}
