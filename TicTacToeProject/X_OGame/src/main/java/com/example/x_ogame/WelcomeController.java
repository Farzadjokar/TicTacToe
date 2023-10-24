package com.example.x_ogame;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class WelcomeController implements Initializable {
    @FXML
   private Label lbl;

    @FXML
    private ComboBox<String> themeCombo;

    @FXML
    void PlayOnline(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader();
        Parent root=loader.load(WelcomeController.class.getResource("createGame.fxml"));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lbl.setTextFill(Color.WHITE);
        ObservableList<String> list= FXCollections.observableArrayList("dark","light");
        themeCombo.getItems().addAll(list);
        themeCombo.getSelectionModel().selectedItemProperty().addListener((E,F,H)->{
            if(H.equals("dark")){
HelloApplication.setUserAgentStylesheet(HelloApplication.class.getResource("primer-dark.css").toExternalForm());
                lbl.setTextFill(Color.WHITE);
            }else {
HelloApplication.setUserAgentStylesheet(HelloApplication.class.getResource("primer-light.css").toExternalForm());
                lbl.setTextFill(Color.BLACK);
            }
        });
    }


}


























