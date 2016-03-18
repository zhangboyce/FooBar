package com.foobar.javafx.tool.keywordshandler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * User: Boyce
 * Date: 16/3/15
 * Time: 16:55
 */
public class KeywordsHandlerApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(KeywordsHandlerApp.class.getResource("KeywordsHandlerOverview.fxml"));
        GridPane gridPane =  loader.load();
//        gridPane.setGridLinesVisible(true);
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        KeywordsHandlerController controller = loader.getController();
        controller.setStageAndSetupListeners(stage);

        Scene scene = new Scene(gridPane, 700, 1100);
        stage.setScene(scene);

        stage.setTitle("Keywords Handler");
        stage.setHeight(700);
        stage.setWidth(1100);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
