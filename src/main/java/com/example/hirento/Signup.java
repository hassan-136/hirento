package com.example.hirento;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;

public class Signup {


    @FXML
    private VBox nextVBox;
    @FXML
    private VBox nextVBox1;

    @FXML
    private ListView<String> list;


    @FXML
    private Button nextButton2, loginButton2, exitButton2;
    @FXML
    private Button nextButton21, loginButton21, exitButton21;

    @FXML
    public void initialize() {

        nextVBox.setVisible(false);
        nextVBox1.setVisible(true);


        list.getItems().addAll("Customer", "Renter", "Worker");


        list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    @FXML
    private void handleNext() {

        nextVBox1.setVisible(false);
        nextVBox.setVisible(true);
    }


    @FXML
    private void handleLogin() {

        System.out.println("Login clicked");
    }
    @FXML
    private void handleExit() {

        System.exit(0);
    }
}
