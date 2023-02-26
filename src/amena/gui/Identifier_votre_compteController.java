package amena.gui;

import amena.model.User;
import amena.services.UserService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Identifier_votre_compteController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField ssemails;
    @FXML
    private ListView<User> lvUser;
    @FXML
    private UserService userService;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            userService = new UserService();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        lvUser.setCellFactory(param -> new ListCell<User>() {
            @Override
            protected void updateItem(User user, boolean empty) {
                super.updateItem(user, empty);
                if (empty || user == null) {
                    setText(null);
                } else {
                    setText(user.getNom() + " " + user.getPrenom());
                }
            }
        });
    }

    @FXML
    private void EnvoyerToken(MouseEvent event) {
        String email = ssemails.getText();
        try {
            List<User> users = userService.getUsersByEmail(email);
            ObservableList<User> observableUsers = FXCollections.observableArrayList(users);
            lvUser.setItems(observableUsers);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void setUserInformation(String email) {
        ssemails.setText(email);
    }
    
}
