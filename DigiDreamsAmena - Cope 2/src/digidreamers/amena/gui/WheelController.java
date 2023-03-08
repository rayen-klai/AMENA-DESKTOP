/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digidreamers.amena.gui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Affine;

public class WheelController {

    @FXML
    private Canvas canvas;

    private double spinAngle = 0;
    @FXML
    private Button btnRet;
    @FXML
    private AnchorPane pane23;
    private Timeline timeline;

    @FXML
    public void spin() {

        // Generate a random angle between 0 and 359 degrees
        Random random = new Random();
        double randomAngle = random.nextDouble() * 360;
        // Add the random angle to the current spin angle
        spinAngle += randomAngle;

        // Create a new animation that rotates the wheel by the random angle
        canvas.getGraphicsContext2D().save();
        Affine rotate = new Affine();
        rotate.appendRotation(spinAngle, canvas.getWidth() / 2, canvas.getHeight() / 2);
        canvas.getGraphicsContext2D().setTransform(rotate);
        drawWheel(canvas.getGraphicsContext2D());
        canvas.getGraphicsContext2D().restore();
    }

    private void drawWheel(GraphicsContext gc) {
        // Draw the outer circle of the wheel
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(5);
        gc.strokeOval(5, 5, gc.getCanvas().getWidth() - 10, gc.getCanvas().getHeight() - 10);

        // Draw the colored segments of the wheel
        double segmentAngle = 360 / 8;
        Color[] segmentColors = {Color.ANTIQUEWHITE, Color.ALICEBLUE, Color.CORAL, Color.YELLOWGREEN, Color.DARKGRAY, Color.DARKTURQUOISE, Color.MEDIUMPURPLE, Color.GRAY};
        for (int i = 0; i < 8; i++) {
            gc.setFill(segmentColors[i]);
            gc.fillArc(5, 5, gc.getCanvas().getWidth() - 10, gc.getCanvas().getHeight() - 10, i * segmentAngle, segmentAngle, javafx.scene.shape.ArcType.ROUND);
        }

        // Draw the text in the center of each segment
        gc.setFont(javafx.scene.text.Font.font(20));
        gc.setFill(Color.WHITE);
        for (int i = 0; i < 8; i++) {
            double centerX = gc.getCanvas().getWidth() / 2;
            double centerY = gc.getCanvas().getHeight() / 2;
            double textAngle = (i * segmentAngle) + (segmentAngle / 2);
            gc.save();
            gc.translate(centerX, centerY);
            gc.rotate(textAngle);
            gc.translate(-centerX, -centerY);
            gc.fillText(" " + (i + 1), centerX - 40, centerY - 5);
            gc.restore();
        }
    }

    @FXML
    private void retournerverT(ActionEvent event) {
        try {
            Parent sv;
            sv = (AnchorPane) FXMLLoader.load(getClass().getResource("InterfaceTransporteur.fxml"));
            pane23.getChildren().removeAll();
            pane23.getChildren().setAll(sv);
        } catch (IOException ex) {
            Logger.getLogger(DetailsGiftsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
