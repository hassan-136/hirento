package com.example.hirento;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button signUpButton;

    @FXML
    private Button exitButton;

    @FXML
    private VBox mainVBox;

    @FXML
    public void initialize() {
        applyHoverEffect(usernameField);
        applyHoverEffect(passwordField);
        applyHoverEffect(loginButton);
        applyHoverEffect(signUpButton);
        applyHoverEffect(exitButton);
        applyHoverEffect(mainVBox);

        usernameField.clear();
        passwordField.clear();
        usernameField.requestFocus();
    }

    @FXML
    public void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals("admin") && password.equals("admin123")) {
            openDashboard();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText("Invalid Credentials");
            alert.setContentText("The username or password you entered is incorrect.");
            alert.showAndWait();
        }
    }

    @FXML
    public void handleSignUp() {
        try {
            FXMLLoader signupLoader = new FXMLLoader(getClass().getResource("signup.fxml"));
            Parent signupRoot = signupLoader.load();
            Stage newStage = new Stage();
            newStage.setTitle("Sign Up");
            newStage.setScene(new Scene(signupRoot));
            newStage.show();
            Stage currentStage = (Stage) signUpButton.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleExit() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    private void openDashboard() {
        try {
            FXMLLoader dashboardLoader = new FXMLLoader(getClass().getResource("logo.fxml"));
            Parent dashboardRoot = dashboardLoader.load();
            Stage newStage = new Stage();
            newStage.setTitle("Dashboard");
            newStage.setScene(new Scene(dashboardRoot));
            newStage.show();
            Stage currentStage = (Stage) loginButton.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void applyHoverEffect(javafx.scene.Node node) {
        node.setOnMouseEntered(e -> {
            node.setScaleX(1.1);
            node.setScaleY(1.1);
        });

        node.setOnMouseExited(e -> {
            node.setScaleX(1.0);
            node.setScaleY(1.0);
        });
    }
}
