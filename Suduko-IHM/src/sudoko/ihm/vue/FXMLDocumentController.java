/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sudoko.ihm.vue;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.controlsfx.dialog.Dialogs;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import sudoku.ihm.model.data.sample.DataSample;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

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
    
    // Partie JulianC
    @FXML   private StackPane panes;
    @FXML   private Pane paneUser;
    @FXML   private Pane paneGroup;
    @FXML   private ListView listGroups;
    @FXML   private ListView listUsers;
    @FXML   private Label user;
    @FXML   private Label name;
    @FXML   private Label birthD;
    @FXML   private Label nombUsers;
    @FXML   private Button goToGrids;
    @FXML   private Button delFromGroup;
    @FXML   private Button newGroup;
    @FXML   private TextField nameGroup;
    @FXML   private Button delGroup;
    
    public static final ObservableList groups = FXCollections.observableArrayList();
    public static final ObservableList users  = FXCollections.observableArrayList();
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        instance = new DataSample();
        userName.setText(instance.a.getPseudo());
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
                            Dialogs.create()
                .title("Message")
                .masthead("Message d'information")
                .message("Youhou ...")
                .showInformation();
            }
        });
        assert panes != null : "fx:id=\"panes\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert paneUser != null : "fx:id=\"paneUser\" was not injected: check your FXML file 'FXMLDocument.fxml'.";        
        assert paneGroup != null : "fx:id=\"paneGroup\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert listGroups != null : "fx:id=\"listGroups\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert listUsers != null : "fx:id=\"listUsers\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert user != null : "fx:id=\"user\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert birthD != null : "fx:id=\"birthD\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert goToGrids != null : "fx:id=\"goToGrids\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert delFromGroup != null : "fx:id=\"delFromGroup\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert newGroup != null : "fx:id=\"newGroup\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert nameGroup != null : "fx:id=\"nameGroup\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert delGroup != null : "fx:id=\"delGroup\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
                
        //Ajouter des éléments aux listes groupes et utilisateurs
        groups.addAll("Global", "Amis", "Camarades");
        users.addAll("julian", "user2", "user3");        
        listGroups.setItems(groups);
        listUsers.setItems(users);
        
        listUsers.setOnDragDetected(new EventHandler <MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("yuurt");
            }
        });
        
        listGroups.setOnDragEntered(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                System.out.println("yooort");
            }
        });

        
        //Méthode Bouton "Aller aux grilles"
        goToGrids.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e) {
            Dialogs.create()
                .title("Message")
                .masthead("Message d'information")
                .message("Vous allez aux grilles de l'utilisateur: "+user.getText())
                .showInformation();
            }
        });
        
        delFromGroup.setOnAction(null);
        
        //Méthode Bouton "Supprimer du groupe"
        delFromGroup.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e) {
                Action response = Dialogs.create()
                    .owner(null)
                    .title("Confirm Dialog")
                    .message("Voulez-vous supprimer l'utilisateur '"+user.getText()+"' du groupe '"+nameGroup.getText()+"'?")
                    .showConfirm();

                if (response == Dialog.ACTION_YES) {
                    Dialogs.create()
                        .title("Message")
                        .message("L'utilisateur '"+user.getText()+"' sera supprimé")
                        .showInformation();
                } else {
                    // ... utilisateur choisit NO, CANCEL, ou ferme le dialog
                }
            }
        });
        
        //Méthode Bouton "Nouveau Groupe"
        newGroup.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e) {
                Dialogs.create()
                    .title("Message")
                    .masthead("Message d'information")
                    .message("Créer un nouveau groupe ")
                    .showInformation();
            }
        });
        
        //Méthode Bouton "Supprimer Groupe"
        delGroup.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e) {
                Action response = Dialogs.create()
                    .owner(null)
                    .title("Confirm Dialog")
                    .message("Voulez-vous supprimer le groupe '"+nameGroup.getText()+"'?")
                    .showConfirm();

                if (response == Dialog.ACTION_YES) {
                    Dialogs.create()
                        .title("Message")
                        .message("Le groupe '"+nameGroup.getText()+"' sera supprimé")
                        .showInformation();
                } else {
                    // ... utilisateur choisit NO, CANCEL, ou ferme le dialog
                }
            }
        });
        
        //Méthode ListView Groupes -> OnClick
        listGroups.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<String>() {
                public void changed(ObservableValue<? extends String> ov, 
                    String old_val, String new_val) {
                    nombUsers.setText(listUsers.getItems().size()+" utilisateurs connectés");
                    nameGroup.setText(new_val);
                    paneGroup.setVisible(true);    
                    paneUser.setVisible(false);    
            }
        });       
        
        //Méthode ListView Utilisateurs -> OnClick
        listUsers.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<String>() {
                public void changed(ObservableValue<? extends String> ov, 
                    String old_val, String new_val) {
                    user.setText(new_val);
                    paneUser.setVisible(true);
                    paneGroup.setVisible(false);                            
            }
        });
    }    
}          