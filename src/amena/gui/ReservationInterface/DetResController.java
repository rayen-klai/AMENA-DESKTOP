/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amena.gui.ReservationInterface;

import amena.gui.LocationInterface.GestionLocationController;
import amena.model.Reservation;
import amena.model.Vehicule;
import amena.services.ReservationCRUD;
import amena.services.VehiculeCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javafx.util.Duration;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.control.Alert;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;


/**
 * FXML Controller class
 *
 * @author klair
 */
public class DetResController implements Initializable {
    public static final String ACCOUNT_SID = "AC0643a8413f76b0e5bdd8ea93378281d0";
    public static final String AUTH_TOKEN = "b7ac1675999e153eea5e5a5f9fb9979e";
    @FXML
    private Label nom;
    @FXML
    private Label prenom;
    @FXML
    private Label num;
    @FXML
    private Label mat;
    @FXML
    private Label mar;
    @FXML
    private Label mod;
    @FXML
    private Label deb;
    @FXML
    private Label fin;
    @FXML
    private Label mon;
    @FXML
    private Label etat;
    @FXML
    private Label temp;
    @FXML
    private ImageView imgc;
    @FXML
    private ImageView imgv;
    @FXML
    private AnchorPane panedr;
    Reservation r;
Vehicule v ;
VehiculeCRUD vc ; 
 ReservationCRUD rc ; 
    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         vc = new VehiculeCRUD();
        rc = new ReservationCRUD();
        r = rc.getByID(ResInterController.ids);
         v = vc.getByID(r.getIdVeh());

        imgv.setImage(new Image(v.getImg()));
        mat.setText(v.getImmat());
        mar.setText(v.getMarque());
        mod.setText(v.getModele());

        deb.setText(r.getDate_deb().toString());
        fin.setText(r.getDate_fin().toString());
        mon.setText(Float.toString(r.getSomme()));
        Date df;
        df = r.getDate_fin();
      LocalDate date = LocalDate.parse(r.getDate_fin().toString());
    int year = date.getYear();
    int month = date.getMonthValue();
    int day = date.getDayOfMonth();
        CountdownDays cd = new CountdownDays(year,month,day);
        temp.setText(cd.updateCountdown());
        
        if( Integer.parseInt(cd.updateCountdown()) <=0 && !r.isEtat())
            etat.setText("En retard");
        else if (Integer.parseInt(cd.updateCountdown())>0)
             etat.setText("En cours");
        else
             etat.setText("terminé");


            

    }

    @FXML
    private void profil(ActionEvent event) {
    }

    @FXML
    private void vehicule(ActionEvent event) {
        GestionLocationController.ids = r.getIdVeh();

        try {
            Parent sv;
            sv = (AnchorPane) FXMLLoader.load(getClass().getResource("../detaille/detaille.fxml"));
            panedr.getChildren().removeAll();
            panedr.getChildren().setAll(sv);
        } catch (IOException ex) {
            Logger.getLogger(DetResController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void updateEtat(ActionEvent event) {
        rc.modifier_etat(r);
        vc.modifier_etat(r.getIdVeh());
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Etat modifié !");
            alert.showAndWait();
    }

    @FXML
    private void sendmail(ActionEvent event) {
         Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        // Envoi du SMS
        Message message = Message.creator(new PhoneNumber("+21625363115"),
                new PhoneNumber("+12766630621"),
                "Amena vous rapelle que votre reservation de la vehicule se termine au   " + r.getDate_fin()).create();

        // Affichage du SID du message dans une fenêtre de dialogue
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation de livraison");
        alert.setHeaderText(null);
        alert.setContentText("Le message a été envoyé avec succès ! SID : " + message.getSid());
        alert.showAndWait();
    }

}
