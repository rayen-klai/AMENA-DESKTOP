/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amena.gui;

import static amena.gui.Identifier_votre_compteController.emailS;
import amena.model.User;

import amena.services.UserService;
import digidreamers.amena.gui.GestionGamificationController;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;

import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class ProfilController implements Initializable {

    private ListView<User> userListView;
    @FXML
    private Button quitterBtn;
    private TextField fxxemail;
    @FXML
    private Label fxnom;
    @FXML
    private Label fxprenom;
    @FXML
    private Label fxxadress;
    @FXML

    private Label fxcin;

    public static String semail;
    @FXML
    private Button chat;
    @FXML
    private Button btnsup;
    @FXML
    private Label fxdate;
    @FXML
    private Label fxemail;
    @FXML
    private Button btnmodifier;
    @FXML
    private ImageView img;
    @FXML
    private Button ajoutc;
    @FXML
    private Button btncomp;
    @FXML
    private AnchorPane PuserP;
    @FXML
    private Button btnnour;

    public void setUserInformation(String email) throws SQLException, FileNotFoundException {

        fxemail.setText(email);
        semail = email;
        UserService u = new UserService();
        User p = u.getUserByEmai(email);
        fxnom.setText(p.getNom());  // Récupérer l'utilisateur connecté
        fxprenom.setText(p.getPrenom());
        fxxadress.setText(p.getAdress());
        fxcin.setText(p.getCin());
        
        File file = new File(p.getImage());
       // FileInputStream fileInputStream = new FileInputStream(file);
        Image image = new Image(p.getImage());
        img.setImage(image);
        //fxdate.setText(user.getDate_naissance().toString());
        // fxemail.setText(p.getEmail());

    }

    public ProfilController() throws SQLException {

    }

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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modifier.fxml"));
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

    @FXML
    private void supprimer(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SupprimerProfil.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void modifierUtilisateur(ActionEvent event) throws IOException {
        try {
            Parent sv;
            sv = (AnchorPane) FXMLLoader.load(getClass().getResource("ValidationTransporteur.fxml"));
            PuserP.getChildren().removeAll();
            PuserP.getChildren().setAll(sv);
        } catch (IOException ex) {
            Logger.getLogger(GestionGamificationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void renitialiser(ActionEvent event) throws SQLException, IOException {
        emailS = semail;
        UserService userService = new UserService();
        User user = userService.getUserByEmai(emailS);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ResetPassword.fxml"));
        Parent root = loader.load();
        ResetPasswordController resetPasswordController = loader.getController();
        resetPasswordController.setCurrentUser(user);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void ajoutc(ActionEvent event) throws IOException {
        emailS = semail;

        try {
            Parent sv;
            sv = (VBox) FXMLLoader.load(getClass().getResource("/test/workshop/gui/FXML.fxml"));
            PuserP.getChildren().removeAll();
            PuserP.getChildren().setAll(sv);
        } catch (IOException ex) {
            Logger.getLogger(GestionGamificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void renitialiser(MouseEvent event) {
    }

    @FXML
    private void ajoutcomp(ActionEvent event) throws IOException {
        emailS = semail;

        try {
            Parent sv;
            sv = (AnchorPane) FXMLLoader.load(getClass().getResource("/digidreamers/amena/gui/AddCompetition.fxml"));
            PuserP.getChildren().removeAll();
            PuserP.getChildren().setAll(sv);
        } catch (IOException ex) {
            Logger.getLogger(GestionGamificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void mouve(ActionEvent event) {emailS = semail;

        try {
            Parent sv;
            sv = (AnchorPane) FXMLLoader.load(getClass().getResource("/gui/A.fxml"));
            PuserP.getChildren().removeAll();
            PuserP.getChildren().setAll(sv);
        } catch (IOException ex) {
            Logger.getLogger(GestionGamificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
}
