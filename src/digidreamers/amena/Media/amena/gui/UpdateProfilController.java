package amena.gui;

import amena.model.User;
import amena.services.UserService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class UpdateProfilController implements Initializable {

    @FXML
    private ListView<User> selectedListView;
    @FXML
    private TextField nomTextField;
    @FXML
    private TextField prenomTextField;
    @FXML
    private TextField adresseTextField;
    @FXML
    private TextField cinTextField;
    @FXML
    private DatePicker dateNaissanceTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField motDePasseTextField;
    @FXML
    private Button modifierButton;

    private UserService userService;
    @FXML
    private Button btnback;
    Date date = new java.sql.Date(new java.util.Date().getTime());

    @FXML
    private CheckBox fxclient;
    @FXML
    private CheckBox fxtransoorteur;
    @FXML
    private ImageView img;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            userService = new UserService();
            selectedListView.getItems().addAll(userService.afficher());

            selectedListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<User>() {
                @Override
                public void changed(ObservableValue<? extends User> observable, User oldValue, User newValue) {
                    // code qui s'exécute lorsque l'utilisateur sélectionne un élément dans la liste
                    User user = selectedListView.getSelectionModel().getSelectedItem();
                    // récupérer l'utilisateur sélectionné
                    int a = user.getId();
                    emailTextField.setText(user.getEmail());
                    nomTextField.setText(user.getNom());
                    prenomTextField.setText(user.getPrenom());
                    adresseTextField.setText(user.getAdress());
                    cinTextField.setText(user.getCin());
                    // convert java.sql.Date to LocalDate and set it in DatePicker
                    java.sql.Date sqlDate = user.getDate_naissance();
                    LocalDate localDate = sqlDate.toLocalDate();
                    dateNaissanceTextField.setValue(localDate);
                    File file = new File(user.getImage());
                    FileInputStream fileInputStream;
                    try {
                        fileInputStream = new FileInputStream(file);
                        Image image = new Image(fileInputStream);
                        img.setImage(image);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(UpdateProfilController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    String role = "";
                    if (user.getRole().equals("transporteur")) {

                        fxtransoorteur.isSelected();
                        return;
                    } else if (user.getRole().equals("client")) {

                        fxclient.isSelected();
                        return;
                    }

                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(UpdateProfilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void modifierUtilisateur(ActionEvent event) throws SQLException {
        User user = selectedListView.getSelectionModel().getSelectedItem();

        if (user != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir modifier cet utilisateur ?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {

                String nom = nomTextField.getText().trim();
                String prenom = prenomTextField.getText().trim();
                String adresse = adresseTextField.getText().trim();
                String cin = cinTextField.getText().trim();
                String email = emailTextField.getText().trim();
                String motDePasse = motDePasseTextField.getText().trim();
                LocalDate dateNaissance = dateNaissanceTextField.getValue();

                if (!dateNaissanceTextField.getEditor().getText().trim().isEmpty()) {
                    try {
                        dateNaissance = dateNaissanceTextField.getValue();
                    } catch (DateTimeException ex) {
                        Alert dateAlert = new Alert(Alert.AlertType.ERROR);
                        dateAlert.setTitle("Erreur");
                        dateAlert.setHeaderText(null);
                        dateAlert.setContentText("Veuillez saisir une date de naissance valide !");
                        dateAlert.showAndWait();
                        return;
                    }
                }

                if (nom.isEmpty() || prenom.isEmpty() || adresse.isEmpty() || cin.isEmpty() || email.isEmpty() || motDePasse.isEmpty() || dateNaissance == null) {
                    Alert emptyAlert = new Alert(Alert.AlertType.ERROR);
                    emptyAlert.setTitle("Erreur");
                    emptyAlert.setHeaderText(null);
                    emptyAlert.setContentText("Tous les champs sont obligatoires !");
                    emptyAlert.showAndWait();
                    return;
                }

                if (!email.matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")) {
                    Alert emailAlert = new Alert(Alert.AlertType.ERROR);
                    emailAlert.setTitle("Erreur");
                    emailAlert.setHeaderText(null);
                    emailAlert.setContentText("Veuillez saisir une adresse email valide !");
                    emailAlert.showAndWait();
                    return;
                }

                if (cin.length() != 8) {
                    Alert cinAlert = new Alert(Alert.AlertType.ERROR);
                    cinAlert.setTitle("Erreur");
                    cinAlert.setHeaderText(null);
                    cinAlert.setContentText("Veuillez saisir un numéro de cin valide (8 chiffres) !");
                    cinAlert.showAndWait();
                    return;
                }
                String role = "";
                if (user.getRole().equals("transporteur")) {
                    fxtransoorteur.setSelected(true);
                } else if (user.getRole().equals("client")) {
                    fxclient.setSelected(true);
                }

                User u1 = userService.getUserByEmai(user.getEmail());
                u1.setId(user.getId());
                u1.setEmail(email);
                u1.setNom(nom);
                u1.setPrenom(prenom);
                u1.setAdress(adresse);
                u1.setCin(cin);
                u1.setMot_pass(motDePasse);

                u1.setRole(role);
                //user.setDate_creation_c(date_creation_c);

                userService.modifier(u1);

                ObservableList<User> users = FXCollections.observableArrayList(userService.afficher());
                selectedListView.setItems(users);

            }
        } else {
            Alert selectAlert = new Alert(Alert.AlertType.ERROR);
            selectAlert.setTitle("Erreur");
            selectAlert.setHeaderText(null);
            selectAlert.setContentText("Veuillez sélectionner un utilisateur !");
            selectAlert.showAndWait();
        }
    }
    private Button btnProfil;

    public void initialize() {
        btnProfil.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("profil.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnProfil.getScene().getWindow();
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    @FXML
    private void back(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Profil.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

    }

}
