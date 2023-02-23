/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digidreamers.amena.GUI;

import static digidreamers.amena.GUI.ProfilController.semail;
import digidreamers.amena.Models.Message;
import digidreamers.amena.Models.User;
import digidreamers.amena.Services.ChatService;
import digidreamers.amena.Services.UserService;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class ChatController implements Initializable {

    @FXML
    private AnchorPane chatPane;
   
    @FXML
    private Text chatTitle;
    @FXML
    private TextArea messageField;
    @FXML
    private Button sendButton;
    @FXML
    private ListView<Message> messageList;
    @FXML
    private ListView<User> fxlisteusert;

    /**
     * Initializes the controller class.
     */
    private UserService userService;
    private ChatService ChatService;

    @FXML
    private Button bafficher;

    public ChatController() {
        try {
            userService = new UserService();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
   public void initialize() throws SQLException {
    userService = new UserService();

    // récupérer la liste des utilisateurs à partir du service
    List<User> users = userService.afficher();

    // convertir la liste en observable list pour pouvoir l'afficher dans la liste view
    ObservableList<User> observableUsers = FXCollections.observableArrayList(users);

    // ajouter les utilisateurs à la liste view
    fxlisteusert.setItems(observableUsers);

    fxlisteusert.setCellFactory(new Callback<ListView<User>, ListCell<User>>() {
        @Override
        public ListCell<User> call(ListView<User> param) {
            return new ListCell<User>() {
                @Override
                protected void updateItem(User user, boolean empty) {
                    super.updateItem(user, empty);

                    if (user != null) {
                        // afficher le nom de l'utilisateur dans la cellule de la liste
                        setText(user.getNom());
                    } else {
                        setText(null);
                    }
                }
            };
        }
    });

    fxlisteusert.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<User>() {
        @Override
        public void changed(ObservableValue<? extends User> observable, User oldValue, User newValue) {
            // récupérer l'utilisateur sélectionné
            User user = fxlisteusert.getSelectionModel().getSelectedItem();

            // afficher le nom de l'utilisateur sélectionné dans le titre de la fenêtre de chat
            //chatTitle.setText("Chat avec " + user.getNom());
        }
    });
}
   
   
    
    private void sendMessage(ActionEvent event) throws SQLException {
        User user = fxlisteusert.getSelectionModel().getSelectedItem();

        java.sql.Date timestamp = new java.sql.Date(new java.util.Date().getTime());
        String message = messageField.getText();
        // Vérification de saisie
        if (message.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs.");
            alert.showAndWait();
            return;
        }

        UserService u = new UserService();

        User p = u.getUserByEmai(semail);
        int senderId = p.getId();
        ChatService chat = new ChatService();
        int recerveid = user.getId();
        Message m = new Message(senderId, recerveid, message, timestamp);

        chat.ajouter(m);

    }
    /*
    @FXML
private void changed(ObservableValue<? extends User> observable, User oldValue, User newValue) throws SQLException {
    User selectedUser = fxlisteusert.getSelectionModel().getSelectedItem();
    User currentUser = userService.getUserByEmai(semail);

    List<Message> messages = ChatService.getChatsBySenderReceiverIds(currentUser.getId(), selectedUser.getId());
    ObservableList<Message> observableMessages = FXCollections.observableArrayList(messages);

    messageList.setItems(observableMessages);
    messageList.setCellFactory(new Callback<ListView<Message>, ListCell<Message>>() {
        @Override
        public ListCell<Message> call(ListView<Message> listView) {
            return new ListCell<Message>() {
                @Override
                protected void updateItem(Message item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(item.getContent());
                    }
                }
            };
        }
    });
}*/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


   
}