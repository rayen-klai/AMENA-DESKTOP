/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amena.gui;

import static amena.gui.Identifier_votre_compteController.emailS;
import static amena.gui.ProfilController.semail;
import amena.model.User;
import amena.services.UserService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class ResetPasswordController implements Initializable {

    @FXML
    private PasswordField fxmotpasse;
    @FXML
    private PasswordField fxCmotpasse;
    @FXML
    private Button BtnComfirmer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setUserInformation(String email) throws SQLException {

        semail = email;

        //fxdate.setText(user.getDate_naissance().toString());
        // fxemail.setText(p.getEmail());
    }

    @FXML
    private void Comfirmer(ActionEvent event) throws SQLException {
        String motpasse = fxmotpasse.getText();
        String Cmotpasse = fxCmotpasse.getText();

        if (motpasse.equals(Cmotpasse)) {
            UserService userService = new UserService();
            User user = new User();
            user.setEmail(semail); // assuming semail is set correctly by the setUserInformation method
            user.setMot_pass(motpasse);
            userService.modifier(user);

            // show a success message to the user
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Modification du mot de passe");
            alert.setHeaderText(null);
            alert.setContentText("Votre mot de passe a été modifié avec succès!");
            alert.showAndWait();
        } else {
            // show an error message to the user indicating that the passwords don't match
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de confirmation du mot de passe");
            alert.setHeaderText(null);
            alert.setContentText("Les mots de passe ne correspondent pas. Veuillez réessayer.");
            alert.showAndWait();
        }
    }
}
