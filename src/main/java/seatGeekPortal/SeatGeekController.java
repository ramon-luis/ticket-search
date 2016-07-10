package seatGeekPortal;

import javafx.collections.FXCollections;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.collections.ObservableList;

import java.net.URL;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.ResourceBundle;
import java.text.SimpleDateFormat;

public class SeatGeekController implements Initializable {

    @FXML
    private AnchorPane fxAnchorPane;
    @FXML
    private Pane fxTopPane;
    @FXML
    private VBox fxVbox;
    @FXML
    private Label fxLabel;
    @FXML
    private TextField fxSearchBox;
    @FXML
    private Button fxFindButton;
    @FXML
    private Pane fxBottomPane;
    @FXML
    private ListView<String> fxList;

    public void initialize(URL url, ResourceBundle rb) {







        final Service eventFinder = new Service<ObservableList<String>>() {

            @Override
            protected Task createTask() {
                return new Task<ObservableList<String>>() {
                    protected ObservableList<String> call() throws InputMismatchException {
                        String sSearchInput = fxSearchBox.getText();
                        SeatGeekTask seatGeekAPI = new SeatGeekTask(sSearchInput);
                        ArrayList<Event> events = seatGeekAPI.getEvents();
                        ArrayList<String> eventDescriptions = new ArrayList<>();
                        for (Event e : events) {
                            eventDescriptions.add(e.getTitle() + " : " + e.getVenue().getName() + " : " + e.getDatetimeLocal());
                        }
                    return FXCollections.observableArrayList(eventDescriptions);
                    }

                };
            }
        };


        // search when button is clicked
        fxFindButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!eventFinder.isRunning()) {
                    eventFinder.reset();
                    eventFinder.start();
                }
            }
        });

        // bind relevant properties to the controls
        fxFindButton.disableProperty().bind(eventFinder.runningProperty());
        fxList.itemsProperty().bind(eventFinder.valueProperty());


    }

}