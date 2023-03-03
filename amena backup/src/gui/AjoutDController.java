/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    private TextField tfVille_D;
    @FXML
    private TextField tfVille_A;
    @FXML
    private TextField tfDate_D;
    @FXML
    private TextField tfDate_A;
    @FXML
    private TextArea tfDesc;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
    }    

    @FXML
    private void btnValider(ActionEvent event) {
        Annonce A =new Annonce();
        A.setPrix(Integer.parseInt(tfPrix.getText()));
        A.setVille_dep(tfVille_D.getText());
        A.setVille_arr(tfVille_A.getText());
        A.setDate_dep(tfDate_D.getText());
        A.setDate_arr(tfDate_A.getText());
        A.setDescription(tfDesc.getText());
        
        AnnonceCRUD AJ = new AnnonceCRUD();
        AJ.ajouter(A);
    }
    
}
