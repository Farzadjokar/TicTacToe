package com.example.x_ogame;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class WaitController {
    public void initialize(){
        System.out.println("Hi jokar");
        go.setDisable(true);
        Task<Boolean> task=new Task<Boolean>() {
            @Override
            protected Boolean call() throws Exception {
                try {
                    ServerSocket server = new ServerSocket(port);
                    Socket socket=server.accept();
                    MainControllerServer.server=socket;
                }catch(IOException exception){
                    System.err.println("this port is occupy by another server");
                }
                return true;
            }
        };
new Thread(task).start();
task.setOnSucceeded((event)->{
    try {
    waitLabel.setText("player joined");
    go.setDisable(false);
    FXMLLoader loader=new FXMLLoader();
    Parent root=loader.load(WelcomeController.class.getResource("MainGameServer.fxml"));
    Stage stage=(Stage) pane.getScene().getWindow();
    stage.setScene(new Scene(root));
    stage.show();
    }catch (Exception x){
        x.printStackTrace();
    }
});
    }
    private static final int port=1080;
    @FXML
     Label waitLabel;

    @FXML
    BorderPane pane;

    @FXML
     void cancelBTN(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader();
        Parent root=loader.load(WelcomeController.class.getResource("createGame.fxml"));
        Stage stage=(Stage) ((Button)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private Button go;
    @FXML
    void gobtn(ActionEvent event) throws IOException {
    }
}
