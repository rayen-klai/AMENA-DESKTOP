/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digidreamers.amena.GUI;

import digidreamers.amena.Models.User;

import digidreamers.amena.Services.UserService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class ProfilController implements Initializable {

    @FXML
    private ListView<User> userListView;
    @FXML
    private Button afficherBtn;
    @FXML
    private Button quitterBtn;
    @FXML
    private TextField fxxemail;
    @FXML
    private TextField fxnom;
    @FXML
    private TextField fxprenom;
    @FXML
    private TextField fxxadress;
    @FXML

    private TextField fxcin;
    
    public static String semail;
    @FXML
    private ImageView fximg;
    @FXML
    private Button chat;

    public void setUserInformation(String email) throws SQLException {

        fxxemail.setText(email);
        semail = email;
        UserService u = new UserService();
        User p = u.getUserByEmai(email);
        fxnom.setText(p.getNom());  // Récupérer l'utilisateur connecté
        fxprenom.setText(p.getPrenom());
        fxxadress.setText(p.getAdress());
        fxcin.setText(p.getCin());
        //fxdate.setText(user.getDate_naissance().toString());
        // fxemail.setText(p.getEmail());

    }

    public ProfilController() throws SQLException {

    }

    @FXML
    public void handleAfficherBtn(ActionEvent event) throws SQLException {

        UserService u = new UserService();

        List<User> list = u.afficher();
        u.afficher2(semail);
        ObservableList<User> observableList = FXCollections.observableArrayList(list);
        userListView.setItems(observableList);
    }

    @FXML
    private void handleQuitterBtn(ActionEvent event) {
        Stage stage = (Stage) quitterBtn.getScene().getWindow();
        stage.close();
    }

    private void handleModifierBtn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdateProfil.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void chat(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Chat.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        
    }
}
