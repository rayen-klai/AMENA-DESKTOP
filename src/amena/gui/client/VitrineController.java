/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amena.gui.client;


import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Pagination;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author klair
 */
public class VitrineController implements Initializable {

    private ScrollPane anchscroll;
    @FXML
    private AnchorPane pane;
 private static final int PAGE_SIZE = 10;
    private static final int NUM_ITEMS = 100;

   


    private Node createPage(int pageIndex) {
        VBox page = new VBox(10);
        int startIndex = pageIndex * PAGE_SIZE;
        int endIndex = Math.min(startIndex + PAGE_SIZE, NUM_ITEMS);
        for (int i = startIndex; i < endIndex; i++) {
            HBox hbox = new HBox(30);
Pane pane1 = new Pane();
 GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Create the labels
        Text nameLabel = new Text("Name:");
        nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        Text ageLabel = new Text("Age:");
        ageLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        Text occupationLabel = new Text("Occupation:");
        occupationLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        // Add the labels to the GridPane
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(ageLabel, 0, 1);
        gridPane.add(occupationLabel, 0, 2);

        // Create an ImageView to hold the image
        Image image = new Image("https://www.example.com/image.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);

        // Create a Pane to hold the GridPane and ImageView
        Pane pane2 = new Pane();
        Pane pane3 = new Pane();
       
        pane2.setStyle("-fx-background-color: black;");
        pane3.setStyle("-fx-background-color: black;");
        pane3.setStyle("-fx-background-color: black;");
        
        pane1.getChildren().addAll(gridPane, imageView);
        pane2.getChildren().addAll(gridPane, imageView);
        pane3.getChildren().addAll(gridPane, imageView);


        hbox.getChildren().addAll(pane1, pane2, pane3);
            page.getChildren().add(hbox);
        }
        return page;
    }

 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
 Pagination pagination = new Pagination(NUM_ITEMS / PAGE_SIZE, 0);
        pagination.setPageFactory(pageIndex -> createPage(pageIndex));

        VBox root = new VBox(10);      
        pane.getChildren().addAll(pagination) ; 
        
    }    
    
}
