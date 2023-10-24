package com.example.x_ogame;


import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.concurrent.Executors;

public class CreateGameController {

    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader();
        Parent root=loader.load(WelcomeController.class.getResource("welcome.fxml"));
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void createGame(ActionEvent event) throws IOException {
      FXMLLoader loader=new FXMLLoader(WelcomeController.class.getResource("wait.fxml"));
        Parent root= loader.load();
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void joinGame(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(WelcomeController.class.getResource("join.fxml"));
        Parent root= loader.load();
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

}

