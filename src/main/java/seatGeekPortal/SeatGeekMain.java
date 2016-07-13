package seatGeekPortal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main driver class
 */

public class SeatGeekMain extends Application {

    // for Java7 and earlier
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        // FXML & root node
        String fxmlFile = "/fxml/seatGeek.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = loader.load(getClass().getResourceAsStream(fxmlFile));

        // create scene from root node and add CSS
        Scene scene = new Scene(rootNode);
        scene.getStylesheets().add("/styles/seatGeek.css");

        // set title, scene, and show
        stage.setTitle("SeatGeek");
        stage.setScene(scene);
        stage.show();
    }
}
