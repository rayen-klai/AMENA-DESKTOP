/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amena.gui.client;

import amena.model.Reservation;
import amena.services.ReservationCRUD;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Period;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;

/**
 * FXML Controller class
 *
 * @author klair
 */
public class ReserverController implements Initializable {

    @FXML
    private DatePicker inpDate_deb;
    @FXML
    private DatePicker inpDate_fin;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void reserverBtn(ActionEvent event) throws ParseException {
    Date date_deb = Date.valueOf(inpDate_deb.getValue().toString()) ; 
    Date date_fin = Date.valueOf(inpDate_deb.getValue().toString()) ; 
/*if(date_fin.compareTo(date_deb)>0)
{
          Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("Vérifiez vos champs !");
        alert.showAndWait();
}
    else
{*/
Duration diff = Duration.between(inpDate_deb.getValue().atStartOfDay(), inpDate_fin.getValue().atStartOfDay());
        Period period = Period.between(inpDate_deb.getValue(),inpDate_fin.getValue());
        long diffDays = diff.toDays();
    ReservationCRUD rc = new ReservationCRUD() ; 
    Reservation r = new Reservation(LocationClientController.v.getId(),1,date_deb,date_fin,LocationClientController.v.getPrix()*diffDays);
    rc.ajouter(r);
    
    
    
    }
    
}
