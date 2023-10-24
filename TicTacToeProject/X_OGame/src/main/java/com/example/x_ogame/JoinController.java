package com.example.x_ogame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;

public class JoinController {

    @FXML
    private TextField text;

    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader();
        Parent root=loader.load(WelcomeController.class.getResource("welcome.fxml"));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void textField(ActionEvent event) {
       try {
           Socket socket = new Socket(text.getText(), 1080);
           MainControllerClient.client=socket;
           FXMLLoader loader=new FXMLLoader();
           Parent root=loader.load(WelcomeController.class.getResource("MainGameClient.fxml"));
           Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
           stage.setScene(new Scene(root));
           stage.show();
       }catch(IOException e){
           text.setText("wrong ip");
       }
    }

}

