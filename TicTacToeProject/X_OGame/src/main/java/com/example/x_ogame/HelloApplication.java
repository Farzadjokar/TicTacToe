package com.example.x_ogame;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
       Parent root=FXMLLoader.load(HelloApplication.class.getResource("welcome.fxml"));
       stage.setScene(new Scene(root));
       stage.setTitle("tic tac toe");
       stage.show();
       Application.setUserAgentStylesheet(this.getClass().getResource("primer-dark.css").toExternalForm());
    }

    public static void main(String... args) {
        launch(args);
    }
}