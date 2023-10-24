package com.example.x_ogame;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class MainControllerClient implements Initializable {
    int x;
    private boolean isMyTurn=false;
    private boolean gameOver=false;
    public static Socket client;
    private   OutputStream out;
    private InputStream in;
    private Button buttons[]=new Button[10];
    @FXML
    private Label statusLabel;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Button button6;

    @FXML
    private Button button3;

    @FXML
    void click1(ActionEvent event) {
        if(isMyTurn){
            button1.setText("O");
            button1.setDisable(true);
            checkStatus();
            isMyTurn=false;
            send(1);
        }
    }

    @FXML
    void click2(ActionEvent event) {
        if(isMyTurn){
            button2.setText("O");
            button2.setDisable(true);
            checkStatus();
            isMyTurn=false;
            send(2);
        }
    }

    @FXML
    void click3(ActionEvent event) {
        if(isMyTurn){
            button3.setText("O");
            button3.setDisable(true);
            checkStatus();
            isMyTurn=false;
            send(3);
        }
    }

    @FXML
    void click4(ActionEvent event) {
        if(isMyTurn){
            button4.setText("O");
            button4.setDisable(true);
            checkStatus();
            isMyTurn=false;
            send(4);
        }
    }

    @FXML
    void click5(ActionEvent event) {
        if(isMyTurn){
            button5.setText("O");
            button5.setDisable(true);
            checkStatus();
            isMyTurn=false;
            send(5);
        }
    }

    @FXML
    void click6(ActionEvent event) {
        if(isMyTurn){

            button6.setText("O");
            button6.setDisable(true);
            checkStatus();
            isMyTurn=false;
            send(6);
        }
    }

    @FXML
    void click7(ActionEvent event) {
        if(isMyTurn){

            button7.setText("O");
            button7.setDisable(true);
            checkStatus();
            isMyTurn=false;
            send(7);
        }
    }

    @FXML
    void click8(ActionEvent event) {
        if(isMyTurn){
            button8.setText("O");
            button8.setDisable(true);
            checkStatus();
            isMyTurn=false;
            send(8);
        }
    }

    @FXML
    void click9(ActionEvent event) {
        if(isMyTurn){
            button9.setText("O");
            button9.setDisable(true);
            checkStatus();
            isMyTurn=false;
            send(9);
        }
    }

    @FXML
    void exit(ActionEvent event) {
        gameOver=true;
    }
    private void checkStatus(){
        String text1=button1.getText();
        String text2=button2.getText();
        String text3=button3.getText();
        String text4=button4.getText();
        String text5=button5.getText();
        String text6=button6.getText();
        String text7=button7.getText();
        String text8=button8.getText();
        String text9=button9.getText();
        if(text1.equals(text3) && text3.equals(text2) &&(text1.equals("X")||text1.equals("O"))){
            statusLabel.setText("player"+text1+"wins");
            gameOver=true;
        } else if (text4.equals(text5) && text5.equals(text6) &&(text4.equals("X")||text4.equals("O"))) {
            statusLabel.setText("player"+text4+"wins");
            gameOver=true;
        } else if (text7.equals(text8) && text8.equals(text9) &&(text7.equals("X")||text7.equals("O"))) {
            statusLabel.setText("player"+text7+"wins");
            gameOver=true;
        } else if (text1.equals(text4) && text4.equals(text7) &&(text1.equals("X")||text1.equals("O"))) {
            statusLabel.setText("player"+text1+"wins");
            gameOver=true;
        } else if (text2.equals(text5) && text5.equals(text8) &&(text2.equals("X")||text2.equals("O"))) {
            statusLabel.setText("player"+text2+"wins");
            gameOver=true;
        } else if (text3.equals(text6) && text6.equals(text9) &&(text3.equals("X")||text3.equals("O"))) {
            statusLabel.setText("player"+text3+"wins");
            gameOver=true;
        } else if (text1.equals(text5) && text5.equals(text9) &&(text1.equals("X")||text1.equals("O"))) {
            statusLabel.setText("player"+text1+"wins");
            gameOver=true;
        } else if (text3.equals(text5) && text5.equals(text7) &&(text3.equals("X")||text3.equals("O"))) {
            statusLabel.setText("player"+text3+"wins");
            gameOver=true;
        }
    }
    public void send(int whichOne)  {
        if(gameOver==false){
            DataOutputStream outputStream=new DataOutputStream(out);
            try {
                outputStream.writeInt(whichOne);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            isMyTurn=false;
            statusLabel.setText("it is not your turn");
            Task<Void> task=new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    recieve();
                    return null;
                }
            };
            new Thread(task).start();
            task.setOnSucceeded((e)->{
                buttons[x-1].setText("X");
                buttons[x-1].setDisable(true);
                isMyTurn = true;
                statusLabel.setText("it is your turn");
            });
        }else{
            try {
                client.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons= new Button[]{button1, button2, button3, button4,button5,button6,button7,button8,button9};
        try {
            out=client.getOutputStream();
            in=client.getInputStream();
            Task<Void> task=new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    recieve();
                    return null;
                }
            };
            new Thread(task).start();
            task.setOnSucceeded((e)->{
                buttons[x-1].setText("X");
                buttons[x-1].setDisable(true);
                isMyTurn = true;
                statusLabel.setText("it is your turn");
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void recieve() {
        if(gameOver==false) {
            try {
                DataInputStream inputStream=new DataInputStream(in);
                 x = inputStream.readInt();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            try {
                client.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

