/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amena.gui;



import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.StageStyle;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;

/**
 *
 * @author klair
 */

public class NewFXMain extends Application {
    
   @FXML 
     private AnchorPane pane4 ;
    
    double x,y = 0;
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        
       Parent root = FXMLLoader.load(getClass().getResource("dashboard/First3.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);

       
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });

        root.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);
        });

        primaryStage.setScene(new Scene(root, 841, 631));
        primaryStage.show();
        
        
          
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
