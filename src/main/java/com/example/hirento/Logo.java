package com.example.hirento;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Logo {

    @FXML
    private ImageView logo;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label loadingLabel;

    @FXML
    public void initialize() {
        if (progressBar != null) {
            progressBar.setProgress(0);
        }
        if (loadingLabel != null) {
            loadingLabel.setText("Loading... 0%");
        }

        progressBar.setStyle("-fx-accent: #000000;");
        startProgressBarAnimation();

        // Move up after 3 seconds
        PauseTransition moveDelay = new PauseTransition(Duration.seconds(3));
        moveDelay.setOnFinished(e -> {
            moveUp(progressBar);
            moveUp(logo);
            moveUp(loadingLabel);
        });
        moveDelay.play();

        // Open hello-view.fxml after 4 seconds
        PauseTransition openNextFXML = new PauseTransition(Duration.seconds(3.3));
        openNextFXML.setOnFinished(e -> {
            Stage stage = (Stage) progressBar.getScene().getWindow();
            openHelloView(stage);
        });
        openNextFXML.play();
    }

    public void startProgressBarAnimation() {
        final int totalSteps = 100;
        final double durationInSeconds = 3.0;
        final double stepDuration = durationInSeconds / totalSteps;

        Timeline timeline = new Timeline();
        KeyFrame frame = new KeyFrame(Duration.seconds(stepDuration), event -> {
            double currentProgress = progressBar.getProgress();
            double newProgress = currentProgress + (1.0 / totalSteps);

            progressBar.setProgress(newProgress);
            int percent = (int) (newProgress * 100);
            loadingLabel.setText("Loading... " + percent + "%");
        });

        timeline.getKeyFrames().add(frame);
        timeline.setCycleCount(totalSteps);
        timeline.play();
    }

    private void openHelloView(Stage currentStage) {
        try {
            FXMLLoader optionsLoader = new FXMLLoader(getClass().getResource("login - Copy.fxml"));
            Parent optionsRoot = optionsLoader.load();

            Stage newStage = new Stage();
            newStage.setTitle("Login");
            newStage.setScene(new Scene(optionsRoot, 1901, 1177));
            newStage.show();

            currentStage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void moveUp(Node node) {
        if (node != null) {
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.millis(1), event -> {
                        node.setLayoutY(node.getLayoutY() - 1);
                    })
            );
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
        }
    }
}
