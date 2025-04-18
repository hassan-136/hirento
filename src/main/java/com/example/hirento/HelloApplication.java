package com.example.hirento;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("logo.fxml"));
        Parent logoRoot = fxmlLoader.load();

        Scene logoScene = new Scene(logoRoot, 1901, 1177);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(logoScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
