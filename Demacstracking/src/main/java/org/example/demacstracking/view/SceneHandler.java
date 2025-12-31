package org.example.demacstracking.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class SceneHandler {

    private static final SceneHandler istance = new SceneHandler();

    private Stage stage = null ;


    public static SceneHandler getInstance() {
        return istance ;
    }

    URL loadResource(String name) {
        return SceneHandler.class.getResource("/org/example/demacstracking/fxml/" + name);
    }

    public void sceneLoader(String fxmlFile) throws IOException {
        FXMLLoader loader = new FXMLLoader(loadResource(fxmlFile));
        stage.setMinWidth(600);
        stage.setMinHeight(400);
        Scene scene = new Scene((Parent) loader.load(), 600.0, 400.0);
        stage.setScene(scene);
        stage.setTitle("Demacs Tracking");
        stage.show();

    }

    public void init(Stage stage) throws IOException {
        this.stage = stage;
        sceneLoader("HomePageDemacsTracking.fxml");
    }
}