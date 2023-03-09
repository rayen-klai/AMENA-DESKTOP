/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digidreamers.amena.gui;

import digidreamers.amena.services.JokesApiService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Ahlem
 */
public class JokeController implements Initializable {

    @FXML
    private Label id_joke;
    @FXML
    private VBox vbox_joke;
    @FXML
    private Button myButton;
    @FXML
    private Label myLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void refreshJokeClick(ActionEvent event) {
        try {
            JokesApiService jokeApi = new JokesApiService();
            String jokes = jokeApi.getRandomJokes();
            Label responseLabel = new Label(jokes.toString());

            myLabel.setText(jokes);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
