/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sudoko.ihm.vue;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.controlsfx.dialog.Dialogs;
import sudoku.ihm.model.data.sample.DataSample;

/**
 *
 * @author MOURAD
 */

public class FXMLDocumentController implements Initializable {
    
    //Data
    public DataSample instance;
    public Dialogs dialog;
    @FXML
    private Button fillEmpty;
    
    @FXML
    private Button fromGrid;
    @FXML   private Label userName;
    @FXML   private ImageView avatar;
    @FXML   private Button connexion;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        instance = new DataSample();
        userName.setText(instance.a.getPseudo());
        //avatar.setImage(new Image(instance.a.getProfilePicturePath()));
        connexion.setText("Connected");
                fillEmpty.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            Dialogs.create().title("Message").masthead("Message d'information")
                .message("Message xdxxxx")
                .showInformation();
            }
        });
        fromGrid.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                dialog.title("Message");
                dialog.message("Ca marche aussi :D");
                dialog.showInformation();
            }
        });
    }    
}
