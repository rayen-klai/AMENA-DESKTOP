package amena.gui ;

import static amena.gui.Identifier_votre_compteController.emailS;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import amena.model.User;
import amena.services.UserService;

import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ActivationCController {

    @FXML
    private TextField fxToken;
    @FXML
    private Button btnvoyer;
    @FXML
    private Button btnquit;

    public ActivationCController() {
        // The no-argument constructor is required by the FXMLLoader
    }

    private void handleActivationButtonClick(ActionEvent event) throws SQLException, IOException {
        String token = fxToken.getText();
        UserService u = new UserService();
        User p = u.getUserByEmai(emailS);

        if (token.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir le champ.");
            alert.showAndWait();

        } else if (token.equals(p.getToken())) {
            p.setStatus(true);
            u.modifier(p);

            Stage stage = (Stage) btnvoyer.getScene().getWindow();
            stage.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("ResetPassword.fxml"));
            Parent root = loader.load();

            Stage resetPasswordStage = new Stage();
            resetPasswordStage.setScene(new Scene(root));
            resetPasswordStage.show();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur d'activation");
            alert.setHeaderText(null);
            alert.setContentText("Le code d'activation est invalide. Il vous reste un essai.");
            alert.showAndWait();
        }
    }

}
